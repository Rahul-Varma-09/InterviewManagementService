package com.montran.interview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.montran.interview.entities.Interview;
import com.montran.interview.entities.Round;
import com.montran.interview.http.response.GenericResponse;
import com.montran.interview.services.InterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewController {
	
	@Autowired private InterviewService interviewService;
	
	@GetMapping("/fetch/eligible")
	public GenericResponse<?> fetchEligibleForInterview() {
		return interviewService.fetchEligibleForInterview();
	}
	
	@PostMapping("/schedule")
	public GenericResponse<?> scheduleInterview(@RequestBody Interview interview) {
		return interviewService.scheduleInterview(interview);
	}
	
	@PostMapping("/schedule/update/round")
	public GenericResponse<?> scheduleRound(@RequestBody Round round) {
		return interviewService.updateRoundDetailsInInterview(round);
	}
	
	@GetMapping("/fetch/interviewDetails/{id}")
	public GenericResponse<?> fetchInterviewDetails(@PathVariable("id") Long id) {
		return interviewService.fetchInterviewDetails(id);
	}

}
