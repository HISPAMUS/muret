package es.ua.dlsi.grfia.im3ws.scripts;

import es.ua.dlsi.grfia.im3ws.configuration.MURETConfiguration;
import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import es.ua.dlsi.grfia.im3ws.muret.model.ITrainingSetExporter;
import es.ua.dlsi.grfia.im3ws.muret.model.trainingsets.AgnosticSymbolImagesTextFile;
import es.ua.dlsi.grfia.im3ws.muret.repository.*;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.utils.FileUtils;
import org.apache.commons.cli.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * It exports a given training set
 */
@ComponentScan("es.ua.dlsi.grfia.im3ws")
@EnableJpaRepositories("es.ua.dlsi.grfia.im3ws.muret.repository")
@EntityScan("es.ua.dlsi.grfia.im3ws.muret.entity")
@Transactional
public class ExportTrainingSet implements CommandLineRunner {
    @Autowired
    ProjectRepository projectRepository;

    List<ITrainingSetExporter> trainingSetExporters;

    private final MURETConfiguration muretConfiguration;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ExportTrainingSet.class, args);
        SpringApplication.exit(ctx);
    }

    @Autowired
    public ExportTrainingSet(MURETConfiguration muretConfiguration) {
        this.muretConfiguration = muretConfiguration;
        trainingSetExporters = Arrays.asList(
                new AgnosticSymbolImagesTextFile(3, false, false),
                new AgnosticSymbolImagesTextFile(4, false, true),
                new AgnosticSymbolImagesTextFile(5, true, false),
                new AgnosticSymbolImagesTextFile(6, true, true));
    }

    @Override
    public void run(String... args) throws Exception {
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        /// options.addOption("folder", true, "MuRET images folder");
        options.addOption("list", false, "List project IDS and exporters");
        options.addOption("help", false, "Print this help");
        options.addOption("output", true, "Output folder");
        options.addOption("project", true, "Project IDS to include, there may be several of them ");
        options.addOption("exporter", true, "Exporter IDS to include, there may be several of them ");

        CommandLine line = parser.parse( options, args );

        if (line.hasOption("help")) {
            printHelp(options);
            return;
        }


        /*if (!line.hasOption("folder")) {
            printHelp(options);
            throw new Exception("Missing option 'folder'");
        }*/

        if (line.hasOption("list")) {
            this.list();
        }

        if (line.hasOption("output")) {
            if (!line.hasOption("project")) {
                printHelp(options);
                throw new Exception("Missing -projects option");
            }

            if (!line.hasOption("exporter")) {
                printHelp(options);
                throw new Exception("Missing -exporter option");
            }

            String[] projectIDS = line.getOptionValues("project");
            String[] exporterIDS = line.getOptionValues("exporter");
            export(line.getOptionValue("output"), projectIDS, exporterIDS);

        }
        ///SpringApplication.run(ExportTrainingSet.class, args);
        //// muretConfiguration = new MURETConfiguration(null, null, line.getOptionValue("folder"), null, 200, 720, true);
    }

    private void list() {
        System.out.println("\nProjects:");
        projectRepository.findAll().forEach(project -> {
            System.out.println(project.getId() + "\t" + project.getName());
        });


        System.out.println("\nTraining sets:");
        trainingSetExporters.forEach(iTrainingSetExporter -> {
            System.out.println(iTrainingSetExporter.getId() + "\t" + iTrainingSetExporter.getName());
        });

    }

    private void printHelp(Options options) {
// automatically generate the help statement
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( this.getClass().getName(), options );
    }

    private void export(String output, String[] projectIDS, String[] exporterIDS) throws IM3Exception, IOException {
        File folderOutput = new File(output);
        if (!folderOutput.exists()) {
            folderOutput.mkdirs();
        }

        List<Project> projects = new ArrayList<>();
        for (String pid: projectIDS) {
            Optional<Project> project = projectRepository.findById(Integer.parseInt(pid));
            if (!project.isPresent()) {
                throw new IM3Exception("Cannot find an project with ID=" + pid);
            }
            projects.add(project.get());
        }

        for (String exporterID: exporterIDS) {
            ITrainingSetExporter exporter = findExporter(Integer.parseInt(exporterID));
            System.out.println("------ Exporting with exporter: " + exporter.getName() + " ------");
            Path muretFolder = Paths.get(muretConfiguration.getFolder());
            Path tgz = exporter.generate(muretFolder, projects);
            Path newPath = Paths.get(output, FileUtils.leaveValidCaracters(exporter.getName()) + ".tar.gz");
            Files.move(tgz, newPath);
        }
    }

    private ITrainingSetExporter findExporter(int exporterID) throws IM3Exception {
        Optional<ITrainingSetExporter> exporter = trainingSetExporters.stream().filter(iTrainingSetExporter -> iTrainingSetExporter.getId() == exporterID).findAny();
        if (!exporter.isPresent()) {
            throw new IM3Exception("Cannot find an exporter with ID=" + exporterID);
        }
        return exporter.get();
    }


}
