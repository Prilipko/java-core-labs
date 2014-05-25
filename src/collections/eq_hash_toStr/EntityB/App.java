package collections.eq_hash_toStr.EntityB;

import collections.eq_hash_toStr.EntityA.EntityA;

import java.util.*;


/**
 * Created by Worker on 09.05.14.
 */

public class App {
    public static void main(String[] args) {
        HashSet<EntityB> hashSet = new HashSet<>();

        hashSet.add(new EntityB( new String[][] {{"1","2"},{"3","4"}}, new double[] {5,6} ));
        hashSet.add(new EntityB( new String[][] {{"7","8"},{"9","10"}}, new double[] {11,12} ));
        hashSet.add(new EntityB( new String[][] {{"13","14"},{"15","16"}}, new double[] {17,18} ));
        hashSet.add(new EntityB( new String[][] {{"7","8"},{"9","10"}}, new double[] {11,12} ));

        System.out.println(Arrays.toString(hashSet.toArray()));
    }
}
