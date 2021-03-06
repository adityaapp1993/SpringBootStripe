package com.example.SpringBootStripeProject.controller;

package com.example.SpringBootStripe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootStripe.model.StripeCard;
import com.example.SpringBootStripe.model.StripeCustomer;
import com.example.SpringBootStripe.service.CustomerService;
import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Customer;
import com.stripe.model.Card;

@RestController	
public class CustomerController {
	@Autowired
		private CustomerService customerService;
	
		@GetMapping(value="/v1/customers/{cid}")
		public String retrieveCustomer(@PathVariable String cid) throws AuthenticationException, InvalidRequestException, ApiException, CardException, ApiConnectionException {
			return customerService.retrieveCustomer(cid);
		}

		@PostMapping(value="/v1/customers")
		public Customer addCustomer(@RequestBody StripeCustomer cus) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException {
			return customerService.addCustomer(cus);
		}

		@PostMapping(value="/v1/customers/{cid}/sources")
		public Card addCard(@PathVariable StripeCard card) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException {
			return customerService.addCard(card);
		}
		
		@GetMapping(value="/helloworld")
		public String helloworld() throws AuthenticationException, InvalidRequestException, ApiException, CardException, ApiConnectionException {
			return "hello";
		}

}

