package main.java;

import static org.mockito.Mockito.*;
import org.junit.*;

import main.java.ATM;
import main.java.Deposit;
import main.java.DepositSlot;
import main.java.Keypad;
import main.java.Screen;
import main.java.CashDispenser;
import main.java.BankDatabase;

public class DepositTests {
    ATM atm;
    DepositSlot depositSlot = new DepositSlot();
    CashDispenser cashDispenser = new CashDispenser();
    BankDatabase bankDatabase = new BankDatabase();
    Keypad fakeKeypad = mock(Keypad.class);
    Screen fakeScreen = mock(Screen.class);

    @Before
    public final void setUp(){
        atm = new ATM(fakeScreen, fakeKeypad, cashDispenser, depositSlot, bankDatabase);
    }

    @Test
    public void DepositMoney() {

        when(fakeKeypad.getInput()).thenReturn(11111, 11111, 3, 50, 1, 4);

        atm.run();

        verify(fakeScreen, times(1)).displayDollarAmount(1200.50);

    }
}
