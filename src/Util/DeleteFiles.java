package Util;

import Project_LA2.Configuration;

import java.io.File;

public class DeleteFiles {

    public static void main(String[] args) {
        deleteFiles();
    }

    /**
     * delete all files
     */
    public static void deleteFiles(){
        String path1 = "/Users/wujiaqi/comp6521/smallfile/output3.txt";
        File file = new File(path1);
        file.delete();
        String path2 = "/Users/wujiaqi/comp6521/smallfile/output4.txt";
        File file2 = new File(path2);
        file2.delete();

    }
}
