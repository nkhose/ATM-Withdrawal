package com.nikita.atm;

import java.util.ArrayList;
import java.util.HashMap;

public class ATM {

	public int totalAmount, amount, modAmount;
	public final int[] currDenom = { 500, 50, 20 };
	public int[] currNo = { 10, 20, 30 };
	public int[] count = { 0, 0, 0 };
	int ioamount = 0;
	int ioamount1 = 0;

	public ATM() {
		super();
	}

	HashMap<String, Object> map = new HashMap<>();

	public HashMap<String, Object> getResult(int amt) {
		this.amount = amt;
		for (int i = 0; i < currDenom.length; i++) {
			totalAmount = totalAmount + currDenom[i] * currNo[i];
		}

		ioamount = amount;
		if (amount >= 20 && amount <= 500 && amount % 10 == 0) {

			int sumChecker = 0;
			ArrayList<HashMap<String, Object>> aList = new ArrayList();
			for (int i = 0; i < currDenom.length; i++) {
				if (currDenom[i] <= amount) {
					int noteCount = amount / currDenom[i];
					if (currNo[i] > 0) {
						count[i] = noteCount >= currNo[i] ? currNo[i] : noteCount;
						currNo[i] = noteCount >= currNo[i] ? 0 : currNo[i] - noteCount;
						totalAmount = totalAmount - (currDenom[i] * count[i]);
						amount = amount - (count[i] * currDenom[i]);
					}
					// Add notes
					HashMap<String, Object> hm = new HashMap<>();
					hm.put("Notes", currDenom[i]);
					hm.put("Qty", count[i]);
					// hm.put("Amount", (currDenom[i] * count[i]));
					aList.add(hm);
					System.out.println(currDenom[i] + " x " + count[i] + " = " + (currDenom[i] * count[i]));
					sumChecker = sumChecker + (currDenom[i] * count[i]);
					// System.out.println(sumChecker +" and "+ioamount);
				}
				// map.put("Notes", aList);
			}
			int remainder = ioamount - sumChecker;
			System.out.println("\nsumChecker value is " + sumChecker + " which is not match with Entered Amount in ATM");
			System.out.println("Other Possible Combinations are:");

			if (remainder == 10) {
				aList = new ArrayList<>();
				int remaingBalance = ioamount - 20;

				while (remaingBalance % 50 != 0) {
					remaingBalance = remaingBalance - 20;
				}
				// System.out.println("\nFinal remaingBalance is:::: " +remaingBalance);
				int NewRemaingBalance = remaingBalance / 50;
				// System.out.println("New remaingBalance reminder: " +NewRemaingBalance);

				// Add notes
				HashMap<String, Object> hm = new HashMap<>();
				System.out.println("50 x " + NewRemaingBalance + " = " + remaingBalance);
				if (NewRemaingBalance != 0) {
					hm.put("Notes", "50");
					hm.put("Qty", NewRemaingBalance);
					aList.add(hm);
				}

				remaingBalance = ioamount - remaingBalance;
				NewRemaingBalance = remaingBalance / 20;
				System.out.println("20 x " + NewRemaingBalance + " = " + remaingBalance);

				hm = new HashMap<>();
				if (NewRemaingBalance != 0) {
					hm.put("Notes", "20");
					hm.put("Qty", NewRemaingBalance);
					aList.add(hm);
				}

			}
			map.put("Notes", aList);

			if (sumChecker == amount) {
				for (int i = 0; i < count.length; i++) {
					if (count[i] != 0) {
						System.out.println(currDenom[i] + " x " + count[i] + " = " + (currDenom[i] * count[i]));
					}
				}
			}

		} else {
			System.out.println("ATM cannot dispense this Amount, Please choose another Amount");
			map.put("Message", "ATM cannot dispense this Amount, Please choose another Amount");
		}

		return map;
	}

}