package io.stream.delete_zero;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
* Created with IntelliJ IDEA.
* User: worker
* Date: 09.10.13
* Time: 22:22
* To change this template use File | Settings | File Templates.
*/
public class NUMBERS extends State {
    private ByteArrayOutputStream buff = new ByteArrayOutputStream();

    NUMBERS(OutputStream out) {
        super(out);
    }

    public State next(byte value) throws IOException {
        if (value == 0) {
            out.write(buff.toByteArray());
            return new ZERO(out);
        } else {
            buff.write(value);
            return this;
        }
    }

    public void finish() throws IOException {
        out.write(buff.toByteArray());
    }
}
