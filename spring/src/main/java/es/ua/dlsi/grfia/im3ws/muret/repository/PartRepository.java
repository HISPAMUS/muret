package es.ua.dlsi.grfia.im3ws.muret.repository;

import es.ua.dlsi.grfia.im3ws.muret.controller.payload.IBigIntPair;
import es.ua.dlsi.grfia.im3ws.muret.entity.Part;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.math.BigInteger;
import java.util.List;

/**
 * @author drizo
 */
@RepositoryRestResource
public interface PartRepository extends CrudRepository<Part, Long> {
    List<Part> findByProjectId(int projectId);

    /*// JPQL
    @Query(value="SELECT u FROM Image u where u.part = :part")
    List<Image> getImages(Part part);

    @Query(value="SELECT u FROM Page u where u.part = :part")
    List<Page> getPages(Part part);

    @Query(value="SELECT u FROM Region u where u.part = :part")
    List<Region> getRegions(Part part);

    @Query(value="SELECT u FROM Symbol u where u.part = :part")
    List<Symbol> getSymbols(Part part);*/

    @Query(value="SELECT id FROM image i where i.part_id = :partID", nativeQuery = true)
    List<BigInteger> getImages(Long partID);

    @Query(value="SELECT p.image_id as x, p.id as y FROM page p where p.part_id = :partID", nativeQuery = true)
    List<IBigIntPair> getPages(Long partID);

    @Query(value="SELECT p.image_id as x, r.id as y FROM region r, page p where r.part_id = :partID and p.id = r.page_id", nativeQuery = true)
    List<IBigIntPair> getRegions(Long partID);

    @Query(value="SELECT p.image_id as x, s.id as y FROM symbol s, page p, region r  where s.part_id = :partID and p.id = r.page_id and s.region_id = r.id", nativeQuery = true)
    List<IBigIntPair> getSymbols(Long partID);

}
