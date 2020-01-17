package es.ua.dlsi.grfia.im3ws.scripts;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.Document;
import es.ua.dlsi.grfia.im3ws.muret.entity.Region;
import es.ua.dlsi.grfia.im3ws.muret.model.SemanticRepresentationModel;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.Agnostic2SemanticTransducer;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.MensuralAgnostic2SemanticTransducer;
import es.ua.dlsi.grfia.im3ws.muret.repository.RegionRepository;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;

import javax.transaction.Transactional;

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
        new AuthenticateForScripts(authenticationManager).authenticate("davidrizo", "nose");

        for (Region region: regionRepository.findAll()) {
            Document document = region.getPage().getImage().getDocument();
            if (!document.getCollection().getName().equals("Pruebas")) {
                if (region.getPage().getImage().getDocument().getNotationType() == NotationType.eModern) {
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
                agnosticEncoding = SemanticRepresentationModel.region2Agnostic(region, true);
                Agnostic2SemanticTransducer agnostic2SemanticTransducer = new MensuralAgnostic2SemanticTransducer();
                SemanticTransduction semantic = agnostic2SemanticTransducer.transduce(agnosticEncoding);
            } catch (Throwable e) {
                e.printStackTrace();
                throw new Exception(">>>>>>>>> Cannot convert region #" + region.getId() +
                        ", " + region.getPage().getImage().getFilename() +
                        ", in document " + region.getPage().getImage().getDocument().getName());
            }
        }
    }
}
