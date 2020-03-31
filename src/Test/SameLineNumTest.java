package Test;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SameLineNumTest {

    @Test
    public void sameLineNumTest() throws IOException {
        String path1 = "";
        String path2 = "";
        FileReader fr1 = new FileReader(path1);
        BufferedReader br1 = new BufferedReader(fr1);
        FileReader fr2 = new FileReader(path2);
        BufferedReader br2 = new BufferedReader(fr2);
        int num1=0;
        int num2 =0;
        while(br1.readLine()!=null){
            num1++;
        }
        while(br2.readLine()!=null){
            num2++;
        }
        System.out.println(num1);
        System.out.println(num2);
        br2.close();
        fr2.close();
        br1.close();
        fr1.close();
        Assert.assertEquals(num1,num2);
    }
}
