package io.file.random_access;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RecordStorage implements AutoCloseable {
    private static final int INT_SIZE_IN_BYTES = 4;
    private final RandomAccessFile file;

    public RecordStorage(String fileName) throws FileNotFoundException {
        this.file = new RandomAccessFile(fileName, "rw");
    }

    public void write(Record record, int index) throws IOException {
        // seek to record position in file
        //file.seek(index * (INT_SIZE_IN_BYTES + Record.MAX_DATA_LENGTH));
        seek(index);
        // write fields
        file.writeInt(record.getId());
        file.writeInt(record.getData().length);
        file.write(record.getData());
    }

    public Record read(int index) throws IOException {
        // seek to record position in file
        //file.seek(index * (INT_SIZE_IN_BYTES + Record.MAX_DATA_LENGTH));
        seek(index);
        // read fields
        int id = file.readInt();
        int length = file.readInt();
        byte[] data = new byte[length];
        file.readFully(data);
        // return
        return new Record(id, data);
    }

    private void seek(int index) throws IOException {
        int fileIndex = 0;
        int dataLength ;

        while (index != 0){
            file.seek(fileIndex + INT_SIZE_IN_BYTES);
            dataLength = file.readInt();
            fileIndex += dataLength+ INT_SIZE_IN_BYTES*2;
            index --;
        }
        file.seek(fileIndex);
    }

    public void flush() throws IOException {
        file.getChannel().force(true);
        file.getFD().sync();
    }

    @Override
    public void close() throws IOException {
        file.close();
    }
}
