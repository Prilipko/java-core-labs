package oop.tostring.cyclic_ref_jakarta_reflection;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
        return new ReflectionToStringBuilder(this,new ShortPrefixToStringStyle()).toString();

//        int bufLen = 20 * subordinate.size();
//        if (subordinate.size() != 0 && bufLen <= 0)
//            bufLen = Integer.MAX_VALUE;
//        StringBuilder buf = new StringBuilder(bufLen);
//        toString(this, buf, new HashSet<>());
//        return buf.toString();
    }

    private static final class ShortPrefixToStringStyle extends ToStringStyle {
        /**
         * <p>Constructor.</p>
         *
         * <p>Use the static constant rather than instantiating.</p>
         */
        public ShortPrefixToStringStyle() {
            super();
            this.setUseShortClassName(true);
            this.setUseIdentityHashCode(false);
        }

        @Override
        protected void appendCyclicObject(StringBuffer buffer, String fieldName, Object value) {
            buffer.append("[...]");
        }

        @Override
        protected void appendClassName(StringBuffer buffer, Object object) {
            buffer.append("Employee");
        }

        @Override
        protected void appendInternal(StringBuffer buffer, String fieldName, Object value, boolean detail) {
            System.out.println("<" + value.hashCode());
            super.appendInternal(buffer, fieldName, value, detail);
            System.out.println(value.hashCode() + ">");
        }

        /**
         * <p>Ensure <code>Singleton</ode> after serialization.</p>
         * @return the singleton
         */
        private Object readResolve() {
            return ToStringStyle.SHORT_PREFIX_STYLE;
        }

    }

    public static void main(String[] args) {
//        CyclicEmployee jimmy = new CyclicEmployee(25, "Jimmy", null, new ArrayList<>());
//        CyclicEmployee mike = new CyclicEmployee(30, "Mike", null, Arrays.asList(jimmy));
//        CyclicEmployee ann = new CyclicEmployee(45, "Ann", null, Arrays.asList(jimmy, mike));
//        jimmy.setBoss(mike);
//        mike.setBoss(ann);
//        ann.setBoss(ann);
//        System.out.println(jimmy);
//        System.out.println(mike);
//        System.out.println(ann);



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
