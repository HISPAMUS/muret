package es.ua.dlsi.grfia.im3ws.scripts;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneratePassword {
    public static final void main(String [] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("Encoded password");
        System.out.println(encoder.encode(args[0]));
        System.out.println("----------------");
    }
}
