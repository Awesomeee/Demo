package org.demo.monolithic_shop_app.data_module.database;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MailBox")
public class MailBoxTable {
	
	@Id
	private String mailId;
	@Column
	private String subject;
	@Column
	private LocalDateTime createdDateTime;
	@Column
	private String fromUser;
	@Column
	private String toUser;
	@Column
	private String message;
	@Column
	private String state;		//1: read; 2: unread
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserTable user;
	
	public MailBoxTable() {
		
	}
	
	public MailBoxTable(String mailId, String subject, LocalDateTime createdDateTime, String fromUser, String toUser, String message, String state
			, UserTable user) {
		this.setMailId(mailId);
		this.setSubject(subject);
		this.setCreatedDateTime(createdDateTime);
		this.setFrom(fromUser);
		this.setTo(toUser);
		this.setMessage(message);
		this.setState(state);
		this.setUser(user);
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

	public String getFrom() {
		return fromUser;
	}

	public void setFrom(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getTo() {
		return toUser;
	}

	public void setTo(String toUser) {
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

	public UserTable getUser() {
		return user;
	}

	public void setUser(UserTable user) {
		this.user = user;
	}

}
