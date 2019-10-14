package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.controller.StringResponse;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.RegisterForm;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.ResetPWDForm;
import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import es.ua.dlsi.grfia.im3ws.muret.repository.UserRepository;
import es.ua.dlsi.grfia.im3ws.muret.exceptions.UserManagerException;
import es.ua.dlsi.grfia.im3ws.muret.model.UserManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserManagementController
{
    private final UserManagerImpl m_userManager;

    @Autowired
    public UserManagementController(UserRepository repository){ m_userManager = new UserManagerImpl(repository);}

    @PostMapping("/register")
    public User createUser(@Valid @RequestBody RegisterForm c_newUserData) throws UserManagerException
    {
        User userToRegister = new User(c_newUserData.getUsername(),
                                        c_newUserData.getLast_name(),
                                        c_newUserData.getUsername(),
                                        new BCryptPasswordEncoder().encode(c_newUserData.getPassword()),
                                        c_newUserData.getEmail(),
                                        c_newUserData.getAdministrator());

        m_userManager.createUser( userToRegister );

        return userToRegister;
    }

    @PostMapping("/resetpwd")
    public StringResponse resetPassword(@Valid @RequestBody ResetPWDForm c_resetPassword)
    {
        m_userManager.resetPassword(
                c_resetPassword.getUsername(),
                c_resetPassword.getNewPWD()
        );

        //If exception has not reached, it means that everything got alright

        return new StringResponse("Password changed successfully");
    }
}
