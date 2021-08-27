package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ecommerce.model.ChargeRequest;
import com.example.ecommerce.model.ChargeRequest.Currency;
import com.example.ecommerce.service.imp.StripeService;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Controller
public class ChargeController {
	@Autowired
	private StripeService stripeService;

	@PostMapping("/charge")
	public String charge(ChargeRequest chargeRequest, Model model) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException, APIException {
		chargeRequest.setDescription("Example Charge");
		chargeRequest.setCurrency(Currency.EUR);
		Charge charge = stripeService.charge(chargeRequest);
		model.addAttribute("id", charge.getId());
		model.addAttribute("status", charge.getStatus());
		model.addAttribute("chargeId", charge.getId());
		model.addAttribute("balance_transaction", charge.getBalanceTransaction());
		return "result";
	}

	@ExceptionHandler(StripeException.class)
	public String handleError(Model model, StripeException ex) {
		model.addAttribute("error", ex.getMessage());
		return "result";
	}
}
