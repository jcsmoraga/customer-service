package com.example.demo.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Account;

@Component
public class AccountRestTemplateClient {

	@Autowired
	RestTemplate restTemplate;

	public Account getAccount(String accountNumber) {

		ResponseEntity<Account> restExchange = restTemplate.exchange("http://account-service/accounts/{accountNumber}",
				HttpMethod.GET, null, Account.class, accountNumber);

		return restExchange.getBody();
	}

	public Account saveAccount(Account account) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Account> request = new HttpEntity<Account>(account, headers);
		ResponseEntity<Account> restExchange = restTemplate.exchange("http://account-service/accounts", HttpMethod.POST,
				request, Account.class);
		return restExchange.getBody();
	}

}
