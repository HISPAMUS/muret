package es.ua.dlsi.grfia.im3ws.muret.repository;

import es.ua.dlsi.grfia.im3ws.muret.entity.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * @author drizo
 */
@RepositoryRestResource
public interface CollectionRepository extends CrudRepository<Collection, Integer>
{
    Optional<Collection> findByName(String name);
}
