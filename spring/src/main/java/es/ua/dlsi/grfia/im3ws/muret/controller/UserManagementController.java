package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.controller.StringResponse;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.PermissionsForm;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.RegisterForm;
import es.ua.dlsi.grfia.im3ws.muret.controller.payload.ResetPWDForm;
import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import es.ua.dlsi.grfia.im3ws.muret.repository.CollectionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.PermissionsRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.UserRepository;
import es.ua.dlsi.grfia.im3ws.muret.exceptions.UserManagerException;
import es.ua.dlsi.grfia.im3ws.muret.model.UserManagerImpl;
import es.ua.dlsi.grfia.im3ws.muret.watchdog.WatchDog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserManagementController
{
    private static final Logger logger = LoggerFactory.getLogger(WatchDog.class);
    private final UserManagerImpl m_userManager;
    private final WatchDog m_watchdog;

    @Autowired
    public UserManagementController(UserRepository repository, CollectionRepository colRep, PermissionsRepository permissionsrepo, WatchDog watchDog)
    {
        m_userManager = new UserManagerImpl(repository, colRep, permissionsrepo);
        m_watchdog = watchDog;
    }

    @PostMapping("/register")
    public User createUser(@Valid @RequestBody RegisterForm c_newUserData) throws UserManagerException
    {
        User userToRegister = new User(c_newUserData.getFirst_name(),
                                        c_newUserData.getLast_name(),
                                        c_newUserData.getUsername(),
                                        new BCryptPasswordEncoder().encode(c_newUserData.getPassword()),
                                        c_newUserData.getEmail(),
                                        c_newUserData.getAdministrator(), null);

        m_userManager.createUser( userToRegister, c_newUserData.getAdminCreator() );

        m_watchdog.sendConfirmationEmail(userToRegister);

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

    @PostMapping("/grantPermissions")
    @Transactional
    public StringResponse grantPermissionsOnCollection(@Valid @RequestBody PermissionsForm c_request)
    {
        m_userManager.grantPermissions(c_request.getUserName(), c_request.getCollectionID(), c_request.getTypeOfPermission());
        return new StringResponse("Permissions granted");
    }

    @PostMapping("/revokePermissions")
    @Transactional
    public StringResponse revokePermissionsOnCollection(@Valid @RequestBody PermissionsForm c_request)
    {
        m_userManager.revokePermissions(c_request.getUserName(), c_request.getCollectionID());
        return new StringResponse("Permissions revoked");
    }

    @GetMapping("/userPermissions")
    @Transactional(readOnly = true)
    public Map<String, List<String>> getAllUsersPermissions()
    {
        return m_userManager.getUsersPermissions();
    }

    @GetMapping("/allUsers")
    @Transactional(readOnly = true)
    public List<String> getAllUsers()
    {
        List<User> users = m_userManager.getUsers();
        List<String> userNames = new ArrayList<String>();

        for(User user : users)
        {
            userNames.add(user.getUsername());
        }

        return userNames;
    }
}
