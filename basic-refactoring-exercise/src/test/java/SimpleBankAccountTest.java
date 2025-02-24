import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    public static final int WITHDRAWAL_FEE_AMOUNT = 1;
    public static final int DEPOSIT_AMOUNT = 100;
    public static final int INITIAL_BALANCE = 0;
    public static final int TEST_USERID = 2;
    public static final int WITHDRAW_AMOUNT = 70;

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testInitialBalance() {
        assertAll(
                () -> assertEquals(INITIAL_BALANCE, bankAccount.getBalance()),
                () -> assertEquals(accountHolder, bankAccount.getHolder())
        );
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int depositAmount = 50;
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.deposit(TEST_USERID, depositAmount);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        int expectedBalance = DEPOSIT_AMOUNT - WITHDRAW_AMOUNT - WITHDRAWAL_FEE_AMOUNT;
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), WITHDRAW_AMOUNT);
        assertEquals(expectedBalance, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(TEST_USERID, WITHDRAW_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }
}
