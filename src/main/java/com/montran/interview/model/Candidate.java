package com.montran.interview.model;

import java.util.Date;

public class Candidate {

	private Long id;
	private String name;
	private Integer age;
	private String email;
	private String phoneNumber;
	private String dateOfBirth;
	private String education;
	private String currentLocation;
	private String previousCompany;
	private Double workExperience;
	private Long channelId;
	private String referralType;
	private String referralId;
	private Boolean markAsStarred;
	private String cvStatus;
	private String cvUpdatedBy;
	private Boolean finalOnboardFlag;
	private String status;
	private String rejectionCode;
	private Date createdDate;
	private byte[] cv;
	private String base64EncodedCv;
	private String uniqueAccessToken;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getPreviousCompany() {
		return previousCompany;
	}

	public void setPreviousCompany(String previousCompany) {
		this.previousCompany = previousCompany;
	}

	public Double getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(Double workExperience) {
		this.workExperience = workExperience;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public String getReferralType() {
		return referralType;
	}

	public void setReferralType(String referralType) {
		this.referralType = referralType;
	}

	public String getReferralId() {
		return referralId;
	}

	public void setReferralId(String referralId) {
		this.referralId = referralId;
	}

	public Boolean getMarkAsStarred() {
		return markAsStarred;
	}

	public void setMarkAsStarred(Boolean markAsStarred) {
		this.markAsStarred = markAsStarred;
	}

	public String getCvStatus() {
		return cvStatus;
	}

	public void setCvStatus(String cvStatus) {
		this.cvStatus = cvStatus;
	}

	public String getCvUpdatedBy() {
		return cvUpdatedBy;
	}

	public void setCvUpdatedBy(String cvUpdatedBy) {
		this.cvUpdatedBy = cvUpdatedBy;
	}

	public Boolean getFinalOnboardFlag() {
		return finalOnboardFlag;
	}

	public void setFinalOnboardFlag(Boolean finalOnboardFlag) {
		this.finalOnboardFlag = finalOnboardFlag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRejectionCode() {
		return rejectionCode;
	}

	public void setRejectionCode(String rejectionCode) {
		this.rejectionCode = rejectionCode;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public byte[] getCv() {
		return cv;
	}

	public void setCv(byte[] cv) {
		this.cv = cv;
	}

	public String getBase64EncodedCv() {
		return base64EncodedCv;
	}

	public void setBase64EncodedCv(String base64EncodedCv) {
		this.base64EncodedCv = base64EncodedCv;
	}

	public String getUniqueAccessToken() {
		return uniqueAccessToken;
	}

	public void setUniqueAccessToken(String uniqueAccessToken) {
		this.uniqueAccessToken = uniqueAccessToken;
	}

}
