package com.example.Agenda_B.service.impl;

import com.example.Agenda_B.domain.NotifEmail;
import com.example.Agenda_B.domain.Role;
import com.example.Agenda_B.domain.User;
import com.example.Agenda_B.domain.VerificationToken;
import com.example.Agenda_B.dto.AuthenticationResponse;
import com.example.Agenda_B.dto.LoginRequest;
import com.example.Agenda_B.dto.RegisterRequest;
import com.example.Agenda_B.exception.NotFoundException;
import com.example.Agenda_B.repository.RoleRepository;
import com.example.Agenda_B.repository.UserRepository;
import com.example.Agenda_B.repository.VerificationTokenRepositoy;
import com.example.Agenda_B.security.TokenProvider;
import com.example.Agenda_B.service.AuthentificationService;
import com.example.Agenda_B.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Service
@AllArgsConstructor
@Transactional
public class AuthentificationServiceImpl implements AuthentificationService {

    @Autowired
    private final UserRepository userRepository;

    @Bean
    //@Autowired
    private final RoleRepository roleRepository(){
        return new RoleRepository() {
            @Override
            public List<Role> findAll() {
                return null;
            }

            @Override
            public List<Role> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Role> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends Role> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Role> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Role> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<Role> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Role getOne(Long aLong) {
                return null;
            }

            @Override
            public Role getById(Long aLong) {
                return null;
            }

            @Override
            public <S extends Role> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Role> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Role> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Role> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Role entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Role> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Role> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Role> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Role> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends Role, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
    };

    //@Autowired
    @Bean
    private final VerificationTokenRepositoy verificationTokenRepositoy(){
        return new VerificationTokenRepositoy() {
            @Override
            public Optional<VerificationToken> findByToken(String token) {
                return Optional.empty();
            }

            @Override
            public List<VerificationToken> findAll() {
                return null;
            }

            @Override
            public List<VerificationToken> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<VerificationToken> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends VerificationToken> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends VerificationToken> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends VerificationToken> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<VerificationToken> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public VerificationToken getOne(Long aLong) {
                return null;
            }

            @Override
            public VerificationToken getById(Long aLong) {
                return null;
            }

            @Override
            public <S extends VerificationToken> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends VerificationToken> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<VerificationToken> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends VerificationToken> S save(S entity) {
                return null;
            }

            @Override
            public Optional<VerificationToken> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(VerificationToken entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends VerificationToken> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends VerificationToken> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends VerificationToken> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends VerificationToken> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends VerificationToken> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends VerificationToken, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
    };

    @Autowired
    private final MailService mailService;

    private final AuthenticationManager authenticationManager;

    private final TokenProvider jwtProvider;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(RegisterRequest registerRequest) {
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setFirstname(registerRequest.getFirstname());
        user.setLastname(registerRequest.getLastname());
        user.setFullname(registerRequest.getLastname()+" "+registerRequest.getFirstname());
        user.setRole(roleRepository().findById(registerRequest.getRoleId()).get());
        user.setEnabled(false);
        user.setCreatedAt(Instant.now());
        userRepository.save(user);

        String token = generateVerificationToken(user);
        mailService.sendMail(new NotifEmail("Please Activate your Account",
                user.getEmail(), "Thank you for signing up to <strong>Achieve</strong>, " +
                "please click on the below url to activate your account : " +
                "http://localhost:8081/api/auth/accountVerification/" + token));
        return user;
    }

    public String generateVerificationToken(User user) {
        // TODO Auto-generated method stub
        VerificationToken verificationToken = new VerificationToken();
        String token = UUID.randomUUID().toString();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationTokenRepositoy().save(verificationToken);

        return token;
    }

    @Override
    public String newVerificationToken(User user) {
        // TODO Auto-generated method stub
        VerificationToken verificationToken = new VerificationToken();
        String token = UUID.randomUUID().toString();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationTokenRepositoy().save(verificationToken);

        return token;
    }

    @Override
    public void accountVerification(String token) {
        Optional<VerificationToken> isToken = verificationTokenRepositoy().findByToken(token);
        isToken.orElseThrow(()-> new NotFoundException("Token Not found Exception"));

        VerificationToken verificationToken = isToken.get();
        User user = verificationToken.getUser();
        user.setEnabled(true);
        userRepository.save(user);
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String jwtToken = jwtProvider.generateToken(authenticate);
        return new AuthenticationResponse(jwtToken,loginRequest.getUsername());
    }
    @Override
    public User getLoggedInUserInfo(String username) {
//        UserDetails currentUserDetails =(UserDetails) SecurityContextHolder.getContext().getAuthentication()
//             .getPrincipal();

        return  userRepository.findByUsername(username);
    }
    public User getLoggedInUserDetails(String username) {
        User currentUserDetails =(User) SecurityContextHolder.getContext().getAuthentication()
                        .getPrincipal();

        return  currentUserDetails;
    }

}
