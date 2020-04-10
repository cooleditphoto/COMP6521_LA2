package Test;

import Project_LA2.Configuration;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CompareFileTest {

    @Test
    public void test01() throws IOException {

        String path1 = Configuration.idOutput;
        String path2 = "/Users/wujiaqi/Desktop/phase2_output(2w).txt";
        boolean flag = false;
        FileReader fr1 = new FileReader(path1);
        BufferedReader br1 = new BufferedReader(fr1);
        FileReader fr2 = new FileReader(path2);
        BufferedReader br2 = new BufferedReader(fr2);
        String str1;
        String str2;
        int num = 0;
        while(num<39180){
            str1 = br1.readLine();
            str2 = br2.readLine();
            if((!str1.substring(0,18).equals(str2.substring(0,18)))||(str1.length())!=str2.length()){
                flag = true;
            }
            num++;
        }
        System.out.println(num);
        br2.close();
        fr2.close();
        br1.close();
        fr1.close();

        Assert.assertEquals(flag,false);
    }
}
