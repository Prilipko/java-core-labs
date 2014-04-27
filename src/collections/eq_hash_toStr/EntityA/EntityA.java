package collections.eq_hash_toStr.EntityA;


/**
 * Created by Worker on 25.04.14.
 */



public class EntityA {
    private int age;
    private int height;
    private String name;

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
        return (age*31+height)*31 + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }
}