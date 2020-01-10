package es.ua.dlsi.grfia.im3ws.muret.model;

import es.ua.dlsi.grfia.im3ws.muret.entity.Collection;
import es.ua.dlsi.grfia.im3ws.muret.entity.Permissions;
import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import es.ua.dlsi.grfia.im3ws.muret.repository.CollectionRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.PermissionsRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.UserRepository;
import es.ua.dlsi.grfia.im3ws.muret.exceptions.UserManagerException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Configurable
public class UserManagerImpl
{
    private final UserRepository m_userRepository;
    private final CollectionRepository m_collectionRepository;
    private final PermissionsRepository m_permissionsRepository;
    private final BCryptPasswordEncoder m_pwdEncoder;

    public UserManagerImpl(UserRepository c_repository, CollectionRepository c_colRep, PermissionsRepository c_permissions)
    {
        m_userRepository = c_repository;
        m_collectionRepository = c_colRep;
        m_permissionsRepository = c_permissions;
        m_pwdEncoder = new BCryptPasswordEncoder();
    }

    @Transactional
    public void createUser(User c_userToRegister, String adminUserName) throws UserManagerException
    {
        if(m_userRepository.existsByUsername((c_userToRegister.getUsername())))
            throw new UserManagerException(HttpStatus.FORBIDDEN, "Error, username already exists");

        checkIfAdmin(adminUserName);

        m_userRepository.save(c_userToRegister);
    }

    private void checkIfAdmin(String adminName) throws UserManagerException
    {
       Optional<User> admin = m_userRepository.findByUsername(adminName);
       if(!admin.isPresent()) throw new UserManagerException(HttpStatus.FORBIDDEN, "Admin account does not exist");

       admin.ifPresent( adminToCheck -> {
           if(!adminToCheck.isAdministrator()) throw new UserManagerException(HttpStatus.FORBIDDEN, "You don't have permissions to create user account");
       } );
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

    @Transactional
    public void grantPermissions(String c_userName, String c_collectionID, char c_permissionType)
    {
        User userToUpdate = null;
        Collection collectionUsed = null;
        Optional<User> userSelected = m_userRepository.findByUsername(c_userName);
        Optional<Collection> collectionSelected = m_collectionRepository.findByName(c_collectionID);
        if(userSelected.isPresent()) userToUpdate = userSelected.get(); else throw new UserManagerException(HttpStatus.NOT_FOUND, "User not found");
        if(collectionSelected.isPresent()) collectionUsed = collectionSelected.get(); else throw new UserManagerException(HttpStatus.NOT_FOUND, "Collection does not exist");

        m_permissionsRepository.save(new Permissions(userToUpdate, collectionUsed, c_permissionType));
    }

    @Transactional
    public void revokePermissions(String c_userName, String c_collectionID)
    {
        User userToRevoke = null;
        int collectionIDToRevoke;
        Optional<User> userSelected = m_userRepository.findByUsername(c_userName);
        Optional<Collection> collectionSelected = m_collectionRepository.findByName(c_collectionID);
        if(userSelected.isPresent()) userToRevoke = userSelected.get(); else throw new UserManagerException(HttpStatus.NOT_FOUND, "User not found");
        if(collectionSelected.isPresent()) collectionIDToRevoke = collectionSelected.get().getId(); else throw new UserManagerException(HttpStatus.NOT_FOUND, "User not found");
        for(Permissions permision : userToRevoke.getPermissions()) {
            if (permision.getCollection().getId() == collectionIDToRevoke) {
                m_permissionsRepository.delete(permision);
                break;
            }
        }
    }

    public List<User> getUsers()
    {
        List<User> users = new ArrayList<User>();

        Iterable<User> usersFound =  m_userRepository.findAll();

        usersFound.forEach(users::add);

        return users;
    }

    @Transactional
    public Map<String, List<String>> getUsersPermissions()
    {
        Map<String, List<String>> permissionsMap = new HashMap<String, List<String>>();
        Iterable<Collection> collections = m_collectionRepository.findAll();
        Iterable<User> users = m_userRepository.findAll();
        for(Collection collection : collections)
        {
            permissionsMap.put(collection.getName(), new ArrayList<>());
        }
        //TODO -- Super expensive for loop, need to check other options
        for(User user : users)
        {
            for(String key : permissionsMap.keySet()) {
                for (Permissions permission : user.getPermissions()) {
                    if (permission.getCollection().getName().equals(key))
                        permissionsMap.get(key).add(user.getUsername());
                }
            }
        }

        return permissionsMap;
    }
}
