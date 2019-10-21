package es.ua.dlsi.grfia.im3ws.muret.watchdog;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.model.ClassifierClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class WatchDog {
    private static final Logger logger = LoggerFactory.getLogger(WatchDog.class);
    private boolean m_serverStatus;
    private boolean m_warnSent;
    private final ClassifierClient m_restClient;
    private String m_mailToWarn;
    private String m_mailWarner;

    private final JavaMailSender m_SMTPClient;

    @Autowired
    public WatchDog(MURETConfiguration muretConfiguration, JavaMailSender sender) {
        logger.info("Server watchdog started!!");
        m_serverStatus = false;
        m_restClient = new ClassifierClient(muretConfiguration.getPythonclassifiers());
        m_SMTPClient = sender;
        m_mailToWarn = muretConfiguration.getWarningmail();
        m_mailWarner = muretConfiguration.getWarningsender();
    }

    @Scheduled(fixedRate = 60*1000)
    public void CheckServerStatus() {
        m_serverStatus = m_restClient.PingClassifierServer();

        if (!m_serverStatus) {
            if (!m_warnSent) {
                SendMailNotification();
                m_warnSent = true;
            }
        } else
            m_warnSent = false;

    }

    public boolean GetServerStatus() {
        return m_serverStatus;
    }

    private void SendMailNotification()
    {
        logger.error("Server is down, sending email...");

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(m_mailWarner);

        message.setTo(m_mailToWarn);
        message.setSubject("[WARNING] - HISPAMUS deep server is down");

        message.setText("This is an automated message to tell you that HISPAMUS deep server is no longer answering to Muret service\n" +
                "Time of failure: " + LocalDate.now().toString());

        m_SMTPClient.send(message);
    }

}
