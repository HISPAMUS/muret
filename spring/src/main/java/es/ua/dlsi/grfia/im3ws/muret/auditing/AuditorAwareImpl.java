package es.ua.dlsi.grfia.im3ws.muret.auditing;

import es.ua.dlsi.grfia.im3ws.IM3WSException;
import es.ua.dlsi.grfia.im3ws.muret.auth.services.UserPrinciple;
import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import es.ua.dlsi.im3.core.IM3RuntimeException;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<User> {
    @Override
    public Optional<User> getCurrentAuditor() {
        return Optional.of(getCurrentUser());
    }

    public static User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
            return userPrinciple.getUser();
        } else {
            throw new IM3RuntimeException("No authenticated user");
        }
    }
}
