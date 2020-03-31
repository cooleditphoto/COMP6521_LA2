package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CompareFileTest {

    @Test
    public void test01() throws IOException {

        String path1 = "/Users/wujiaqi/comp6521/output/output.txt";
        String path2 = "/Users/wujiaqi/Desktop/phase2_output.txt";
        boolean flag = false;
        FileReader fr1 = new FileReader(path1);
        BufferedReader br1 = new BufferedReader(fr1);
        FileReader fr2 = new FileReader(path2);
        BufferedReader br2 = new BufferedReader(fr2);
        String str1;
        String str2;
        int t=0;
        int num = 0;
        while(num<824450){
            str1 = br1.readLine();
            str2 = br2.readLine();
            if(!str1.equals(str2)){
                flag = true;
                t++;
            }
            num++;
        }
        System.out.println(t);
        br2.close();
        fr2.close();
        br1.close();
        fr1.close();

        Assert.assertEquals(flag,false);
    }
}
