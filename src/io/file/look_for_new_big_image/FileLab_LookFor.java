package io.file.look_for_new_big_image;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileLab_LookFor {

    static class BigImage implements FileFilter{

        @Override
        public boolean accept(File pathname) {
            return (pathname.length() > 1024 * 1024) &&
                    (pathname.getName().endsWith(".jpg") ||
                            pathname.getName().endsWith(".png") ||
                            pathname.getName().endsWith(".bmp") ||
                            pathname.getName().endsWith(".gif")) ||
                    pathname.isDirectory();
        }
    }

    public static void main(String[] args) {
        File file = new File("e:/tmp");
        print(file, new BigImage());
        File[] bigImages = lookForBigImage(new File("e:/tmp"));
        System.out.println(Arrays.toString(bigImages));
    }

    private static File[] lookForBigImage(File file) {
        List<File> list = doLookForBigImage(file);
        return list.toArray(new File[list.size()]);
    }

    private static List<File> doLookForBigImage(File file) {
        ArrayList<File> list= new ArrayList<>();
        if (file.isFile()) {
            list.add(file);
        } else {
            File[] fileArray = file.listFiles(new BigImage());
            for (File newfile : fileArray) {
                list.addAll(doLookForBigImage(newfile));
            }
        }
        return list;
    }


    public static void print(File root, FileFilter fileFilter) {
        if (root.isFile()) {
            System.out.println(root);
        } else {
            File[] fileArray = root.listFiles(fileFilter);
            for (File file : fileArray) {
                print(file, fileFilter);
            }
        }
    }
}

