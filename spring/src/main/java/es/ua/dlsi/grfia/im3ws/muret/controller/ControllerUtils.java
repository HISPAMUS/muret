package es.ua.dlsi.grfia.im3ws.muret.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerUtils {
    public static ResponseStatusException createServerError(Object from, String message, Throwable t)  {
        Logger.getLogger(from.getClass().getName()).log(Level.WARNING, message, t);

        return new ResponseStatusException (
                HttpStatus.INTERNAL_SERVER_ERROR, message + ": " + t.getMessage(), t);

    }
}
