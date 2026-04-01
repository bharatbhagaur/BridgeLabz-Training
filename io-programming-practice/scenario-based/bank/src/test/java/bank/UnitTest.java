package bank;




import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UnitTest {

    // 1️⃣ Deposit – Valid Amount
    @Test
    public void Test_Deposit_ValidAmount() {
        Program account = new Program(100.0);
        account.Deposit(50.0);

        assertEquals(150.0, account.Balance);
    }

    // 2️⃣ Deposit – Negative Amount
    @Test
    public void Test_Deposit_NegativeAmount() {
        Program account = new Program(100.0);

        Exception ex = assertThrows(
            IllegalArgumentException.class,
            () -> account.Deposit(-20.0)
        );

        assertEquals("Deposit amount cannot be negative", ex.getMessage());
    }

    // 3️⃣ Withdraw – Valid Amount
    @Test
    public void Test_Withdraw_ValidAmount() {
        Program account = new Program(200.0);
        account.Withdraw(80.0);

        assertEquals(120.0, account.Balance);
    }

    // 4️⃣ Withdraw – Insufficient Funds
    @Test
    public void Test_Withdraw_InsufficientFunds() {
        Program account = new Program(100.0);

        Exception ex = assertThrows(
            IllegalArgumentException.class,
            () -> account.Withdraw(150.0)
        );

        assertEquals("Insufficient funds.", ex.getMessage());
    }
}