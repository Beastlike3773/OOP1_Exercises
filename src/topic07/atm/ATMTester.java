package topic07.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ATMTester {

    private static ATM theATM;

    @BeforeAll
    public static void setUp() {
        Bank theBank = new Bank();
        try {
            theBank.readCustomers("./src/topic07/atm/customers.txt");
        } catch (IOException e) {
            fail(e);
            e.printStackTrace();
        }
        theATM = new ATM(theBank);
    }

    @Test
    public void initialStateTest() {
        assertEquals(ATM.START, theATM.getState());
    }

    @Test
    public void afterReset() {
        theATM.reset();
        assertEquals(ATM.START, theATM.getState());
    }

    @Test
    public void setCustomerNumberTest() {
        theATM.setCustomerNumber(1234);
        assertEquals(ATM.PIN, theATM.getState());
    }

    // TODO add more tests

    @AfterAll
    public static void tearDown() {
        // cleaning up
    }
}
