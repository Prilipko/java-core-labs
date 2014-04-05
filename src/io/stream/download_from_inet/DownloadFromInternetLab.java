package io.stream.download_from_inet;

/**
 * Created with IntelliJ IDEA.
 * User: Prilipko
 * Date: 16.10.13
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.net.URL;

public class DownloadFromInternetLab {
    private static String fileName0 = "d:/tmp/html/page0.html";
    private static String fileName1 = "d:/tmp/html/page1.html";
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.google.com");
        try (
                InputStream in = url.openStream();
                OutputStream out0 = new FileOutputStream(fileName0, false);
                OutputStream out1 = new FileOutputStream(fileName1, false)
        ) {
            int count;
            byte[] arr = new byte[256];
            while ((count = in.read(arr)) != -1) {
                out0.write(arr,0,count);
                out1.write(arr,0,count);
            }
            out0.flush();
            out1.flush();
        } catch (IOException e) {
            if(! new File(fileName0).delete()){
                e.addSuppressed(new IOException("Cant delete file " + fileName0));
            }
            if(! new File(fileName1).delete()){
                e.addSuppressed(new IOException("Cant delete file " + fileName1));
            }
            throw e;
        }
    }
}