package ex.strategy.atomix_tx;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 03.09.13
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 */
import java.util.Arrays;
import java.util.Random;
public class AccountManagerTest {
    public static final int MIN_ACCOUNT_COUNT = 2;
    public static final int MAX_ACCOUNT_COUNT = 10;
    public static final int MIN_MONEY_TRANSFER = 1;
    public static final int MAX_MONEY_TRANSFER = 10;
    public static void main(String[] args) {
        for (int k = 0; k < 1_000_000; k++) {
            final Random rnd = new Random(k);
            AccountManager manager = new AccountManagerImpl();
            final boolean[] blockedAccountExist = {false};
            AccountImpl[] accounts = generateAccounts(rnd, blockedAccountExist);
            int[] money = generateMoney(rnd, accounts.length);
            boolean transferOk = manager.transfer(accounts, money);
            if (transferOk) {
                checkTransferCommit(accounts, money);
            } else {
                checkTransferRollback(blockedAccountExist, accounts);
            }
        }
        System.out.println("OK!");
    }
    private static void checkTransferRollback(boolean[] blockedAccountExist, AccountImpl[]
            accounts) {
// rollback only if DeadAccount exist
        if (!blockedAccountExist[0]) {
            throw new AssertionError("Nothing blocked - but rollback!");
        }
        for (AccountImpl account : accounts) {
            if (account.getTotalChange() != 0) {
                throw new AssertionError("FAIL rollback: " + Arrays.toString(accounts));
            }
        }
    }
    private static void checkTransferCommit(AccountImpl[] accounts, int[] money) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getTotalChange() != money[i]) {
                throw new AssertionError("FAIL commit: " + Arrays.toString(accounts));
            }
        }
    }
    private static int[] generateMoney(Random rnd, int accountsCount) {
        int[] money = new int[accountsCount];
        int totalSum = 0;
        for (int k = 0; k < money.length - 1; k++) {
            money[k] = MIN_MONEY_TRANSFER + rnd.nextInt(MAX_MONEY_TRANSFER + 1 -
                    MIN_MONEY_TRANSFER);
            totalSum += money[k];
        }
        money[money.length - 1] = -totalSum; // money[0] + money[1] + ... + money[money.length-1] == 0
        return money;
    }
    private static AccountImpl[] generateAccounts(Random rnd, boolean[] zedDeadStatus) {
        int accountsCount = MIN_ACCOUNT_COUNT + rnd.nextInt(MAX_ACCOUNT_COUNT + 1 -
                MIN_ACCOUNT_COUNT);
        AccountImpl[] result = new AccountImpl[accountsCount];
        for (int k = 0; k < accountsCount; k++) {
            result[k] = new AccountImpl(rnd, zedDeadStatus);
        }
        return result;
    }
}
