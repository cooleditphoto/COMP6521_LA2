package Util;

import Project_LA2.Configuration;

import java.io.File;

public class DeleteFiles {

    public static void main(String[] args) {
        String path = Configuration.TEMP_CONTENT;
        for(int i=0;i<150;i++){
            File file = new File(path+i+".txt");
            file.delete();
        }
    }

    /**
     * delete all files
     */
    public void deleteFiles(){
        String path = Configuration.TEMP_CONTENT;
        for(int i=100;i<150;i++){
            File file = new File(path+i+".txt");
            file.delete();
        }
    }
}
