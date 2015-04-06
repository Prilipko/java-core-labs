package oop.tostring.cyclic_ref_hand_expand;

import java.util.*;

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

        int bufLen = 20 * subordinate.size();
        if (subordinate.size() != 0 && bufLen <= 0)
            bufLen = Integer.MAX_VALUE;
        StringBuilder buf = new StringBuilder(bufLen);
        toString(this, buf, new HashSet<>());
        return buf.toString();
    }

    private void toString(CyclicEmployee a, StringBuilder buf,
                          Set<CyclicEmployee> dejaVu) {
        if (a == null) {
            buf.append("null");
            return;
        }

        dejaVu.add(a);
        buf.append("Employee[");
        buf.append("age=");
        buf.append(a.age);
        buf.append(", name=");
        buf.append(a.name);
        buf.append(", boss=");
        if (dejaVu.contains(a.boss))
            buf.append("[...]");
        else
            toString(a.boss, buf, dejaVu);

        buf.append(", subordinate=[");
        for (int i = 0; i < a.subordinate.size(); i++) {
            CyclicEmployee element = a.subordinate.get(i);
            if (dejaVu.contains(element))
                buf.append("[...]");
            else
                toString(element, buf, dejaVu);
            if (i == a.subordinate.size() - 1) {
                break;
            }
            buf.append(", ");
        }
        buf.append("]]");
        dejaVu.remove(a);

    }

    public static void main(String[] args) {
        CyclicEmployee jimmy = new CyclicEmployee(25, "Jimmy", null, new ArrayList<>());
        CyclicEmployee mike = new CyclicEmployee(30, "Mike", null, Arrays.asList(jimmy));
        CyclicEmployee ann = new CyclicEmployee(45, "Ann", null, Arrays.asList(jimmy, mike));
        jimmy.setBoss(mike);
        mike.setBoss(ann);
        ann.setBoss(ann);
        System.out.println(jimmy);
        System.out.println(mike);
        System.out.println(ann);

//        Employee[age=25, name=Jimmy, boss=Employee[age=30, name=Mike, boss=Employee[age=45, name=Ann, boss=[...], subordinate=[[...], [...]]], subordinate=[[...]]], subordinate=[]]
//        Employee[age=30, name=Mike, boss=Employee[age=45, name=Ann, boss=[...], subordinate=[Employee[age=25, name=Jimmy, boss=[...], subordinate=[]], [...]]], subordinate=[Employee[age=25, name=Jimmy, boss=[...], subordinate=[]]]]
//        Employee[age=45, name=Ann, boss=[...], subordinate=[Employee[age=25, name=Jimmy, boss=Employee[age=30, name=Mike, boss=[...], subordinate=[[...]]], subordinate=[]], Employee[age=30, name=Mike, boss=[...], subordinate=[Employee[age=25, name=Jimmy, boss=[...], subordinate=[]]]]]]
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
