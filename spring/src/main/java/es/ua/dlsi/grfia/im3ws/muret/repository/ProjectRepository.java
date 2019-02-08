package es.ua.dlsi.grfia.im3ws.muret.repository;

import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author drizo
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query(value="SELECT count(*) FROM image WHERE project_id = :id ",  nativeQuery = true)
    int getNumberOfImages(Integer id);

    @Query(value="SELECT count(*) FROM page p, image i WHERE p.image_id = i.id and project_id = :id ",  nativeQuery = true)
    int getNumberOfPages(Integer id);

    @Query(value="SELECT count(*) FROM page p, image i, region r WHERE p.image_id = i.id and r.page_id = p.id and project_id = :id ",  nativeQuery = true)
    int getNumberOfRegions(Integer id);

    @Query(value="SELECT count(*) FROM page p, image i, region r, symbol s WHERE p.image_id = i.id and r.page_id = p.id and r.id = s.region_id and project_id = :id",  nativeQuery = true)
    int getNumberOfAgnosticSymbols(Integer id);
}
