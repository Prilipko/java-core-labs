package ex.strategy.atomix_tx;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 01.09.13
 * Time: 22:05
 * To change this template use File | Settings | File Templates.
 */
public interface Account {
    public void change(int delta) throws TryAgainException, BlockAccountException;
}