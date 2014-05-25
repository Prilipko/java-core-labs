package collections.eq_hash_toStr.EntityB;

import java.util.Arrays;

/**
 * Created by Worker on 25.05.14.
 */
public class EntityB {
    private final String[][] stringArr;
    private final double[] doubleArr;

    public EntityB(String[][] stringArr, double[] doubleArr) {
        this.stringArr = stringArr;
        this.doubleArr = doubleArr;
    }

    public String[][] getStringArr() {
        return stringArr;
    }

    public double[] getDoubleArr() {
        return doubleArr;
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(stringArr)*31 + Arrays.hashCode(doubleArr);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        EntityB that = (EntityB) obj;
        return Arrays.equals(doubleArr,that.getDoubleArr()) && Arrays.deepEquals(stringArr,that.getStringArr());
    }

    @Override
    public String toString() {
        return "[ stringArr: "+ Arrays.deepToString(stringArr)+", doubleArr: "+Arrays.toString(doubleArr)+"]";
    }
}