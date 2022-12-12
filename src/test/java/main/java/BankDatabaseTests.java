package main.java;
//testing -raven
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import main.java.ATM;
import main.java.Deposit;
import main.java.DepositSlot;
import main.java.Keypad;
import main.java.Screen;
import main.java.CashDispenser;
import main.java.BankDatabase;

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
		int id = 22221;
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

    @Test
    void T006_LoadTesting() {
        ATM atm;
        DepositSlot depositSlot = new DepositSlot();
        CashDispenser cashDispenser = new CashDispenser();
        BankDatabase bankDatabase = new BankDatabase();
        Keypad fakeKeypad = mock(Keypad.class);
        Screen fakeScreen = mock(Screen.class);

        //Initialize 10 users
        BankDatabase[] bankDatabaseList = new BankDatabase[10];
        for (int i = 0 ; i < bankDatabaseList.length ; i ++)
        {
            bankDatabaseList[i] = new BankDatabase();
        }
        ATM[] atmList = new ATM[10];
        for(int j = 0 ; j < bankDatabaseList.length; j++) {
            atmList[j] = new ATM(fakeScreen, fakeKeypad, cashDispenser, depositSlot, bankDatabaseList[j]);
        }
        //fake account for incorrect login
        int fakeID = 10000;
        int fakePass = 10000;

        int[] ids = new int[]{11111, 22222, 33333, 44444, 55555, 66666, 77777, 88888, 99999, 98765};
        int password = 11111;
        int password_9 = 56789;
        //passwords for users 1-9 are the same for other testing purposes
        int[] passwords = new int[]{password, password, password, password, password,
                password, password, password, password, password_9};
        //fake login
        boolean[] actualList1 = new boolean[10];
        for (int a = 0 ; a < bankDatabaseList.length; a++)
        {
            actualList1[a] = bankDatabaseList[a].authenticateUser(fakeID, fakePass);
            assertFalse(actualList1[a]);
        }
        //real login
        boolean[] actualList2 = new boolean[10];
        for (int b = 0 ; b < bankDatabaseList.length; b++)
        {
            actualList2[b] = bankDatabaseList[b].authenticateUser(ids[b], passwords[b]);
            assertTrue(actualList2[b]);
        }
        //get balance
        for (int c = 0 ; c < atmList.length ; c++) {
            when(fakeKeypad.getInput()).thenReturn(ids[c], passwords[c], 1, 4);
            atmList[c].run();
        }
        verify(fakeScreen, times(9)).displayDollarAmount(1200.00);
        //deposit $350
        for (int d = 0 ; d < atmList.length ; d++) {
            when(fakeKeypad.getInput()).thenReturn(ids[d], passwords[d], 3 , 35000, 1, 4);
            atmList[d].run();
        }
        verify(fakeScreen, times(9)).displayDollarAmount(1550.00);

    }

}
