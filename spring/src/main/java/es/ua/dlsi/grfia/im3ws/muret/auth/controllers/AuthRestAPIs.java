package es.ua.dlsi.grfia.im3ws.muret.auth.controllers;

import javax.validation.Valid;

import es.ua.dlsi.grfia.im3ws.muret.auditing.AuditorAwareImpl;
import es.ua.dlsi.grfia.im3ws.muret.auth.jwt.JwtProvider;
import es.ua.dlsi.grfia.im3ws.muret.auth.message.request.LoginForm;
import es.ua.dlsi.grfia.im3ws.muret.auth.message.response.JwtResponse;
import es.ua.dlsi.grfia.im3ws.muret.auth.services.UserPrinciple;
import es.ua.dlsi.grfia.im3ws.muret.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("auth")
public class AuthRestAPIs {

	private final AuthenticationManager authenticationManager;
	private final UserRepository userRepository;
	private final PasswordEncoder encoder;
	private final JwtProvider jwtProvider;

	@Autowired
	public AuthRestAPIs(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder encoder, JwtProvider jwtProvider) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.encoder = encoder;
		this.jwtProvider = jwtProvider;
	}

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		//UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserPrinciple userDetails = (UserPrinciple) authentication.getPrincipal();

		AuditorAwareImpl.setANONYMUSId(userDetails.getId());

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
	}
}
