package es.ua.dlsi.grfia.im3ws.scripts;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.Image;
import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.model.ITrainingSetExporter;
import es.ua.dlsi.grfia.im3ws.muret.model.SemanticRepresentationModel;
import es.ua.dlsi.grfia.im3ws.muret.model.trainingsets.AgnosticSymbolImagesTextFile;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.Agnostic2SemanticTransducer;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.MensuralAgnostic2SemanticTransducer;
import es.ua.dlsi.grfia.im3ws.muret.repository.ProjectRepository;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.utils.FileUtils;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import org.apache.commons.cli.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * It verifies the transducer from agnostic to semantic works
 */
@ComponentScan("es.ua.dlsi.grfia.im3ws")
@EnableJpaRepositories("es.ua.dlsi.grfia.im3ws.muret.repository")
@EntityScan("es.ua.dlsi.grfia.im3ws.muret.entity")
@Transactional
public class VerifyAgnosticSemanticTransducer implements CommandLineRunner {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RegionRepository regionRepository;

    private final MURETConfiguration muretConfiguration;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(VerifyAgnosticSemanticTransducer.class, args);
        SpringApplication.exit(ctx);
    }

    @Autowired
    public VerifyAgnosticSemanticTransducer(MURETConfiguration muretConfiguration) {
        this.muretConfiguration = muretConfiguration;
    }

    @Override
    public void run(String... args) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken("davidrizo", "nose"));
        SecurityContextHolder.getContext().setAuthentication(authentication); // required from the auditing framework

        for (Region region: regionRepository.findAll()) {
            Project project = region.getPage().getImage().getProject();
            if (!project.getCollection().getName().equals("Pruebas")) {
                if (region.getPage().getImage().getProject().getNotationType() == NotationType.eModern) {
                    System.err.println("TO-DO Cannot work with modern yet");     //TODO moderno
                } else {
                    checkRegion(region);
                }
            }
        }
    }

    //TODO comprobar generación semantico -> agnostico y que dé lo mismo
    private void checkRegion(Region region) throws Exception {
        System.out.println("Verifying " + region.getId());
        if (region.getSymbols() != null && !region.getSymbols().isEmpty()) {
            AgnosticEncoding agnosticEncoding = null;
            try {
                agnosticEncoding = SemanticRepresentationModel.region2Agnostic(region);
                Agnostic2SemanticTransducer agnostic2SemanticTransducer = new MensuralAgnostic2SemanticTransducer();
                SemanticTransduction semantic = agnostic2SemanticTransducer.transduce(agnosticEncoding);
            } catch (Throwable e) {
                e.printStackTrace();
                throw new Exception(">>>>>>>>> Cannot convert region #" + region.getId() +
                        ", " + region.getPage().getImage().getFilename() +
                        ", in project " + region.getPage().getImage().getProject().getName());
            }
        }
    }
}
