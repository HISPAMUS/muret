package es.ua.dlsi.grfia.im3ws.muret.watchdog;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import es.ua.dlsi.grfia.im3ws.muret.model.ClassifierClient;
import es.ua.dlsi.grfia.im3ws.muret.model.UserManagerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class WatchDog {
    private static final Logger logger = LoggerFactory.getLogger(WatchDog.class);
    private boolean m_serverStatus;
    private boolean m_warnSent;
    private final ClassifierClient m_restClient;
    private String m_mailToWarn;
    private String m_mailWarner;
    private UserManagerImpl m_userManager;

    private final JavaMailSender m_SMTPClient;
    private String m_currentVersion;

    @Autowired
    public WatchDog(MURETConfiguration muretConfiguration, JavaMailSender sender, UserManagerImpl manager) {
        logger.info("Server watchdog started!!");
        m_serverStatus = false;
        m_restClient = new ClassifierClient(muretConfiguration.getPythonclassifiers());
        m_SMTPClient = sender;
        m_mailToWarn = muretConfiguration.getWarningmail();
        m_mailWarner = muretConfiguration.getWarningsender();

        m_userManager = manager;
        CheckUpdates(muretConfiguration.getFolder() + "/version/current_version.txt", muretConfiguration.getFolder() + "/version/patch_notes.txt");
    }

    @Scheduled(fixedRate = 60*1000)
    public void CheckServerStatus() {
        m_serverStatus = m_restClient.PingClassifierServer();

        if (!m_serverStatus) {
            if (!m_warnSent) {
                SendServerDownNotification();
                m_warnSent = true;
            }
        } else
            m_warnSent = false;

    }

    public boolean GetServerStatus() {
        return m_serverStatus;
    }

    private void SendServerDownNotification()
    {
        logger.error("Server is down, sending email...");

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(m_mailWarner);

        message.setTo(m_mailToWarn);
        message.setTo();
        message.setSubject("[WARNING] - HISPAMUS deep server is down");

        message.setText("This is an automated message to tell you that HISPAMUS deep server is no longer answering to Muret service\n" +
                "Time of failure: " + LocalDate.now().toString());

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
                String patchNotesText = "";
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
        emailMessage.setTo(emails);
        emailMessage.setSubject("MuRET V." + m_currentVersion + " is available");

        emailMessage.setText(c_patchNotes);

        m_SMTPClient.send(emailMessage);

        logger.info("Update sent to all GRFIA members");
    }

}
