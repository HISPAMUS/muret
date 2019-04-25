package es.ua.dlsi.grfia.im3ws.muret.repository;

import es.ua.dlsi.grfia.im3ws.muret.entity.Action;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author drizo
 */
@RepositoryRestResource
public interface ActionRepository extends CrudRepository<Action, Long> {
}
