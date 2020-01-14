package com.ks.cinema_site.controllers;

import com.ks.cinema_site.entities.CommentEntity;
import com.ks.cinema_site.entities.Schedule;
import com.ks.cinema_site.entities.UserEntity;
import com.ks.cinema_site.repositories.CommentRepository;
import com.ks.cinema_site.repositories.MoviesRepository;
import com.ks.cinema_site.repositories.ScheduleRepository;
import com.ks.cinema_site.repositories.UserRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class MovieController {
    private final MoviesRepository moviesRepository;
    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    public MovieController(MoviesRepository moviesRepository,
                           ScheduleRepository scheduleRepository,
                           CommentRepository commentRepository) {
        this.moviesRepository = moviesRepository;
        this.scheduleRepository = scheduleRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("movie/{id}")
    public ModelAndView getMovie(@AuthenticationPrincipal UserEntity user, @PathVariable long id) {
        Map<String, Object> root = new HashMap<>();
        root.put("movie", moviesRepository.getOne(id));
        root.put("schedule", scheduleRepository.findSchedulesByMovie(id));
        root.put("comment", commentRepository.findCommentByCinemaId(id));
        root.put("user", user);
        return new ModelAndView("movie", root);
    }


    @PostMapping("movie/{id}")
    public ModelAndView sortType(@AuthenticationPrincipal UserEntity user, @PathVariable long id, @RequestParam String type) {
        Map<String, Object> root = new HashMap<>();
        root.put("movie", moviesRepository.getOne(id));
        root.put("comment", commentRepository.findCommentByCinemaId(id));
        List<Schedule> schedules = scheduleRepository.findSchedulesByMovie(id);
        if (type.equals("actual")) {
            String format = DateTimeFormatter.ofPattern("HH:mm").format(LocalDateTime.now());
            int curTime = Integer.parseInt(format.split(":")[0]) * 60 +
                    Integer.parseInt(format.split(":")[1]);
            for (int i = schedules.size() - 1; i >= 0; i--) {
                int time = Integer.parseInt(schedules.get(i).getTime().split(":")[0]) * 60 +
                        Integer.parseInt(schedules.get(i).getTime().split(":")[1]);
                if (time < curTime) {
                    schedules.remove(i);
                }
            }
        } else {
            schedules.sort(new Comparator<Schedule>() {
                @Override
                public int compare(Schedule o1, Schedule o2) {
                    switch (type) {
                        case "name":
                            return o2.getNameCinema().compareTo(o1.getNameCinema());
                        case "time":
                            int time1 = Integer.parseInt(o1.getTime().split(":")[0]) * 60 +
                                    Integer.parseInt(o1.getTime().split(":")[1]);
                            int time2 = Integer.parseInt(o2.getTime().split(":")[0]) * 60 +
                                    Integer.parseInt(o2.getTime().split(":")[1]);
                            return time1 - time2;
                        case "language":
                            return o1.getLanguage().compareTo(o2.getLanguage());
                        default:
                            return 0;
                    }

                }
            });
        }
        root.put("schedule", schedules);
        root.put("user", user);
        return new ModelAndView("movie", root);
    }

    @PostMapping("movie/addComment")
    public ModelAndView addComment(@AuthenticationPrincipal UserEntity user, @RequestParam long id_cinema,
                                   @RequestParam String comment) {
        commentRepository.save(new CommentEntity(id_cinema, user, comment, new Date()));

        return new ModelAndView("redirect:/movie/" + id_cinema);
    }
}
