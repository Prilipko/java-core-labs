package io.stream.delete_zero;


import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 29.09.13
 * Time: 15:10
 * To change this template use File | Settings | File Templates.
 */
public class DeleteZeroLab {
    final static String oldFile = "d:/tmp/1.jpg";
    final static String newFile = "d:/tmp/1_.jpg";

    public static void main(String[] args) throws IOException {
        try (
                InputStream in = new FileInputStream(oldFile);
                OutputStream out = new FileOutputStream(newFile, false)
        ) {
//            InputStream in = new ByteArrayInputStream(new byte[]{0,1,2,3,1,2,3,0,1,0,2,3,1,2,0,3});
//            OutputStream out = new ByteArrayOutputStream();
            filter(in, out, 4);
//            System.out.println(Arrays.toString(((ByteArrayOutputStream)out).toByteArray()));
            out.flush();
        } catch (IOException e) {
            IOException copyEx = new IOException("Copy Exception");
            boolean deleted;
            try {
                deleted = (new File(newFile)).delete();
            } catch (SecurityException ex) {
                deleted = false;
            }
            if (!deleted) {
                copyEx.addSuppressed(new IOException("Cant delete file " + newFile));
            }
            throw copyEx;
        }
    }


    public static void filter(InputStream in, OutputStream out, int buffSize) throws IOException {
        if (buffSize <= 0) throw new IllegalArgumentException("Parameter buffSize must be > 0");
        byte[] buff = new byte[buffSize];
        int count;
        while ((count = in.read(buff)) != -1) {
            State state = new ZERO(out);
            for (int index = 0; index < count; index++) {
                state = state.next(buff[index]);
            }
            state.finish();
        }
    }

}
