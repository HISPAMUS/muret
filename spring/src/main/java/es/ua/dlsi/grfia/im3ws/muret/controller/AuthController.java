package es.ua.dlsi.grfia.im3ws.muret.controller;

import com.fasterxml.jackson.annotation.JsonView;
import es.ua.dlsi.grfia.im3ws.muret.entity.JSONFilteredDataViews;
import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import es.ua.dlsi.grfia.im3ws.muret.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestMapping("auth")
@RestController
public class AuthController {

    private final UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @JsonView(JSONFilteredDataViews.ObjectWithoutRelations.class)
    @RequestMapping("login")
    public Optional<User> login(@RequestBody User user) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Login with user '" + user.getUsername() + "'");

        Optional<User> response = userRepository.findByUserNamePassword(user.getUsername(), user.getPassword());
       /* if (response.isPresent()) {
            for (Project project: response.get().getProjectsCreated()) {
                if (project.getState() != null) {
                    System.out.println(project.getState().toString());
                }
            }
        }*/
        return response;

        //return user.getUsername().equals("username") && user.getPassword().equals("password"); //TODO - see BasicAuthConfiguration
        //return user.getUsername().equals("user") && user.getPassword().equals("password"); //TODO - see BasicAuthConfiguration
    }

    @RequestMapping("user")
    public Principal user(HttpServletRequest request) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "User request" + request);

        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();

        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "... authToken = " + authToken);

        return () ->  new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }
}

