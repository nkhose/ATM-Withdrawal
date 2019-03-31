package com.nikita.atm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ATMController2 {

//	@GetMapping("/atm")
//	public String getCalculate(@PathVariable("amt") int amt) {
//		String result = "Invalid enter amt" + amt; 
//		
//		if(result != null){
//			result = String.valueOf(amt);
//		}
//		
//		return result;
//	}
	
	 @RequestMapping(value = "/atm2")
	   public ResponseEntity<Object> getCalculation(@RequestParam ("amt") String amt) {
		 String s= "";
		 if(amt != null && amt.length() > 0){
			 try {
				 Double amount = Double.parseDouble(amt);
				 if(amount > 0 && amount <= 500) {
					 
					 if(amount == 500) {
						 s = "you get 1 notes of 500 $ " ;
					 } else {
						 s = "you get " + Math.round((amount/20)) + " notes of 20 $ " ;
						 if((amount%20) != 0){
							 s = s + "but " + (amount%20) + " less";
						 }
						 
						 s = s + "  .... & you get " + Math.round((amount/10)) + " notes of 10 $ " ;
						 if((amount%10) != 0){
							 s = s + "but " + (amount%10) + " less";
						 }
						
					 }
					 
					 s = s.replace(".0", "");
				 } else {
					 s = "Wrong Amount = "+  amount;
				 }
				 
			 } catch (Exception e) {
				 e.printStackTrace();
				 // s = e.getMessage();
				 s = "Enter valid Amount";
			 }
		 } else {
			 s = "Enter Amount";
		 }
		 
	      return new ResponseEntity<>(s, HttpStatus.OK);
	 }
	
	
}