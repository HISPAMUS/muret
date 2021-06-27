package es.ua.dlsi.grfia.im3ws.utils;

//https://www.baeldung.com/run-shell-command-in-java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.function.Consumer;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 4/6/21
 */
public class StreamGobbler implements Runnable {
    private InputStream inputStream;
    private Consumer<String> consumer;
    private LinkedList<String> lines;

    public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
        this.inputStream = inputStream;
        this.consumer = consumer;
        this.lines = new LinkedList<>();
    }

    @Override
    public void run() {
        /*new BufferedReader(new InputStreamReader(inputStream)).lines()
                .forEach(consumer);*/
        this.lines.clear();
        try {
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                this.lines.add(line);
            }
                //System.out.println(type + "> " + line);
        }
        catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public LinkedList<String> getLines() {
        return lines;
    }
}
