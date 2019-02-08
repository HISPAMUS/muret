package es.ua.dlsi.grfia.im3ws.muret.controller;

import es.ua.dlsi.grfia.im3ws.controller.CRUDController;
import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import es.ua.dlsi.grfia.im3ws.muret.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestMapping("/muretapi/user")
@CrossOrigin("${angular.url}")
@RestController
public class UserController extends CRUDController<User, Integer, UserService> {
    @Autowired
    UserService userService;

    @Override
    protected UserService initService() {
        return userService;
    }
}

