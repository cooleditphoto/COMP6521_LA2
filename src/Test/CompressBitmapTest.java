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
        String inputPathSex = Configuration.sexOutput+"1.txt";
        String outputPathSex = Configuration.compressedOutput + "/compressedSex.txt";
        long startTimeSex = new Date().getTime();
        CompressBitmap.compressBitmap(inputPathSex, outputPathSex);
        long endTimeSex = new Date().getTime();

        File originalFile1 = new File(inputPathSex);
        File file1 = new File(outputPathSex);

        System.out.println("the compressed of sex bitmap costs " + (endTimeSex - startTimeSex) + " milliseconds, " +
                "the compressed file size is " + file1.length() + " the original size is " + originalFile1.length());

        //compress empID bitmap
        String inputPathEmp = Configuration.idOutput;
        String outputPathEmp = Configuration.compressedOutput + "/compressedEmpId.txt";
        long startTimeEmp = new Date().getTime();
        CompressBitmap.compressBitmap(inputPathEmp, outputPathEmp);
        long endTimeEmp = new Date().getTime();

        File file2 = new File(outputPathEmp);
        File originalFile2 = new File(inputPathEmp);

        System.out.println("the compressed of emp bitmap costs " + (endTimeEmp - startTimeEmp) + " milliseconds, " +
                "the compressed file size is " + file2.length() + " the original size is " + originalFile2.length());

        //compress department bitmap
        String inputPathDpt = Configuration.dptOutput+"1.txt";
        String outputPathDpt = Configuration.compressedOutput + "/compressedDptId.txt";
        long startTimeDpt = new Date().getTime();
        CompressBitmap.compressBitmap(inputPathDpt, outputPathDpt);
        long endTimeDpt = new Date().getTime();

        File file3 = new File(outputPathDpt);
        File originalFile3 = new File(inputPathDpt);

        System.out.println("the compressed of department bitmap costs " + (endTimeDpt - startTimeDpt) + " milliseconds, " +
                "the compressed file size is " + file3.length() + " the original size is " + originalFile3.length());
    }
}
