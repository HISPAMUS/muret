package es.ua.dlsi.grfia.im3ws.muret.watchdog;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import es.ua.dlsi.grfia.im3ws.muret.model.ClassifierClient;
import es.ua.dlsi.grfia.im3ws.muret.model.UserManagerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class WatchDog {
    private static final Logger logger = LoggerFactory.getLogger(WatchDog.class);
    private final MURETConfiguration muretConfiguration;
    private boolean m_serverStatus;
    private boolean m_warnSent;
    private final ClassifierClient m_restClient;
    private String m_mailToWarn;
    private String m_mailWarner;
    private UserManagerImpl m_userManager;

    private String timeOfFailure;

    private final JavaMailSenderImpl m_SMTPClient;
    private String m_currentVersion;

    @Autowired
    public WatchDog(MURETConfiguration muretConfiguration, UserManagerImpl manager) {
        m_SMTPClient = new JavaMailSenderImpl();
        try {
            m_SMTPClient.setHost("altea.dlsi.ua.es"); //TODO parametrizar esta propiedad
            m_SMTPClient.setPort(25);
        }
        catch(Exception e) {
            logger.error("Email starting failed");
        }
        m_userManager = manager;
        m_restClient = new ClassifierClient(muretConfiguration.getBaseIIIFImagesURI(), muretConfiguration.getPythonclassifiers());
        this.muretConfiguration = muretConfiguration;
        if (muretConfiguration.isEnableWatchDogNotification()) {
            logger.info("Server watchdog started!!");
            m_serverStatus = false;
            m_mailToWarn = muretConfiguration.getWarningmail();
            m_mailWarner = muretConfiguration.getWarningsender();
            CheckUpdates(muretConfiguration.getFolder() + "/version/current_version.txt", muretConfiguration.getFolder() + "/version/patch_notes.txt");
        } else {
            logger.warn("Server watchdog disabled!!");
        }
    }

    @Scheduled(fixedRate = 60*1000) //This loop is faster because it has to catch the problem quickly to get a good timestamp
    public void CheckServerStatus() {
        m_serverStatus = m_restClient.PingClassifierServer();
        if (!m_serverStatus) {
            if (muretConfiguration.isEnableWatchDogNotification() && !m_warnSent) {
                this.timeOfFailure = LocalDateTime.now().toString();
                SendServerDownNotification();
                m_warnSent = true;
            }
        } else {
            m_warnSent = false;
        }
    }

    @Scheduled(fixedRate = 60*60*1000) //Every hour will be repeating the message
    public void RepeatMailSending()
    {
        //This means that the initial warning was sent
        if(m_warnSent)
        {
            m_serverStatus = m_restClient.PingClassifierServer();
            if(!m_serverStatus && muretConfiguration.isEnableWatchDogNotification())
                SendServerDownNotification();
        }
    }

    public boolean GetServerStatus() {
        return m_serverStatus;
    }

    private void SendServerDownNotification()
    {
        logger.error("Server is down, sending email...");

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("muretNotifications@dlsi.ua.es");

        message.setTo("arios@dlsi.ua.es");
        message.setSubject("[WARNING] - HISPAMUS deep server is down");

        message.setText("This is an automated message to tell you that HISPAMUS deep server is no longer answering to Muret service\n" +
                "Time of failure: " + this.timeOfFailure);

        m_SMTPClient.send(message);
    }

    public void sendConfirmationEmail(User userToNotify)
    {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("muretNotifications@dlsi.ua.es");

        message.setTo(userToNotify.getEmail());
        message.setSubject("Welcome to MuRet - Register confirmation");

        message.setText("Hello " + userToNotify.getFirstName() + "\n"+
                "We are sending you this message because you have registered successfully into MuRet"
                + "The data which you have registered with is: "
                + "\n Username: " + userToNotify.getUsername()
                + "\n Password: " + userToNotify.getPassword()
                + "If you have obtained a random password, please reset it inmediatelly once logged in into the application \n"
                + "----- Please, do not answer to this email, as this is an automatic notification -----\n");

        m_SMTPClient.send(message);
    }

    private void CheckUpdates(String c_versionFile, String c_patchFile)
    {
        try
        {
            File versionFile = new File(c_versionFile);
            Scanner patchReader = new Scanner(versionFile);
            m_currentVersion = patchReader.nextLine();

            File patchNotes = new File(c_patchFile);
            Scanner lineReader = new Scanner(patchNotes);
            String patchVersion = lineReader.nextLine();
            if(!patchVersion.equals(m_currentVersion))
            {
                m_currentVersion = patchVersion;
                String patchNotesText = "MuRET has been updated! Remember to use incognito mode to avoid caches problems. Here we give you a list of the recent updates:\n";
                while(lineReader.hasNextLine())
                {
                    patchNotesText += lineReader.nextLine() + "\n";
                }
                SendNewUpdateNotification(patchNotesText);

                FileWriter lineWrite = new FileWriter(versionFile);
                lineWrite.write(patchVersion);
                lineWrite.close();
            }
        }
        catch (IOException e2)
        {
            logger.error("Patch notes not found");
        }
    }

    private void SendNewUpdateNotification(String c_patchNotes)
    {
        List<User> users = m_userManager.getUsers();
        SimpleMailMessage emailMessage = new SimpleMailMessage();
        ArrayList<String> usersToEmail = new ArrayList<String>();
        users.forEach(user -> {
            usersToEmail.add(user.getEmail());
        });
        String[] emails = new String[usersToEmail.size()];
        usersToEmail.toArray(emails);
        emailMessage.setFrom(m_mailWarner);
        emailMessage.setBcc(emails);
        emailMessage.setSubject("MuRET V." + m_currentVersion + " is available");

        emailMessage.setText(c_patchNotes);

        m_SMTPClient.send(emailMessage);

        logger.info("Update sent to all GRFIA members");
    }

}
