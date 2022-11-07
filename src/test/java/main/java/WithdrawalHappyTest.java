package main.java;

import static org.mockito.Mockito.*;
import org.junit.*;

import main.java.ATM;
import main.java.BankDatabase;
import main.java.CashDispenser;
import main.java.DepositSlot;
import main.java.Keypad;
import main.java.Screen;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WithdrawalHappyTest {
    ATM atm;
    CashDispenser cashDispenser = new CashDispenser();
    DepositSlot depositSlot = new DepositSlot();
    BankDatabase bankDatabase = new BankDatabase();
    Keypad fakeKeypad = mock(Keypad.class);
    Screen fakeScreen = mock(Screen.class);

    @Before
    public final void setUp(){
        atm = new ATM(fakeScreen, fakeKeypad, cashDispenser, depositSlot, bankDatabase);
    }

    @Test
    public void WithdrawalTest() throws Exception{
        when(fakeKeypad.getInput()).thenReturn(11111, 11111, 2, 5);

        atm.run();

        verify(fakeScreen, times(1)).displayDollarAmount(800.0);
    }


}
