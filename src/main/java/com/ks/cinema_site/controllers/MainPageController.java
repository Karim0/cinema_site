package com.ks.cinema_site.controllers;

import com.ks.cinema_site.entities.MoviesEntity;
import com.ks.cinema_site.entities.UserEntity;
import com.ks.cinema_site.repositories.MoviesRepository;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

@RestController
public class MainPageController {
    private final MoviesRepository moviesRepository;

    public MainPageController(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @GetMapping("")

    public ModelAndView getMainPage(@AuthenticationPrincipal UserEntity user) {
        Map<String, Object> root = new HashMap<>();
        List<MoviesEntity> movies = moviesRepository.findAll();
        Date d = new Date();
        List<MoviesEntity> premiere = new ArrayList<>();

        for (int i = movies.size() - 1; i >= 0; i--) {
            if (movies.get(i).getRealise().compareTo(d) > 0) {
                premiere.add(movies.get(i));
                movies.remove(i);
            }
        }

        root.put("movies", movies);
        root.put("user", user);

        premiere.sort(new Comparator<MoviesEntity>() {
            @Override
            public int compare(MoviesEntity o1, MoviesEntity o2) {
                return o1.getRealise().compareTo(o2.getRealise());
            }
        });
        root.put("premiere", premiere.subList(0, Math.min(premiere.size(), 10)));
        return new ModelAndView("index", root);
    }

    @PostMapping("")
    public ModelAndView search(@AuthenticationPrincipal UserEntity user, @RequestParam String title) {
        Map<String, Object> root = new HashMap<>();
        if (title.isEmpty()) {
            root.put("movies", moviesRepository.findAll());
        } else {
            root.put("movies", moviesRepository.findMoviesByTitle(title));
        }
        root.put("user", user);
        return new ModelAndView("index", root);
    }
}
