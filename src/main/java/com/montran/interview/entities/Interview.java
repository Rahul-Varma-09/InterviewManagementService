package com.montran.interview.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class Interview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Long candidateId;
	private String interviewScheduledBy;
	private String interviewMode;
	private String interviewStatus;
	private String candidateName;
	private String candidateEmail;
	private String based64EncodedCv;
	
	@Transient
	List<Round> roundList = new ArrayList<Round>();
}
