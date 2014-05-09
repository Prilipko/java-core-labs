package collections.eq_hash_toStr.EntityA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.TreeSet;

/**
 * Created by Worker on 09.05.14.
 */
public class App {
    public static void main(String[] args) {
        HashSet<EntityA> hashSet = new HashSet<>();

        EntityA entityA = new EntityA();
        entityA.setAge(1);
        entityA.setHeight(2);
        entityA.setName("Name1");
        hashSet.add(entityA);

        entityA = new EntityA();
        entityA.setAge(3);
        entityA.setHeight(4);
        entityA.setName("Name2");
        hashSet.add(entityA);

        entityA = new EntityA();
        entityA.setAge(0);
        entityA.setHeight(0);
        entityA.setName("Name0");
        hashSet.add(entityA);

        entityA = new EntityA();
        entityA.setAge(3);
        entityA.setHeight(4);
        entityA.setName("Name2");
        hashSet.add(entityA);

        System.out.println(Arrays.toString(hashSet.toArray()));

        TreeSet<EntityA> treeSet = new TreeSet<>();

        entityA = new EntityA();
        entityA.setAge(1);
        entityA.setHeight(2);
        entityA.setName("Name1");
        treeSet.add(entityA);

        entityA = new EntityA();
        entityA.setAge(3);
        entityA.setHeight(4);
        entityA.setName("Name2");
        treeSet.add(entityA);

        entityA = new EntityA();
        entityA.setAge(0);
        entityA.setHeight(0);
        entityA.setName("Name0");
        treeSet.add(entityA);

        entityA = new EntityA();
        entityA.setAge(3);
        entityA.setHeight(4);
        entityA.setName("Name2");
        treeSet.add(entityA);

        System.out.println(Arrays.toString(treeSet.toArray()));


    }
}
