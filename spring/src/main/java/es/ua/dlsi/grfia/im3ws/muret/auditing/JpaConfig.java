package es.ua.dlsi.grfia.im3ws.muret.auditing;

// see https://dzone.com/articles/spring-data-jpa-auditing-automatically-the-good-stuff

import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {
    @Bean
    public AuditorAware<User> auditorAware() {
        return new AuditorAwareImpl();
    }
}
