package es.ua.dlsi.grfia.im3ws.muret.repository;

import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

/**
 * @author drizo
 */
@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Integer> {

    /*@Query("select u from User u where u.username=?1 AND u.password = ?2")
    Optional<User> findByUserNamePassword(String username, String password);*/

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
