package main.java;

import static org.mockito.Mockito.*;
import org.junit.*;

import com.auteline.java.*;

public class IntegrationTests {

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
    public void CheckingBalance() {

        when(fakeKeypad.getInput()).thenReturn(11111, 11111, 1, 4);

        atm.run();

        verify(fakeScreen, times(1)).displayDollarAmount(1000.0);
    }

    @Test
    public void DepositMoney() {

        when(fakeKeypad.getInput()).thenReturn(11111, 11111, 3, 50, 1, 4);

        atm.run();

        verify(fakeScreen, times(1)).displayDollarAmount(1200.50);

    }

    @Test
    public void WithdrawalTest() {

        when(fakeKeypad.getInput()).thenReturn(11111, 11111, 2, 5, 1, 4);

        atm.run();

        verify(fakeScreen, times(1)).displayDollarAmount(1000.0);

    }
}
