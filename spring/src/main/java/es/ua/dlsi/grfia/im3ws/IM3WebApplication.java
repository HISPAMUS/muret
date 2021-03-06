package es.ua.dlsi.grfia.im3ws;

import es.ua.dlsi.grfia.im3ws.muret.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

/**
 * @author drizo
 */
@SpringBootApplication
@EnableScheduling
public class IM3WebApplication {
    @Autowired
    DataSource dataSource;

    //TODO A muret
    @Autowired
    UserRepository userRepository;

    public static final void main(String[] args) {
        SpringApplication.run(IM3WebApplication.class, args);
    }


}
