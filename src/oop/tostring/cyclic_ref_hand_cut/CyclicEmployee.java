package oop.tostring.cyclic_ref_hand_cut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CyclicEmployee {
    private int age;
    private String name;
    private CyclicEmployee boss;
    private List<CyclicEmployee> subordinate;

    public CyclicEmployee(int age, String name, CyclicEmployee boss, List<CyclicEmployee> subordinate) {
        this.age = age;
        this.name = name;
        this.boss = boss;
        this.subordinate = subordinate;
    }

    @Override
    public String toString() {
        List<ReducedCyclicEmployee> rce = new ArrayList<>(subordinate.size());
        subordinate.forEach(value -> rce.add(new ReducedCyclicEmployee(value)));

        return "CyclicEmployee[" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", boss=" + new ReducedCyclicEmployee(boss) +
                ", subordinate=" + rce.toString() +
                ']';
    }

    public static void main(String[] args) {
        CyclicEmployee jimmy = new CyclicEmployee(25, "Jimmy", null, new ArrayList<>());
        CyclicEmployee mike = new CyclicEmployee(30, "Mike", null, Arrays.asList(jimmy));
        CyclicEmployee ann = new CyclicEmployee(45, "Ann", null, Arrays.asList(jimmy,mike));
        jimmy.setBoss(mike);
        mike.setBoss(ann);
        ann.setBoss(ann);
        System.out.println(jimmy);
        System.out.println(mike);
        System.out.println(ann);
    }

    private static class ReducedCyclicEmployee {
        private final CyclicEmployee emp;

        private ReducedCyclicEmployee(CyclicEmployee emp) {
            this.emp = emp;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "age=" + emp.age +
                    ", name='" + emp.name + '\'' +
                    '}';
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CyclicEmployee getBoss() {
        return boss;
    }

    public void setBoss(CyclicEmployee boss) {
        this.boss = boss;
    }

    public List<CyclicEmployee> getSubordinate() {
        return subordinate;
    }

    public void setSubordinate(List<CyclicEmployee> subordinate) {
        this.subordinate = subordinate;
    }
}
