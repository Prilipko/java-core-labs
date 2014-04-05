package ex.strategy.atomix_tx;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 03.09.13
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class AccountImpl implements Account {
    private final Random rnd;
    private final boolean[] blockedAccountExist;
    private int totalChange = 0;
    private List<String> changeHistory = new ArrayList<>();
    private boolean imDead = false;
    public AccountImpl(Random rnd, boolean[] blockedAccountExist) {
        this.rnd = rnd;
        this.blockedAccountExist = blockedAccountExist;
    }
    @Override
    public void change(int delta) throws TryAgainException, BlockAccountException {
        if (imDead) {
            throw new BlockAccountException();
        }
        int r = rnd.nextInt(100);
        if (r == 0 && !blockedAccountExist[0]) {
            blockedAccountExist[0] = true;
            imDead = true;
            changeHistory.add("blockAccount:" + delta);
            throw new BlockAccountException();
        } else if (r < 50) {
            changeHistory.add("tryAgain:" + delta);
            throw new TryAgainException();
        } else {
            totalChange += delta;
            changeHistory.add("ok:" + delta);
        }
    }
    int getTotalChange() {
        return totalChange;
    }
    @Override
    public String toString() {
        return "Account[totalChange=" + totalChange + ", changeHistory=" + changeHistory +
                "]";
    }
}
