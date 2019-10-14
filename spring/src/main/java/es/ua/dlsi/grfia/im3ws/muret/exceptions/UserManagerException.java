package es.ua.dlsi.grfia.im3ws.muret.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserManagerException extends ResponseStatusException
{
    public UserManagerException(HttpStatus status,String errorMessage)
    {
        super(status, errorMessage);
    }
}
