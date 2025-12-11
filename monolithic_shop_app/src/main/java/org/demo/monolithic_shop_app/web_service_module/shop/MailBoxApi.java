package org.demo.monolithic_shop_app.web_service_module.shop;

import java.util.HashMap;

import org.demo.monolithic_shop_app.business_module.BusinessService;
import org.demo.monolithic_shop_app.business_module.Mail;
import org.demo.monolithic_shop_app.business_module.MailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

public class MailBoxApi {
	
	@Autowired
	private BusinessService businessService;
	
	@GetMapping("/api/mailbox")
	public MailDto queryAllMailBox(@RequestParam(name = "page", required = false) int page, @RequestParam(name = "size", required = false) int size
									, @RequestParam(name = "sort", required = false) String sort, @RequestParam(name = "direction", required = false) String direction) {
		return businessService.queryAllMails(page, size, sort, direction);
	}
	
	@PostMapping("/api/mailbox")
	public String createMail(@Valid @RequestBody Mail mail) {
		return businessService.createNewMailResource(mail) + "";
	}
	
	@GetMapping("/api/mailbox/conditions")
	public String queryMailByConditions(@RequestBody HashMap<String, String> conditionMap ) {
		return "empty";
	}
	
	@PatchMapping("/api/mailbox/{mail-id}")
	public String updateParticallyMail(@PathVariable(name = "mail-id") String mailId, @RequestBody HashMap<String, String> mail ) {
		return "empty";
	}
	
	@PutMapping("/api/mailbox")
	public String updateMail(@Valid @RequestBody Mail mail) {
		return businessService.updateMail(mail.getMailId(), mail) + "";
	}
	
	@DeleteMapping("/api/mailbox/{mail-id}")
	public String deleteMail(@PathVariable(name = "mail-id") String mailId) {
		return businessService.deleteMail(mailId) + "";
	}

}
