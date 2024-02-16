package com.montran.interview.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class Round {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String roundNumber;
	private Date roundDate;
	private String roundTime;
	private String interviewerName;
	private String interviewerEmail;
	private String meetingUrl;
	private Date createdDate;
	private Long interviewId;
	private String status;
	
}
