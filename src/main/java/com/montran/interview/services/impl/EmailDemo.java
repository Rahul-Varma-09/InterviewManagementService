package com.montran.interview.services.impl;

import java.io.File;
import java.util.Date;

public class EmailDemo {
	
	public static void main(String[] args) {
	
		EmailServiceImpl emailService = new EmailServiceImpl();
		
		emailService.sendEmailForMeetingInvitationToCandidate("rvarma@montran.com", "Rahul Varma",  new Date().toString() , "3.00 pm", "https://us06web.zoom.us/j/85812919129");
		
		emailService.sendEmailToInterviewerEmailWithCvAttachment("apandey@montran.com", "Aditi", "Rahul Varma", "2 years", "Zinfinty Technologies LLP", new Date().toString() , "3.00 pm", "https://us06web.zoom.us/j/85812919129", new File("C:\\Users\\MONTRAN INDIA\\Desktop\\cv.pdf"));
		
	}

}
