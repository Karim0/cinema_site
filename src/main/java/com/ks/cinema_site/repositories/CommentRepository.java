package com.ks.cinema_site.repositories;

import com.ks.cinema_site.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    @Query("select c from CommentEntity c where c.cinema_id = ?1")
    List<CommentEntity> findCommentByCinemaId(Long cinema_id);
}
