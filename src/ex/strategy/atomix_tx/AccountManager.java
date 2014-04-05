package ex.strategy.atomix_tx;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 03.09.13
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 */
public interface AccountManager {
    public boolean transfer(Account[] accounts, int[] money);
}