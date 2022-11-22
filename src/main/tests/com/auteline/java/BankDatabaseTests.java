package main.java;
//testing -raven
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.auteline.java.ATM;
import com.auteline.java.BankDatabase;

class BankDatabaseTests {
	
	@Test
	void testValidAcct() {
		int id = 11111;
		int pin = 11111;
		boolean val;
		
		BankDatabase bankDatabase = new BankDatabase();
		
		val = bankDatabase.authenticateUser(id, pin);
		
		assertTrue(val);
	}
	
	@Test
	void testInvalidAcct() {
		int id = 22222;
		int pin = 11111;
		boolean val;
		
		BankDatabase bankDatabase = new BankDatabase();
		
		val = bankDatabase.authenticateUser(id, pin);
		
		assertFalse(val);
	}

    //correct pin for acc1 should be 11111
    @Test
    void T003_1_ValidPinAcc1() {
        int id = 11111;
        int pin = 11111;
        boolean val;
        
        BankDatabase bankDatabase = new BankDatabase();
        
        val = bankDatabase.authenticateUser(id, pin);
        
        assertTrue(val);
    }

    @Test
    void T003_2_InvalidPinAcc1() {
        int id = 11111;
        int pin = 56789;
        boolean val;
        
        BankDatabase bankDatabase = new BankDatabase();
        
        val = bankDatabase.authenticateUser(id, pin);
        
        assertFalse(val);
    }
    //correct pin for acc2 should be 56789
    @Test
    void T004_1_ValidPinAcc2() {
        int id = 98765;
        int pin = 56789;
        boolean val;
        
        BankDatabase bankDatabase = new BankDatabase();
        
        val = bankDatabase.authenticateUser(id, pin);
        
        assertTrue(val);
    }

    @Test
    void T004_2_InvalidPinAcc2() {
        int id = 98765;
        int pin = 11111;
        boolean val;
        
        BankDatabase bankDatabase = new BankDatabase();
        
        val = bankDatabase.authenticateUser(id, pin);
        
        assertFalse(val);
    }
    
    //Account 1 should only have 1200
    @Test
    void T005_1_ViewBankBalanceAcc1() {
        int id = 11111;
        double actual, EXPECTED;
        
        EXPECTED = 1200;
        BankDatabase bankDatabase = new BankDatabase();
        
        actual = bankDatabase.getTotalBalance(id);
        
        assertEquals(EXPECTED, actual);
    }
    //Account 2 should only have 200
    @Test
    void T005_2_ViewBankBalanceAcc2() {
        int id = 98765;
        double actual, EXPECTED;
        
        EXPECTED = 200;
        BankDatabase bankDatabase = new BankDatabase();
        
        actual = bankDatabase.getTotalBalance(id);
        
        assertEquals(EXPECTED, actual);
    }
	
}
