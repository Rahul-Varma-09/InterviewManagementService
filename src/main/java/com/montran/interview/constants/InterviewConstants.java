package com.montran.interview.constants;

public class InterviewConstants {

	public static final String INTERVIEW_SCHEDULE_SUBJECT = "Interview Schedule";
	public static final String EMAIL_INTERVIEW_SCHEDULE_MAIL_CONTENT = "Dear [[interviewerName]], <br><br> As discussed, Please find the Interview Details as follows."
			+ "<br><br><b> Candidate Name : </b>[[candidateName]]"
			+ "<br><b>Candidate Experience : </b>[[candidateExperience]]"
			+ "<br><b>Candidate Previous Company : </b>[[candidatePreviousCompany]]"
			+ "<br><b>Interview Date : </b>[[interviewDate]]"
			+ "<br><b>Interview Time : </b>[[interviewTime]]"
			+ "<br><b>Meeting Link : </b>[[meetingLink]] <br>"
			+ "<br>Regards,<br>"
			+ "Montran Recruitment Team.<br>" + "Goregaon Mumbai, India.";
	
	public static final String INTERVIEW_INVITE_SUBJECT = "Interview Invite";
	public static final String EMAIL_INTERVIEW_INVITE_MAIL_CONTENT = "Dear [[candidateName]], <br><br> Please find the Interview Details as follows."
			+ "<br><br> Interview Date : [[interviewDate]]"
			+ "<br>Interview Time : [[interviewTime]]"
			+ "<br>Meeting Link : [[meetingLink]] <br>"
			+ "<br>Regards,<br>"
			+ "Montran Recruitment Team.<br>" + "Goregaon Mumbai, India.";
	
}
