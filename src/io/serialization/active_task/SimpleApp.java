package io.serialization.active_task;

import java.io.*;
import java.util.Arrays;
import java.util.Base64;

/**
 * Created by Alexander on 25.05.2015.
 */
public class SimpleApp {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutput output = new ObjectOutputStream(baos);
        output.writeObject(new Entity(1, 2, 3));
        output.writeObject(new Entity(4, 5, 6));
        output.writeObject(new Entity(7, 8, 9));
        output.writeObject(new Entity(10, 11, 12));
        output.flush();
        output.close();
        byte[] array = baos.toByteArray();
        System.out.println("array = " + Arrays.toString(array));
        System.out.println("size = " + array.length);
        System.out.println("string = \"" + new String(array, "utf-8") + "\"");
        Base64.Encoder enc = Base64.getEncoder();
        String base64 = enc.encodeToString(array);
        System.out.println("base64 = " + base64);
        Base64.Decoder dec = Base64.getDecoder();
        System.out.println("decArray = " + Arrays.toString(dec.decode(base64)));
    }

    static class Entity implements Serializable {
        int a;
        int b;
        int c;

        public Entity(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
//        private void writeObject(java.io.ObjectOutputStream out)
//             throws IOException{
//            out.writeByte(a);
//            out.writeByte(b);
//            out.writeByte(c);
//        }
    }
}
