package es.ua.dlsi.grfia.im3ws.service;

import java.util.List;
import java.util.Optional;

/**
 * @author drizo
 */
public interface ICRUDService<EntityType, PrimaryKeyType> {
    EntityType create(EntityType entity);
    Optional<EntityType> findById(PrimaryKeyType id);
    EntityType update(EntityType user);
    boolean delete(PrimaryKeyType id);
    List<EntityType> findAll();
}
