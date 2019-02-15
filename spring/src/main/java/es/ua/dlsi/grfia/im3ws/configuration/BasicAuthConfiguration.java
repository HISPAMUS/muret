package es.ua.dlsi.grfia.im3ws.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
public class BasicAuthConfiguration
        extends WebSecurityConfigurerAdapter {

    @Autowired
    MURETConfiguration muretConfiguration;

    //TODO
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
                auth
                .inMemoryAuthentication()
                .withUser("username")
                .password("{noop}password")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http)
            throws Exception {
        if (muretConfiguration.isDisableSecurity()) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Disabling http security");
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Enabling http security");
            http.csrf().disable()
                    .authorizeRequests()
                    //TODO Revisar esto, creo que me estoy saltando la autenticación
                    //.antMatchers("/muretapi/auth/login", "/muretapi/**").permitAll()
                    .antMatchers("/muretapi/auth/login", "**").permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .httpBasic();
        }
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new
                UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
