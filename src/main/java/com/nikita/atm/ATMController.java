package com.nikita.atm;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ATMController {

	@RequestMapping(value = "/atm")
	public HashMap<String, Object> getCalculation(@RequestParam("amt") String amt) {
		HashMap<String, Object> map = new HashMap<>();

		try {
			Integer amount = Integer.parseInt(amt);
			ATM a = new ATM();
			map.put("result", "OK");
			map.put("notes", a.getResult(amount));

		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "Exception");
			map.put("message", e.getMessage());
		}

		return map;
	}

}