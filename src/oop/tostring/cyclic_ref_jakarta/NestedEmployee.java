package oop.tostring.cyclic_ref_jakarta;

import oop.tostring.plain_address.Address;
import oop.tostring.plain_phone.Phone;
//import org.apache.commons.lang3.builder;

public class NestedEmployee {
    private int age;
    private String name;
    private Address address;
    private Phone phone;

    public NestedEmployee(int age, String name, Address address, Phone phone) {
        this.age = age;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public static void main(String[] args) {
        NestedEmployee emp = new NestedEmployee(32, "Ivanov", new Address("Ukraine", "Kharkov", "Ivanova st.", 12), new Phone(777, 7654321));
        System.out.println(emp);
    }

    @Override
    public String toString() {
        return "";//new ToStringBuilder(this)

//        return "NestedEmployee[" +
//                "age=" + age +
//                ", name='" + name + '\'' +
//                ", address=" + address +
//                ", phone=" + phone +
//                ']';
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}