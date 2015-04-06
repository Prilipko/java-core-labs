package oop.tostring.plain_phone;

import java.text.DecimalFormat;
import java.text.MessageFormat;

public class Phone {
    private final static DecimalFormat phoneDecimalFmt = new DecimalFormat("0000000");
    private final static MessageFormat phoneMsgFmt=new MessageFormat("{0}-{1}-{2}");
    private final int code;
    private final int number;

    public Phone(int code, int number) {
        this.code = code;
        this.number = number;
    }

    public int getCode() {
        return code;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        String phoneRawString= phoneDecimalFmt.format(number);
        String[] phoneNumArr={phoneRawString.substring(0, 3),
                phoneRawString.substring(3,5),
                phoneRawString.substring(5)};
        return "Phone[(" + code +") " + phoneMsgFmt.format(phoneNumArr) +']';
    }

    public static void main(String[] args) {
        System.out.println(new Phone(777, 1234567));
    }
}
