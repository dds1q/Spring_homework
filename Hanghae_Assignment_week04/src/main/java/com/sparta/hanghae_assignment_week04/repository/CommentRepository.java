package com.sparta.hanghae_assignment_week04.repository;


import com.sparta.hanghae_assignment_week04.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
