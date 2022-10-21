package main.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.ATM;
import main.java.BankDatabase;

class AutelineTests {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testValidAcct() {
		int id = 11111;
		int pin = 11111;
		boolean val;
		
		BankDatabase bankDatabase = null;
		
		val = bankDatabase.authenticateUser(id, pin);
		
		assertTrue(val);
	}
	
	@Test
	void testInvalidAcct() {
		int id = 22222;
		int pin = 11111;
		boolean val;
		
		BankDatabase bankDatabase = null;
		
		val = bankDatabase.authenticateUser(id, pin);
		
		assertFalse(val);
	}

}
