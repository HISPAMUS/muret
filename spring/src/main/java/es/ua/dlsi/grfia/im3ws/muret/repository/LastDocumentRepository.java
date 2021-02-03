package es.ua.dlsi.grfia.im3ws.muret.repository;

import es.ua.dlsi.grfia.im3ws.muret.entity.LastDocument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author drizo
 */
@RepositoryRestResource
public interface LastDocumentRepository extends CrudRepository<LastDocument, Integer> {
}
