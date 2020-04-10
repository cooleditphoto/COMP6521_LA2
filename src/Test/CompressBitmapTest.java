package Test;

import Project_LA2.CompressBitmap;
import Project_LA2.Configuration;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class CompressBitmapTest {

    @Test
    public void testCompressBitmap() throws IOException {
        //compress sex bitmap
        String inputPathSex = Configuration.sexOutput;
        String outputPathSex = Configuration.compressedOutput+"/compressedSex.txt";
        long startTimeSex = new Date().getTime();
        CompressBitmap.compressBitmap(inputPathSex, outputPathSex);
        long endTimeSex = new Date().getTime();

        File file1 = new File(outputPathSex);
        double bytes1 = file1.length();

        System.out.println("the compressed of sex bitmap costs " + (endTimeSex - startTimeSex) + " milliseconds, " +
                "the compressed file size is " + bytes1);

        //compress empID bitmap
        String inputPathEmp = Configuration.idOutput;
        String outputPathEmp = Configuration.compressedOutput+"/compressedEmpId.txt";
        long startTimeEmp = new Date().getTime();
        CompressBitmap.compressBitmap(inputPathEmp, outputPathEmp);
        long endTimeEmp = new Date().getTime();

        File file2 = new File(outputPathEmp);
        double bytes2 = file2.length();
        System.out.println("the compressed of emp bitmap costs " + (endTimeEmp - startTimeEmp) + " milliseconds, " +
                "the compressed file size is " + bytes2);

        //compress department bitmap
        String inputPathDpt = Configuration.dptOutput;
        String outputPathDpt = Configuration.compressedOutput+"/compressedDptId.txt";
        long startTimeDpt = new Date().getTime();
        CompressBitmap.compressBitmap(inputPathDpt, outputPathDpt);
        long endTimeDpt = new Date().getTime();

        File file3 = new File(outputPathDpt);
        double bytes3 = file3.length();
        System.out.println("the compressed of department bitmap costs " + (endTimeDpt - startTimeDpt) + " milliseconds, " +
                "the compressed file size is " + bytes3);
    }
}
