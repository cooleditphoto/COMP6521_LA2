package Test;

import Project_LA2.CompressBitmap;
import Project_LA2.Configuration;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class CompressBitmapTest {

    /**
     * compress bitmap file test
     * @throws IOException
     */
    @Test
    public void testCompressBitmap() throws IOException {
        //compress sex bitmap
        for (int i = 1; i < 3; i++) {
            String inputPathSex = Configuration.sexOutput + i + ".txt";
            String outputPathSex = Configuration.compressedOutput + "/compressedSex.txt";
            long startTimeSex = new Date().getTime();
            CompressBitmap.compressBitmap(inputPathSex, outputPathSex);
            long endTimeSex = new Date().getTime();

            File originalFile1 = new File(inputPathSex);
            File file1 = new File(outputPathSex);

            System.out.println("the compressed of sex bitmap " + i + " costs " + (endTimeSex - startTimeSex) + " milliseconds, " +
                    "the compressed file size is " + file1.length() + " the original size is " + originalFile1.length());
        }

        //compress empID bitmap
        long empIdBitmapSize = 0;
        long empIdCompressedBitmapSize = 0;
        long startTimeEmp = new Date().getTime();
        int smallfileNum = 4;
        for (int i = 0; i < smallfileNum; i++) {
            String inputPathEmp = Configuration.empIdOutput + i + ".txt";
            String outputPathEmp = Configuration.compressedOutput + "/compressedEmpId" + i + ".txt";
            CompressBitmap.compressBitmap(inputPathEmp, outputPathEmp);

            File file2 = new File(outputPathEmp);
            empIdCompressedBitmapSize = empIdCompressedBitmapSize + file2.length();
            File originalFile2 = new File(inputPathEmp);
            empIdBitmapSize = empIdBitmapSize + originalFile2.length();
        }
        long endTimeEmp = new Date().getTime();

        System.out.println("the compressed of emp bitmap costs " + (endTimeEmp - startTimeEmp) + " milliseconds, " +
                "the compressed file size is " + empIdCompressedBitmapSize + " the original size is " + empIdBitmapSize);

        //compress department bitmap

        for (int i = 1; i < 3; i++) {

            String inputPathDpt = Configuration.dptOutput + i + ".txt";
            String outputPathDpt = Configuration.compressedOutput + "/compressedDptId.txt";
            long startTimeDpt = new Date().getTime();
            CompressBitmap.compressBitmap(inputPathDpt, outputPathDpt);
            long endTimeDpt = new Date().getTime();

            File file3 = new File(outputPathDpt);
            File originalFile3 = new File(inputPathDpt);

            System.out.println("the compressed of department bitmap " + i + " costs " + (endTimeDpt - startTimeDpt) + " milliseconds, " +
                    "the compressed file size is " + file3.length() + " the original size is " + originalFile3.length());
        }
    }
}
