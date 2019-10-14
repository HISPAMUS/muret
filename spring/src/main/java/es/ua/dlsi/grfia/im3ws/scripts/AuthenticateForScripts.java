package es.ua.dlsi.grfia.im3ws.scripts;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class AuthenticateForScripts {
    AuthenticationManager authenticationManager;

    public AuthenticateForScripts(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public void consoleAuthenticate(String defaultUsername) {
        Console console = System.console();
        String username = defaultUsername;
        String password = null;
        if (console == null) {
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));
            try {
                if (username == null) {
                    System.out.println("Username:");
                    username = reader.readLine();
                }

                System.out.println("Password:");
                password = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException("Cannot read from console");
            }

        } else {
            if (username != null) {
                username = console.readLine("Username: ");
            }
            password = new String(console.readPassword("Password: "));
        }
        authenticate(username, password);
    }
    public void consoleAuthenticate() {
        consoleAuthenticate(null);
    }

    public void authenticate(String login, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login, password));
        SecurityContextHolder.getContext().setAuthentication(authentication); // required from the auditing framework
    }
}
