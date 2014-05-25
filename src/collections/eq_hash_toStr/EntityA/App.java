package collections.eq_hash_toStr.EntityA;

import java.util.*;


/**
 * Created by Worker on 09.05.14.
 */

class CmpNameAgeHeigh implements Comparator<EntityA> {

    @Override
    public int compare(EntityA o1, EntityA o2) {
        int result = o1.getName().compareTo(o2.getName());
        if (result == 0) {
            result = o1.getAge() - o2.getAge();
            if (result == 0) {
                return o1.getHeight() - o2.getHeight();
            }
        }
        return result;
    }
}

class CmpHeighAgeName implements Comparator<EntityA> {

    @Override
    public int compare(EntityA o1, EntityA o2) {
        int result = o1.getHeight() - o2.getHeight();
        if (result == 0) {
            result = o1.getAge() - o2.getAge();
            if (result == 0) {
                return o1.getName().compareTo(o2.getName());
            }
        }
        return result;
    }
}

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

        TreeSet<EntityA> treeSet = new TreeSet<>(new CmpHeighAgeName());

        entityA = new EntityA();
        entityA.setAge(10);
        entityA.setHeight(9);
        entityA.setName("Name1");
        treeSet.add(entityA);

        entityA = new EntityA();
        entityA.setAge(8);
        entityA.setHeight(7);
        entityA.setName("Name2");
        treeSet.add(entityA);

        entityA = new EntityA();
        entityA.setAge(6);
        entityA.setHeight(5);
        entityA.setName("Name0");
        treeSet.add(entityA);

        entityA = new EntityA();
        entityA.setAge(4);
        entityA.setHeight(3);
        entityA.setName("Name2");
        treeSet.add(entityA);

        System.out.println(Arrays.toString(treeSet.toArray()));

        Random random = new Random(0);
        HashSet<EntityA> timeHash = new HashSet<>();

        long sTime = 0;
        for(int j=0;j<100;j++){
        long time = -System.nanoTime();
        for (int i = 0; i < 100; i++) {
            EntityA entity = new EntityA();
            entity.setName(Integer.toString(random.nextInt()));
            entity.setAge(random.nextInt());
            entity.setHeight(random.nextInt());
            timeHash.add(entity);
        }
        time += System.nanoTime();
            sTime+=time;
        }
        sTime /=100;
        System.out.println("Time add: " + sTime);

    }
}
