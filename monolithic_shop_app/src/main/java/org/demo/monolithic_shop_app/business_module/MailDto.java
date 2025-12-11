package org.demo.monolithic_shop_app.business_module;

import java.util.List;

public class MailDto {
	
	private List<Mail> mails;
	
	public MailDto() {}
	
	public MailDto(List<Mail> mails) {
		this.mails = mails;
	}

	public List<Mail> getMails() {
		return mails;
	}

	public void setMails(List<Mail> mails) {
		this.mails = mails;
	}

}
