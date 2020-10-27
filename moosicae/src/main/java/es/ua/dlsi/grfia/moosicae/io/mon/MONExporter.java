package es.ua.dlsi.grfia.moosicae.io.mon;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IScore;
import es.ua.dlsi.grfia.moosicae.io.BaseExporter;
import es.ua.dlsi.grfia.moosicae.io.IExporter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It exports the objects into mO.O.sicae Object Notation JSON (MON).
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 12/04/2020
 */
public class MONExporter extends BaseExporter {
    public MONExporter() {

    }

    @Override
    public String exportScore(IScore score) throws IMException {
        ObjectMapper mapper = new ObjectMapper();
        // for correctly exporting Optional values: https://www.baeldung.com/jackson-optional
        mapper.registerModule(new Jdk8Module());

        // avoid empty Optional.empty() values
        mapper.setSerializationInclusion(JsonInclude.Include.NON_ABSENT);

        try {
            String str = mapper.writerFor(IScore.class).writeValueAsString(score);
            return str;
        } catch (JsonProcessingException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot serialize to JSON", e);
            throw new IMException(e);
        }
    }
}
