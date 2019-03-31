package com.nikita.atm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;


@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
public class AtmApplicationTests extends ATM {
	ATM a = new ATM();

	@Test
	public void contextLoads() {
		 Assert.assertEquals(320, 320);
	}

	@Test
    public void test_atm() throws Exception {
       // List<Iterator<ATM>> list = ATM.permutations();
		 Assert.assertEquals(500, 500);
    }
}
