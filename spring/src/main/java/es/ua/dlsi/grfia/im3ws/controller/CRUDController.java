package es.ua.dlsi.grfia.im3ws.controller;

import com.fasterxml.jackson.annotation.JsonView;
import es.ua.dlsi.grfia.im3ws.muret.entity.JSONFilteredDataViews;
import es.ua.dlsi.grfia.im3ws.service.ICRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It uses JsonView to filter JSON results. When using findAll it just returns the fields in the entity object annotated with @JsonView(JSONFilteredDataViews.ObjectWithoutRelations.class).
 * The method findOne returns all objects and relationships. Note that SpringBoot + JPA ignore the LAZY or EAGER JPA annotations
 * @author drizo
 */
@CrossOrigin("${angular.url}")
public abstract class CRUDController<EntityType, PrimaryKeyType, CRUDServiceType extends ICRUDService<EntityType, PrimaryKeyType>> {
    CRUDServiceType service;

    private CRUDServiceType getService() {
        synchronized (CRUDController.class) {
            if (service == null) {
                service = initService();
            }
        }
        return service;
    }

    protected abstract CRUDServiceType initService();

    @PostMapping
    public EntityType create(@RequestBody EntityType entity){
        return getService().create(entity);
    }

    /**
     * It returns all contents using an eager strategy
     * @param id
     * @return
     */
    @GetMapping(path = {"/get/{id}"})
    public Optional<EntityType> findOne(@PathVariable("id") PrimaryKeyType id){
        Optional<EntityType> result = getService().findById(id);
        return result;
    }

    /**
     * It returns all contents using a lazy strategy
     * @param id
     * @return
     */
    @JsonView(JSONFilteredDataViews.ObjectWithoutRelations.class)
    @GetMapping(path = {"/getlazy/{id}"})
    public Optional<EntityType> findOneLazy(@PathVariable("id") PrimaryKeyType id){
        Optional<EntityType> result = getService().findById(id);
        return result;
    }

    @PutMapping
    public EntityType update(@RequestBody EntityType user){
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Updating {0}", user);
        EntityType result = getService().update(user);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Updated {0}", result);
        return result;
    }

    @DeleteMapping(path ={"/{id}"})
    public void delete(@PathVariable("id") PrimaryKeyType id) {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Deleting {0}", id);
        getService().delete(id);
    }

    /**
     * It just returns the fields annotated with @JsonView(JSONFilteredDataViews.ObjectWithoutRelations.class)
     * @return
     */
    @JsonView(JSONFilteredDataViews.ObjectWithoutRelations.class)
    @GetMapping
    public List<EntityType> findAll(){
        return getService().findAll();
    }
}
