package collections.eq_hash_toStr.EntityA;


/**
 * Created by Worker on 25.04.14.
 */


public class EntityA {
    private int age;
    private int height;
    private String name;
    private static int hash=0;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
//        return 0;
        return (age * 31 + height) * 31 + name.hashCode();
//        return hash++;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
//        return false;
        EntityA that = (EntityA) obj;
        return age == that.age && height == that.height
                && (name == that.name
                || (name != null && name.equals(that.getName())));
    }

    @Override
    public String toString() {
        return "[name: " + name + " age: " + age + " height: " + height + "]";
    }
}