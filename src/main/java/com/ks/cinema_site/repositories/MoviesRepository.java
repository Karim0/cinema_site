package com.ks.cinema_site.repositories;

import com.ks.cinema_site.entities.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<MoviesEntity, Long> {
    @Query("select m from MoviesEntity m where m.title like %?1%")
    List<MoviesEntity> findMoviesByTitle(String title);
}
