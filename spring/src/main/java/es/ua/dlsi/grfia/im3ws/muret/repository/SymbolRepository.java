package es.ua.dlsi.grfia.im3ws.muret.repository;

import es.ua.dlsi.grfia.im3ws.muret.entity.Symbol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author drizo
 */
@RepositoryRestResource
public interface SymbolRepository extends CrudRepository<Symbol, Long> {
}
