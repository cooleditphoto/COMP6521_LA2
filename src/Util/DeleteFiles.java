package Util;

import java.io.File;

public class DeleteFiles {

    public static void main(String[] args) {
        String path = "/Users/wujiaqi/IdeaProjects/COMP6521_LA2/bitmap";
        for(int i=0;i<100;i++){
            File file = new File(path+i+".txt");
            file.delete();
        }
    }
}
