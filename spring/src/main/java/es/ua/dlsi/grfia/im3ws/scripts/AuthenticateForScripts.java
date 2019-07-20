package es.ua.dlsi.grfia.im3ws.scripts;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.Console;

public class AuthenticateForScripts {
    AuthenticationManager authenticationManager;

    public AuthenticateForScripts(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public void consoleAuthenticate() {
        Console console = System.console();
        String username = console.readLine("Username: ");
        String password = new String(console.readPassword("Password: "));

        authenticate(username, password);
    }

    public void authenticate(String login, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login, password));
        SecurityContextHolder.getContext().setAuthentication(authentication); // required from the auditing framework
    }
}
