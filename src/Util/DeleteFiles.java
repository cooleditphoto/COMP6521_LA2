package Util;

import Project_LA2.Configuration;

import java.io.File;

public class DeleteFiles {

    public static void main(String[] args) {
        String path = Configuration.TEMP_CONTENT;
        for(int i=50;i<100;i++){
            File file = new File(path+i+".txt");
            file.delete();
        }
    }
}
