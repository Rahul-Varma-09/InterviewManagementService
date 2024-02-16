package com.montran.interview.services.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.montran.interview.entities.Interview;
import com.montran.interview.entities.Round;
import com.montran.interview.http.response.GenericResponse;
import com.montran.interview.model.Candidate;
import com.montran.interview.repositories.InterviewRepository;
import com.montran.interview.repositories.RoundRepository;
import com.montran.interview.services.EmailService;
import com.montran.interview.services.InterviewService;

@Service
public class InterviewServiceImpl implements InterviewService {
	
	@Autowired private InterviewRepository interviewRepository;
	@Autowired private EmailService emailService;
	@Autowired private RoundRepository roundRepository;

	@Override
	public GenericResponse<?> fetchEligibleForInterview() {
		RestTemplate restTemplate = new RestTemplate();
		GenericResponse<?> candidateServiceResponse = restTemplate.getForEntity("http://localhost:7090/candidate/fetchByCVStatus/PENDING_FOR_CV_REVIEW", GenericResponse.class).getBody();
		try {
		   if (candidateServiceResponse.getBody() != null) {
			   ObjectMapper mapper = new ObjectMapper();
			   List<Candidate> candidateList = mapper.convertValue(candidateServiceResponse.getBody(), new TypeReference<List<Candidate>>() { });
			   return GenericResponse.builder().message("Fetched Eligible Candidates Successfully").code("OK").body(candidateList).build();
		   }	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return candidateServiceResponse;
	}

	@Override
	public GenericResponse<?> scheduleInterview(Interview interview) {
		Interview savedInterview = interviewRepository.save(interview); //Check if interview is Already scheduled for that candidate 
		return GenericResponse.builder().message("Interview Scheduled Successfully").code("OK").body(savedInterview).build();
	}

	@Override
	public GenericResponse<?> updateRoundDetailsInInterview(Round round) {
		//Check if Round is Already scheduled for that candidate
		Round savedRound = roundRepository.save(round);
		Interview interview = interviewRepository.findById(round.getInterviewId()).get();
		
		/** send Interview Invite to candidate & send Interview Schedule to Interviewer */ 
		emailService.sendEmailForMeetingInvitationToCandidate(interview.getCandidateEmail(), interview.getCandidateName(), new Date().toString(), round.getRoundTime(), round.getMeetingUrl());
		emailService.sendEmailToInterviewerEmailWithCvAttachment(round.getInterviewerEmail(), round.getInterviewerName(), interview.getCandidateName(), "2 Years", "Zinfinity Technologies LLP", new Date().toString(), round.getRoundTime(), round.getMeetingUrl(), new File("C:\\Users\\MONTRAN INDIA\\Desktop\\cv.pdf")); 
		return GenericResponse.builder().message("Round Scheduled Successfully").code("OK").body(savedRound).build();
	}

	@Override
	public GenericResponse<?> fetchInterviewDetails(Long id) {
		Optional<Interview> interview = interviewRepository.findById(id);
		if (interview.isPresent()) {
			List<Round> roundDetails = roundRepository.findByInterviewId(id);
			interview.get().getRoundList().addAll(roundDetails);
			return GenericResponse.builder().message("Interview Details Fetched Successfully").code("OK").body(interview).build();
		}
		return GenericResponse.builder().message("No Interview Found").code("WARN").body(interview).build();
	}

}
