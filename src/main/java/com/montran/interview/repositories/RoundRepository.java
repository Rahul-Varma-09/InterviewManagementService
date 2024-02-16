package com.montran.interview.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.montran.interview.entities.Round;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {
	
	List<Round> findByInterviewId(Long interviewId);

}
