package io.stream.delete_zero;

import java.io.IOException;
import java.io.OutputStream;

/**
* Created with IntelliJ IDEA.
* User: worker
* Date: 09.10.13
* Time: 22:21
* To change this template use File | Settings | File Templates.
*/
public class ZERO extends State {
    public ZERO(OutputStream out) {
        super(out);
    }

    public State next(byte value) throws IOException {
        if (value == 0) {
            return this;
        } else {
            State newState = new NUMBERS(out);
            return newState.next(value);
        }
    }

    public void finish() throws IOException {
        //nop
    }
}
