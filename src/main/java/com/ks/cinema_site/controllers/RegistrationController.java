package com.ks.cinema_site.controllers;

import com.ks.cinema_site.entities.Role;
import com.ks.cinema_site.entities.UserEntity;
import com.ks.cinema_site.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("registration")
public class RegistrationController {
    private final UserRepository userRepo;

    public RegistrationController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("")
    public ModelAndView registration() {
        return new ModelAndView("registration");
    }

    @PostMapping("")
    public ModelAndView addUser(UserEntity user, Map<String, Object> model) {
        UserEntity userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return new ModelAndView("registration");
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.User));
        userRepo.save(user);

        return new ModelAndView("redirect:/login");
    }

    @PostMapping("isUserPresent")
    public ResponseEntity<?> isUserPresent(@RequestParam String username,
                                           @RequestParam String password) {
        UserEntity user = userRepo.findByUsernameAndPassword(username, password).orElse(null);
        if (user == null) return ResponseEntity.ok("false");
        return ResponseEntity.ok("true");
    }
}
