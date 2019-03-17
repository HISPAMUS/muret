package es.ua.dlsi.grfia.im3ws.scripts;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Scanner;

public class GeneratePassword {
    public static final void main(String [] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println("Introduce password:");
        Scanner scanner = new Scanner(System.in); // don't use Console to make it work inside IntelliJ

        String passwd = scanner.nextLine();
        System.out.println("Encoded password");
        System.out.println(encoder.encode(passwd));
        System.out.println("----------------");
    }
}
