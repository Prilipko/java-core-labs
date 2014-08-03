package collections.eq_hash_toStr.EntityC;

import collections.eq_hash_toStr.EntityA.EntityA;
import collections.eq_hash_toStr.EntityB.EntityB;

import java.util.*;

/**
 * Created by Worker on 25.05.14.
 */



public class App {
    public static void main(String[] args) {
        HashSet<EntityC> hashSet;

        hashSet = new HashSet<>();

        EntityA entity;

        List<EntityB> list;

        EntityA aEntitySetMap;
        Set<EntityA> aSetMap;
        EntityB[] arrayBListMap;
        List<EntityB[]> abListMap;
        Map<Set<EntityA>, List<EntityB[]>> map;


        entity = new EntityA();
        entity.setName("1");
        entity.setAge(2);
        entity.setHeight(3);

        list = new ArrayList<>();
        aSetMap = new HashSet<>();
        abListMap = new ArrayList<>();
        map = new HashMap<>();

        list.add(new EntityB( new String[][] {{"4","5"},{"6","7"}}, new double[] {8,9} ));
        list.add(new EntityB( new String[][] {{"10","11"},{"12","13"}}, new double[] {14,15} ));

        aEntitySetMap = new EntityA();
        aEntitySetMap.setName("16");
        aEntitySetMap.setAge(17);
        aEntitySetMap.setHeight(18);
        aSetMap.add(aEntitySetMap);

        aEntitySetMap = new EntityA();
        aEntitySetMap.setName("19");
        aEntitySetMap.setAge(20);
        aEntitySetMap.setHeight(21);
        aSetMap.add(aEntitySetMap);

        arrayBListMap = new EntityB[] {
          new EntityB( new String[][] {{"22","23"},{"24","25"}}, new double[] {26,27} ),
          new EntityB( new String[][] {{"28","29"},{"30","31"}}, new double[] {32,33} )
        };
        abListMap.add(arrayBListMap);
        arrayBListMap = new EntityB[] {
                new EntityB( new String[][] {{"34","35"},{"36","37"}}, new double[] {38,39} ),
                new EntityB( new String[][] {{"40","41"},{"42","43"}}, new double[] {44,45} )
        };
        abListMap.add(arrayBListMap);
        map.put(aSetMap,abListMap);

        aSetMap = new HashSet<>();

        aEntitySetMap = new EntityA();
        aEntitySetMap.setName("46");
        aEntitySetMap.setAge(47);
        aEntitySetMap.setHeight(48);
        aSetMap.add(aEntitySetMap);

        aEntitySetMap = new EntityA();
        aEntitySetMap.setName("49");
        aEntitySetMap.setAge(50);
        aEntitySetMap.setHeight(51);
        aSetMap.add(aEntitySetMap);

        abListMap = new ArrayList<>();
        arrayBListMap = new EntityB[] {
                new EntityB( new String[][] {{"52","53"},{"54","55"}}, new double[] {56,57} ),
                new EntityB( new String[][] {{"58","59"},{"60","61"}}, new double[] {62,63} )
        };
        abListMap.add(arrayBListMap);
        arrayBListMap = new EntityB[] {
                new EntityB( new String[][] {{"64","65"},{"66","67"}}, new double[] {68,69} ),
                new EntityB( new String[][] {{"70","71"},{"72","73"}}, new double[] {74,75} )
        };
        abListMap.add(arrayBListMap);
        map.put(aSetMap,abListMap);

        hashSet.add(new EntityC(entity,list,map));




        //--------------------------------------------------------------------------

        entity = new EntityA();
        entity.setName("74");
        entity.setAge(75);
        entity.setHeight(76);

        list = new ArrayList<>();
        aSetMap = new HashSet<>();
        abListMap = new ArrayList<>();
        map = new HashMap<>();

        list.add(new EntityB( new String[][] {{"77","78"},{"79","80"}}, new double[] {81,82} ));
        list.add(new EntityB( new String[][] {{"83","84"},{"85","86"}}, new double[] {87,88} ));

        aEntitySetMap = new EntityA();
        aEntitySetMap.setName("88");
        aEntitySetMap.setAge(89);
        aEntitySetMap.setHeight(90);
        aSetMap.add(aEntitySetMap);

        aEntitySetMap = new EntityA();
        aEntitySetMap.setName("91");
        aEntitySetMap.setAge(92);
        aEntitySetMap.setHeight(93);
        aSetMap.add(aEntitySetMap);

        arrayBListMap = new EntityB[] {
                new EntityB( new String[][] {{"94","95"},{"96","97"}}, new double[] {98,99} ),
                new EntityB( new String[][] {{"100","101"},{"102","103"}}, new double[] {104,105} )
        };
        abListMap.add(arrayBListMap);
        arrayBListMap = new EntityB[] {
                new EntityB( new String[][] {{"106","107"},{"108","109"}}, new double[] {110,111} ),
                new EntityB( new String[][] {{"112","113"},{"114","115"}}, new double[] {116,117} )
        };
        abListMap.add(arrayBListMap);
        map.put(aSetMap,abListMap);

        aSetMap = new HashSet<>();

        aEntitySetMap = new EntityA();
        aEntitySetMap.setName("118");
        aEntitySetMap.setAge(119);
        aEntitySetMap.setHeight(120);
        aSetMap.add(aEntitySetMap);

        aEntitySetMap = new EntityA();
        aEntitySetMap.setName("121");
        aEntitySetMap.setAge(122);
        aEntitySetMap.setHeight(123);
        aSetMap.add(aEntitySetMap);

        abListMap = new ArrayList<>();

        arrayBListMap = new EntityB[] {
                new EntityB( new String[][] {{"124","125"},{"126","127"}}, new double[] {128,129} ),
                new EntityB( new String[][] {{"130","131"},{"132","133"}}, new double[] {134,135} )
        };
        abListMap.add(arrayBListMap);
        arrayBListMap = new EntityB[] {
                new EntityB( new String[][] {{"136","137"},{"138","139"}}, new double[] {140,141} ),
                new EntityB( new String[][] {{"142","143"},{"144","145"}}, new double[] {146,147} )
        };
        abListMap.add(arrayBListMap);
        map.put(aSetMap,abListMap);

        hashSet.add(new EntityC(entity,list,map));

        //---------------------------------------------------------------------------------

        entity = new EntityA();
        entity.setName("1");
        entity.setAge(2);
        entity.setHeight(3);

        list = new ArrayList<>();
        aSetMap = new HashSet<>();
        abListMap = new ArrayList<>();
        map = new HashMap<>();

        list.add(new EntityB( new String[][] {{"4","5"},{"6","7"}}, new double[] {8,9} ));
        list.add(new EntityB( new String[][] {{"10","11"},{"12","13"}}, new double[] {14,15} ));

        aEntitySetMap = new EntityA();
        aEntitySetMap.setName("16");
        aEntitySetMap.setAge(17);
        aEntitySetMap.setHeight(18);
        aSetMap.add(aEntitySetMap);

        aEntitySetMap = new EntityA();
        aEntitySetMap.setName("19");
        aEntitySetMap.setAge(20);
        aEntitySetMap.setHeight(21);
        aSetMap.add(aEntitySetMap);

        arrayBListMap = new EntityB[] {
                new EntityB( new String[][] {{"22","23"},{"24","25"}}, new double[] {26,27} ),
                new EntityB( new String[][] {{"28","29"},{"30","31"}}, new double[] {32,33} )
        };
        abListMap.add(arrayBListMap);
        arrayBListMap = new EntityB[] {
                new EntityB( new String[][] {{"34","35"},{"36","37"}}, new double[] {38,39} ),
                new EntityB( new String[][] {{"40","41"},{"42","43"}}, new double[] {44,45} )
        };
        abListMap.add(arrayBListMap);
        map.put(aSetMap,abListMap);

        aSetMap = new HashSet<>();

        aEntitySetMap = new EntityA();
        aEntitySetMap.setName("46");
        aEntitySetMap.setAge(47);
        aEntitySetMap.setHeight(48);
        aSetMap.add(aEntitySetMap);

        aEntitySetMap = new EntityA();
        aEntitySetMap.setName("49");
        aEntitySetMap.setAge(50);
        aEntitySetMap.setHeight(51);
        aSetMap.add(aEntitySetMap);

        abListMap = new ArrayList<>();
        arrayBListMap = new EntityB[] {
                new EntityB( new String[][] {{"52","53"},{"54","55"}}, new double[] {56,57} ),
                new EntityB( new String[][] {{"58","59"},{"60","61"}}, new double[] {62,63} )
        };
        abListMap.add(arrayBListMap);
        arrayBListMap = new EntityB[] {
                new EntityB( new String[][] {{"64","65"},{"66","67"}}, new double[] {68,69} ),
                new EntityB( new String[][] {{"70","71"},{"72","73"}}, new double[] {74,75} )
        };
        abListMap.add(arrayBListMap);
        map.put(aSetMap,abListMap);

        hashSet.add(new EntityC(entity,list,map));

        System.out.println(Arrays.toString(hashSet.toArray()));
    }
}
