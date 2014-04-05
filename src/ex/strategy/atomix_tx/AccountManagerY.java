package ex.strategy.atomix_tx;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 03.09.13
 * Time: 14:50
 * To change this template use File | Settings | File Templates.
 */
public class AccountManagerY implements AccountManager {
    public boolean transfer(Account[] accounts, int[] money) {
        try {
            for (int k = 0; k < accounts.length; k++) {
                while (true) {
                    try {
                        accounts[k].change(money[k]);
                        break;
                    } catch (TryAgainException e) {
                        // NOP
                    }
                }
            }
        } catch (BlockAccountException e) {
            return false;
        }
        return true;
    }
}
