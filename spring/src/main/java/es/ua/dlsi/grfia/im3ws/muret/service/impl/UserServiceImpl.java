package es.ua.dlsi.grfia.im3ws.muret.service.impl;

import com.fasterxml.jackson.annotation.JsonView;
import es.ua.dlsi.grfia.im3ws.muret.entity.JSONFilteredDataViews;
import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import es.ua.dlsi.grfia.im3ws.muret.repository.UserRepository;
import es.ua.dlsi.grfia.im3ws.muret.service.UserService;
import es.ua.dlsi.grfia.im3ws.service.impl.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

/**
 * @author drizo
 */
@Service
public class UserServiceImpl extends CRUDServiceImpl<User, Integer, UserRepository> implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    protected UserRepository initRepository() {
        return userRepository;
    }

    @Override
    public Optional<User> findByUserNamePassword(String username, String password) {
        ExampleMatcher matcher = ExampleMatcher.matching()
            .withMatcher("username", exact())
                .withMatcher("password", exact()); //TODO encriptar

        Example<User> example = Example.of(new User(username, password, null), matcher);
        Optional<User> result = userRepository.findOne(example);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Logging of user {0} with response {1}", new Object[]{username, result});
        return result;
    }
}

