package io.file.random_access;

/**
 * Created by Alexander on 22.04.14.
 */
public class Record {
    public static int MAX_DATA_LENGTH = 64;
    private final int id;
    private final byte[] data;

    public Record(int id, byte[] data) {
        if (data == null) {
            throw new IllegalArgumentException("'data' must be not null");
        }
        if (data.length > MAX_DATA_LENGTH) {
            throw new IllegalArgumentException("'data.length' must be less or equals than " + MAX_DATA_LENGTH);
        }
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public byte[] getData() {
        return data;
    }
}
