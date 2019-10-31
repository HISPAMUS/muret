package es.ua.dlsi.grfia.im3ws.muret.auditing;

import es.ua.dlsi.grfia.im3ws.muret.auth.services.UserPrinciple;
import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import es.ua.dlsi.im3.core.IM3RuntimeException;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
import java.util.logging.Logger;

public class AuditorAwareImpl implements AuditorAware<User> {
    private static User ANONYMOUS = new User();
    {
        ANONYMOUS.setId(1);
    }
    @Override
    public Optional<User> getCurrentAuditor() {
        return Optional.of(getCurrentUser());
    }

    public static User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (!(authentication.getPrincipal() instanceof UserPrinciple)) {
                return ANONYMOUS; //TODO hecho para que autentique con la subida de ficheros
            }
            UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
            return userPrinciple.getUser();
        } else {
            throw new IM3RuntimeException("No authenticated user");
        }
    }

    public static void setANONYMUSId(int newID)
    {
        ANONYMOUS.setId(newID);
    }
}
