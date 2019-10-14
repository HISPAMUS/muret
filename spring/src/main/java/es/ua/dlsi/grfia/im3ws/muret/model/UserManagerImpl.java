package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import es.ua.dlsi.grfia.im3ws.muret.repository.UserRepository;
import es.ua.dlsi.grfia.im3ws.muret.exceptions.UserManagerException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Configurable
public class UserManagerImpl
{
    private final UserRepository m_userRepository;
    private final BCryptPasswordEncoder m_pwdEncoder;

    public UserManagerImpl(UserRepository c_repository)
    {
        m_userRepository = c_repository;
        m_pwdEncoder = new BCryptPasswordEncoder();
    }

    @Transactional
    public void createUser(User c_userToRegister) throws UserManagerException
    {
        if(m_userRepository.existsByUsername((c_userToRegister.getUsername())))
            throw new UserManagerException(HttpStatus.FORBIDDEN, "Error, username already exists");

        m_userRepository.save(c_userToRegister);
    }

    @Transactional
    public void resetPassword(String c_userName, String c_newPassword) throws UserManagerException
    {
        Optional<User> userToUpdate = m_userRepository.findByUsername(c_userName);

        if(!userToUpdate.isPresent()) throw new UserManagerException(HttpStatus.NOT_FOUND, "User not found");

        userToUpdate.ifPresent(
                updatingUser -> {
                        updatingUser.setPassword(m_pwdEncoder.encode(c_newPassword));
                        m_userRepository.save(updatingUser);
                }
        );
    }
}
