package Project_LA2;

import java.io.*;

public class CompressBitmap {

    /**
     * compress the bitmap file
     * @param inputPath
     * @param outputPath
     * @throws IOException
     */
    public static void compressBitmap(String inputPath, String outputPath) throws IOException {
        FileReader fileReader = new FileReader(inputPath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(outputPath);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        int c = (char) bufferedReader.read();

        while (c != 65535) {
            char charc = (char) c;
            //32 - " "
            int runLength = 0;
            StringBuilder compressedString = new StringBuilder();
            if (charc != '\n' && charc != (char) 65535) {
                while (charc != '1' && charc != '\n' && charc != (char) 65535) {
                    charc = (char) bufferedReader.read();
                    runLength++;
                }
                if (charc == '1') {
                    if (runLength != 0 && runLength != 1) {
                        int j = (int) Math.ceil(Math.log(runLength) / Math.log(2));
                        System.out.println(j + " " + runLength);
                        for (int i = 0; i < j - 1; i++) {
                            compressedString.append("1");
                        }
                        compressedString.append("0");
                        String binaryString = Integer.toBinaryString(runLength);
                        compressedString.append(binaryString);
                        printWriter.print(compressedString);
                        System.out.println("one runlength " + compressedString);
                        printWriter.flush();
                        c = bufferedReader.read();
                    } else if (runLength == 0) {
                        printWriter.print("00");
                        printWriter.flush();
                        System.out.println("one runlength " + "00");

                        c = bufferedReader.read();
                    } else {
                        printWriter.print("01");
                        printWriter.flush();
                        System.out.println("one runlength " + "01");
                        c = bufferedReader.read();
                    }
                }
            }

            if (charc == '\n') {
                printWriter.println();
                printWriter.flush();
                c = bufferedReader.read();
            }
            if (charc == (char) 65535) {
                break;
            }
        }

        printWriter.close();
        fileWriter.close();
        bufferedReader.close();
        fileReader.close();
    }
}
