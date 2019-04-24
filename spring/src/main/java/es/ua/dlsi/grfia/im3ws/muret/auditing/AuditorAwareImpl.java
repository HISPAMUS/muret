package es.ua.dlsi.grfia.im3ws.muret.auditing;

import es.ua.dlsi.grfia.im3ws.muret.auth.services.UserPrinciple;
import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<User> {
    @Override
    public Optional<User> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        //TODO
        return Optional.of(userPrinciple.getUser());
    }
}
