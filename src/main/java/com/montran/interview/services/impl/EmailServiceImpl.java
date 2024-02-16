package com.montran.interview.services.impl;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.montran.interview.constants.InterviewConstants;
import com.montran.interview.services.EmailService;

/**
 * @author rvarma
 * This class holds logic for sending interview related emails
 */
@Service
public class EmailServiceImpl implements EmailService {

	private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);
	
	@Value("${montranSenderFromEmail}")
	private String montranSenderFromEmail;
	
	@Value("${montranEmailPwd}")
	private String montranEmailPwd;
	
	@Value("${mailSmtpHost}")
	private String hostName;
	
	@Value("${mailSmtpPort}")
	private String portNumber;
	
	@Value("${mailSmtpSslEnable}")
	private Boolean sslEnableFlag;
	
	@Value("${mailSmtpAuth}")
	private Boolean smtpAuthFlag;
	
	@Override
	public void sendEmailForMeetingInvitationToCandidate(String to,String candidateName,String roundDate,String roundTime,String meetingLink) {
		try {
			Properties properties = System.getProperties();
			properties.put("mail.smtp.host", hostName);
			properties.put("mail.smtp.port", portNumber);
			properties.put("mail.smtp.ssl.enable", sslEnableFlag);
			properties.put("mail.smtp.auth", smtpAuthFlag);

			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(montranSenderFromEmail, montranEmailPwd);
				}
			});

			session.setDebug(true);
			
			MimeMessage message = new MimeMessage(session);
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setFrom(montranSenderFromEmail);
			helper.setTo(new InternetAddress(to));
			helper.setSubject(InterviewConstants.INTERVIEW_INVITE_SUBJECT);
			
			String content = InterviewConstants.EMAIL_INTERVIEW_INVITE_MAIL_CONTENT
					.replace("[[candidateName]]", candidateName)
					.replace("[[interviewDate]]", roundDate)
					.replace("[[interviewTime]]", roundTime)
					.replace("[[meetingLink]]", meetingLink);
			
			helper.setText(content, true);
			Transport.send(message);
			log.info("Mail Sent Successfully...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void sendEmailToInterviewerEmailWithCvAttachment(String to,String interviewerName,String candidateName,String candidateExperience,String candidatePreviousCompany,String roundDate,String roundTime,String meetingLink,File cv) {

		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", hostName);
		properties.put("mail.smtp.port", portNumber);
		properties.put("mail.smtp.ssl.enable", sslEnableFlag);
		properties.put("mail.smtp.auth", smtpAuthFlag);

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(montranSenderFromEmail, montranEmailPwd);
			}
		});
        
		session.setDebug(true);
		
		MimeMessage m = new MimeMessage(session);
		MimeMessageHelper helper = new MimeMessageHelper(m);
		try {
			helper.setFrom(montranSenderFromEmail);
			helper.setTo(new InternetAddress(to));
			helper.setSubject(InterviewConstants.INTERVIEW_SCHEDULE_SUBJECT);
	
			try {
				MimeMultipart mimeMultipart = new MimeMultipart();
				MimeBodyPart textMime = new MimeBodyPart();

				String content = InterviewConstants.EMAIL_INTERVIEW_SCHEDULE_MAIL_CONTENT
									.replace("[[interviewerName]]", interviewerName)
									.replace("[[candidateName]]", candidateName)
									.replace("[[candidateExperience]]", candidateExperience)
									.replace("[[candidatePreviousCompany]]", candidatePreviousCompany)
									.replace("[[interviewDate]]", roundDate)
									.replace("[[interviewTime]]", roundTime)
									.replace("[[meetingLink]]", meetingLink);
				
				helper.setText(content, true);
				textMime.setContent(content, "text/html");
				
				MimeBodyPart fileMime = new MimeBodyPart();
				fileMime.attachFile(cv);
				mimeMultipart.addBodyPart(textMime);
				mimeMultipart.addBodyPart(fileMime);
				
				m.setContent(mimeMultipart);
				Transport.send(m);
				log.info("Mail Sent Successfully");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
