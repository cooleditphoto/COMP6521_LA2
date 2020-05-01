package Util;

import Project_LA2.Configuration;

import java.io.File;

public class DeleteFiles {

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
       //start();
    }

    /**
     * start method
     */
    public void start(){
        String path1 = Configuration.phase2Path1;
        String path2 = Configuration.phase2Path2;
        deleteFiles(path1);
        deleteFiles(path2);
    }

    /**
     * delete all files
     */
    public static void deleteFiles(String path){
        File file = new File(path);
        file.delete();
    }
}
