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
        String path = Configuration.tempContent;
        for(int i=0;i<150;i++){
            File file = new File(path+i+".txt");
            file.delete();
        }
    }
}
