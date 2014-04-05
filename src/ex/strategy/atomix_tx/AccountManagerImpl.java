package ex.strategy.atomix_tx;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 03.09.13
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
public class AccountManagerImpl implements AccountManager {
    @Override
    public boolean transfer(Account[] accounts, int[] money) {
        boolean result = true;
        int j = 0, i = 0;
        for (; i < accounts.length; i++) {
            try {
                accounts[i].change(money[i]);
            } catch (TryAgainException e) {
                i--;//попробовать ещё
            } catch (BlockAccountException e) {
                break;
            }
        }
        if (i != accounts.length) {
            result = false;
            for (; j < i; j++) {
                try {
                    accounts[j].change(-money[j]);
                } catch (TryAgainException e) {
                    j--;
                } catch (BlockAccountException e) {
                    //этого не должно случиться
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
        return result;
    }
}
