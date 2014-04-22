package io.file.copy_dir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileLab_CopyDir {
    public static void main(String[] args) throws IOException {
        copy(new File("e:/tmp"), new File("e:/tmp2"));
    }

    private static void copy(File src, File dst) throws IOException {
        if (src.isDirectory()) {
            if (!dst.exists()) {
                dst.mkdir();
            }
            for (File srcSubDir : src.listFiles()) {
                String subDirName = srcSubDir.getName();
                copy(srcSubDir, new File(dst, subDirName));
            }
        } else {
            if (!dst.exists()) {
                Files.copy(src.toPath(), dst.toPath());
            }
        }
    }
}