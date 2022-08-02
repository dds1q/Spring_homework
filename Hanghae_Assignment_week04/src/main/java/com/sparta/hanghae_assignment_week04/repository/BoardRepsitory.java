package com.sparta.hanghae_assignment_week04.repository;


import com.sparta.hanghae_assignment_week04.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepsitory extends JpaRepository<Board, Long> {
}
