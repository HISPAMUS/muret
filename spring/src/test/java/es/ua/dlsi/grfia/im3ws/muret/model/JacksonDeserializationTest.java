package es.ua.dlsi.grfia.im3ws.muret.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.entity.Collection;
import es.ua.dlsi.grfia.im3ws.muret.entity.ManuscriptType;
import es.ua.dlsi.grfia.im3ws.muret.entity.Project;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.score.NotationType;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class JacksonDeserializationTest {


    @Test
    public void transductionTest() throws IOException {
        Collection collection = new Collection("Test collection", null, null);
        Project project = new Project();
        project.setManuscriptType(ManuscriptType.eHandwritten);
        project.setNotationType(NotationType.eMensural);
        project.setName("Test name");
        project.setComposer("Test composer");
        project.setCollection(collection);
        String json = new ObjectMapper().writeValueAsString(project);
        System.out.println(json);

        //String json = "{'name':'Test', 'collection': {'id': 6}}";

        ObjectMapper mapper = new ObjectMapper();

        Project parsedProject = mapper.reader().forType(Project.class).readValue(json);
        assertEquals("Name", project.getName(), parsedProject.getName());
    }
}
