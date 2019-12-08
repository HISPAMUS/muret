package es.ua.dlsi.grfia.im3ws.muret.repository;

import es.ua.dlsi.grfia.im3ws.muret.entity.Page;
import es.ua.dlsi.grfia.im3ws.muret.entity.Part;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.entity.Symbol;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.math.BigDecimal;
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

    @Query(value="SELECT id FROM image u where u.part_id = :partID", nativeQuery = true)
    List<BigInteger> getImages(Long partID);

    @Query(value="SELECT id FROM page u where u.part_id = :partID", nativeQuery = true)
    List<BigInteger> getPages(Long partID);

    @Query(value="SELECT id FROM region u where u.part_id = :partID", nativeQuery = true)
    List<BigInteger> getRegions(Long partID);

    @Query(value="SELECT id FROM symbol u where u.part_id = :partID", nativeQuery = true)
    List<BigInteger> getSymbols(Long partID);

}
