package Project_LA2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class FindRecord {

    /**
     * find the specific line using line number
     * @param filePath
     * @param lineNum
     * @return
     * @throws IOException
     */
    public static String findRecordFromFile(String filePath, int lineNum) throws IOException {
        //access the file randomly
        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        long position = (lineNum-1) * 101;
        file.seek(position);
        byte[] bytes = new byte[101];
        file.read(bytes);
        file.close();

        //fixed length
        String string = new String(bytes).trim();
        StringBuffer sb  =new StringBuffer();

        for(int i=0;i<100-string.length();i++){
            sb.append(" ");
        }
        return string+sb.toString();
    }

}
