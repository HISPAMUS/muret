package es.ua.dlsi.grfia.im3ws.muret.repository;

import es.ua.dlsi.grfia.im3ws.muret.controller.payload.IPartUse;
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

    @Query(value="SELECT p.image_id as imageId, p.part_id as partId, p.id as id FROM page p where p.part_id = :partID", nativeQuery = true)
    List<IPartUse> getPages(Long partID);

    @Query(value="SELECT p.image_id as imageId, r.part_id as partId, r.id as id FROM region r, page p where r.part_id = :partID and p.id = r.page_id", nativeQuery = true)
    List<IPartUse> getRegions(Long partID);

    @Query(value="SELECT p.image_id as imageId, s.part_id as partId, s.id as id FROM symbol s, page p, region r  where s.part_id = :partID and p.id = r.page_id and s.region_id = r.id", nativeQuery = true)
    List<IPartUse> getSymbols(Long partID);

    // List<Part> findByImageId(Long imageID);

    /*@Query(value="select part.name from part, image where part.id = image.part_id and image.id = :partID\n" +
            "union\n" +
            "select part.name from part, image, page where part.id = page.part_id and image.id = page.image_id and image.id = :partID\n" +
            "union\n" +
            "select part.name from part, region, image, page where part.id = region.part_id and image.id = page.image_id and page.id = region.page_id and image.id = :partID\n" +
            "union\n" +
            "select part.name from part, symbol, region, image, page where part.id = symbol.part_id and symbol.id = image.part_id and image.id = page.image_id and page.id = region.page_id and symbol.region_id = region.id and image.id = :partID",
    nativeQuery = true)
    List<String> getPartNamesUsedByImage(Long partID);*/
}
