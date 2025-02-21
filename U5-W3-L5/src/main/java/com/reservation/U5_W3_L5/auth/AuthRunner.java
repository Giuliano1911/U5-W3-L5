package com.reservation.U5_W3_L5.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class AuthRunner implements ApplicationRunner {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<AppUser> adminUser = appUserService.findByUsername("admin");
        if (adminUser.isEmpty()) {
            appUserService.registerUser("admin", "adminpwd", Set.of(Role.ROLE_ADMIN));
        }

        Optional<AppUser> normalUser1 = appUserService.findByUsername("user1");
        if (normalUser1.isEmpty()) {
            appUserService.registerUser("user1", "userpwd", Set.of(Role.ROLE_USER));
        }

        Optional<AppUser> normalUser2 = appUserService.findByUsername("user2");
        if (normalUser2.isEmpty()) {
            appUserService.registerUser("user2", "userpwd", Set.of(Role.ROLE_USER));
        }

        Optional<AppUser> normalUser3 = appUserService.findByUsername("user3");
        if (normalUser3.isEmpty()) {
            appUserService.registerUser("user3", "userpwd", Set.of(Role.ROLE_USER));
        }

        Optional<AppUser> normalUser4 = appUserService.findByUsername("user4");
        if (normalUser4.isEmpty()) {
            appUserService.registerUser("user4", "userpwd", Set.of(Role.ROLE_USER));
        }

        Optional<AppUser> normalUser5 = appUserService.findByUsername("user5");
        if (normalUser5.isEmpty()) {
            appUserService.registerUser("user5", "userpwd", Set.of(Role.ROLE_USER));
        }

        Optional<AppUser> organizerUser1 = appUserService.findByUsername("organizer1");
        if (organizerUser1.isEmpty()) {
            appUserService.registerUser("organizer1", "organizerpwd", Set.of(Role.ROLE_ORGANIZER));
        }

        Optional<AppUser> organizerUser2 = appUserService.findByUsername("organizer2");
        if (organizerUser2.isEmpty()) {
            appUserService.registerUser("organizer2", "organizerpwd", Set.of(Role.ROLE_ORGANIZER));
        }

        Optional<AppUser> organizerUser3 = appUserService.findByUsername("organizer3");
        if (organizerUser3.isEmpty()) {
            appUserService.registerUser("organizer3", "organizerpwd", Set.of(Role.ROLE_ORGANIZER));
        }
    }
}
