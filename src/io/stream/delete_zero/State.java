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
public abstract class State {
    protected final OutputStream out;

    public State(OutputStream out) {
        this.out = out;
    }

    public abstract State next(byte value) throws IOException;

    public void finish() throws IOException {
    }
}
