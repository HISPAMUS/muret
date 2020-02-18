package es.ua.dlsi.grfia.im3ws.muret.repository;

import es.ua.dlsi.grfia.im3ws.muret.entity.Permissions;
import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PermissionsRepository extends CrudRepository<Permissions, Integer>  {
    // JPQL
    //@Query(value="SELECT p FROM Permissions p, User u where p.user = :user")
    //List<Permissions> getPermissionsFor(User user);
}
