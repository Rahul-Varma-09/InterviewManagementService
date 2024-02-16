package com.montran.interview.services;

import com.montran.interview.entities.Interview;
import com.montran.interview.entities.Round;
import com.montran.interview.http.response.GenericResponse;

public interface InterviewService {

	public GenericResponse<?> fetchEligibleForInterview();
	
	public GenericResponse<?> scheduleInterview(Interview interview);
	
	public GenericResponse<?> updateRoundDetailsInInterview(Round round);

	public GenericResponse<?> fetchInterviewDetails(Long id);

}
