package com.montran.interview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.montran.interview.entities.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long> {

}
