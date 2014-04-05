package ex.strategy.atomix_tx;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 03.09.13
 * Time: 14:49
 * To change this template use File | Settings | File Templates.
 */
public class AccountManagerX implements AccountManager {
    public boolean transfer(Account[] accounts, int[] money) {
        for (int k = 0; k < accounts.length; k++) {
            try {
                accounts[k].change(money[k]);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}
