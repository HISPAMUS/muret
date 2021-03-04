package es.ua.dlsi.grfia.im3ws.muret.repository;

import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.entity.ImageRecognitionPhase;
import es.ua.dlsi.grfia.im3ws.muret.entity.ImageRecognitionProgressStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 4/3/21
 */
@RepositoryRestResource
public interface ImageRecognitionProgressStatusRepository extends CrudRepository<ImageRecognitionProgressStatus, Long> {
    Set<ImageRecognitionProgressStatus> findByImageAndPhase(Image image, ImageRecognitionPhase phase);
}
