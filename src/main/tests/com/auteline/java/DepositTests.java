package main.java;

import static org.mockito.Mockito.*;
import org.junit.*;

import com.auteline.java.ATM;
import com.auteline.java.Deposit;
import com.auteline.java.DepositSlot;
import com.auteline.java.Keypad;
import com.auteline.java.Screen;
import com.auteline.java.CashDispenser;
import com.auteline.java.BankDatabase;

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
