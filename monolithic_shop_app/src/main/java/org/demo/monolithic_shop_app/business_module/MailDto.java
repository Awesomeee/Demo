package org.demo.monolithic_shop_app.business_module;

import java.time.LocalDateTime;

import org.demo.monolithic_shop_app.security_module.User;

public class MailDto {
	
	private String mailId;
	private String subject;
	private LocalDateTime createdDateTime;
	private String fromUser;
	private String toUser;
	private String message;
	private String state;		//1: read; 2: unread
	private User user;
	
	public MailDto() {}
	
	public MailDto(String mailId, String subject, LocalDateTime createdDateTime, String fromUser, String toUser, String message, String state
			, User user) {
		this.mailId = mailId;
		this.subject = subject;
		this.createdDateTime = createdDateTime;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.message = message;
		this.state = state;
		this.user = user;
	}
	
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
