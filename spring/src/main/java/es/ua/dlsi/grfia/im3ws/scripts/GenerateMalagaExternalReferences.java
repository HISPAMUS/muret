package es.ua.dlsi.grfia.im3ws.scripts;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.Document;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.entity.Page;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.repository.DocumentRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.im3.core.IM3Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.Optional;

/**
 * It generates the external references from "A" codes annotated by Antonio Madueño in each region
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 3/6/21
 */
@ComponentScan("es.ua.dlsi.grfia.im3ws")
@EnableJpaRepositories("es.ua.dlsi.grfia.im3ws.muret.repository")
@EntityScan("es.ua.dlsi.grfia.im3ws.muret.entity")
@Transactional
public class GenerateMalagaExternalReferences  implements CommandLineRunner {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    DocumentRepository documentRepository;

    private final MURETConfiguration muretConfiguration;


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(GenerateMalagaExternalReferences.class, args);
        SpringApplication.exit(ctx);
    }


    @Autowired
    public GenerateMalagaExternalReferences(MURETConfiguration muretConfiguration) {
        this.muretConfiguration = muretConfiguration;
    }

    @Override
    public void run(String... args) throws Exception {
        new AuthenticateForScripts(authenticationManager).consoleAuthenticate("davidrizo");

        Optional<Document> document = documentRepository.findById(290); // Catedral de Málaga Vol.2
        if (!document.isPresent()) {
            throw new IM3Exception("Cannot find document");
        }

        long lastCode = 10032205;
        boolean started = false;
        // Catálogo del archivo de música de la Catedral de Málaga Vol.2_447.jpg
        LinkedList<Region> regionsToSave = new LinkedList<>();
        for (Image image: document.get().computeAllImagesSorted()) {
            for (Page page: image.computeSortedPages()) {
                for (Region region: page.computeSortedStaves()) {
                    if (region.getExternalReference() != null && region.getExternalReference().equals(Long.toString(lastCode))) {
                        started = true;
                        System.out.println("Starting...");
                    } else if (started) {
                        if (region.getExternalReference() == null || region.getExternalReference().trim().isEmpty()) {
                            region.setExternalReference(Long.toString(lastCode));
                            regionsToSave.add(region);
                        } else if (region.getExternalReference().equalsIgnoreCase("a")) {
                            lastCode++;
                            region.setExternalReference(Long.toString(lastCode));
                            regionsToSave.add(region);
                        } else {
                            throw new Exception("Invalid external reference: " + region.getExternalReference());
                        }
                        System.out.println("Setting " + region.getExternalReference());
                    }
                }
            }
        }
        regionRepository.saveAll(regionsToSave);
        System.out.println("Done");
    }
}
