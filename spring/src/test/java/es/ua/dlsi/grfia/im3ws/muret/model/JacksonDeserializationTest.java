package es.ua.dlsi.grfia.im3ws.muret.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.ua.dlsi.grfia.im3ws.muret.entity.Collection;
import es.ua.dlsi.grfia.im3ws.muret.entity.Document;
import es.ua.dlsi.grfia.im3ws.muret.entity.ManuscriptType;
import es.ua.dlsi.im3.core.score.NotationType;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class JacksonDeserializationTest {


    @Test
    public void transductionTest() throws IOException {
        Collection collection = new Collection("Test collection", null, null);
        Document document = new Document();
        document.setManuscriptType(ManuscriptType.eHandwritten);
        document.setNotationType(NotationType.eMensural);
        document.setName("Test name");
        document.setComposer("Test composer");
        document.setCollection(collection);
        String json = new ObjectMapper().writeValueAsString(document);
        System.out.println(json);

        //String json = "{'name':'Test', 'collection': {'id': 6}}";

        ObjectMapper mapper = new ObjectMapper();

        Document parsedDocument = mapper.reader().forType(Document.class).readValue(json);
        assertEquals("Name", document.getName(), parsedDocument.getName());
    }
}
