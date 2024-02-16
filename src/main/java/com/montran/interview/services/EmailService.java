package com.montran.interview.services;

import java.io.File;

public interface EmailService {
	
	public void sendEmailForMeetingInvitationToCandidate(String to,String candidateName,String roundDate,String roundTime,String roundMeetingLink);
	
	public void sendEmailToInterviewerEmailWithCvAttachment(String to,String interviewerName,String candidateName,String candidateExperience,String candidatePreviousCompany,String roundDate,String roundTime,String meetingLink,File cv);

}
