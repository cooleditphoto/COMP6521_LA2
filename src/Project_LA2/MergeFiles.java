package Project_LA2;

import java.io.*;
import java.util.*;

public class MergeFiles {

    public static void main(String[] args) throws IOException {
        long time1 = new Date().getTime();
        Runtime rt = Runtime.getRuntime();
        long totalMemory = rt.totalMemory();
        start(totalMemory);
        long time2 = new Date().getTime();
        System.out.println(time2-time1);
    }

    /**
     * phase2 start method
     * @param totalMemory
     * @throws IOException
     */
    public static void start(long totalMemory) throws IOException{
        MergeFiles mergeFiles = new MergeFiles();
        Phase2Operation po = new Phase2Operation();

        //init file
        po.fileInit();

        //sublist number
        int subListsNum = 150;
        //sublist size
        int subListsSize = 100000;
        // one block size
        int memorySubListsSize = (int) (totalMemory/Configuration.tupleSize / 750);

        //init file address
        String[] fileAddress = po.fileAddress(subListsNum);
        //init pointer
        BufferedReader[] brInit = po.bufferInit(subListsNum,fileAddress);

        mergeFiles.duplictInsert(subListsNum,memorySubListsSize,brInit);

    }


    /**
     * Remove duplicated data and insert new data
     * @param subListsNum
     * @param memorySubListsSize
     * @param brPointer
     * @throws IOException
     */
    public void duplictInsert( int subListsNum, int memorySubListsSize, BufferedReader[] brPointer) throws IOException{
        Phase2Operation po = new Phase2Operation();
        //init n blocks in memory
        List <List<String>> memorySubListsList = po.init(subListsNum);
        //buffer list in memory
        List <String> bufferList = new ArrayList<>();
        List <String> firstLine = new ArrayList<>();

        while (true){
            //add data to memory
            for (int index=0;index<subListsNum;index++){
                if (memorySubListsList.get(index).size() == 0){
                    Map<List<String>,BufferedReader[]> map = po.fetchSublist(index,brPointer,memorySubListsSize);
                    Map.Entry<List<String>,BufferedReader[]> result = map.entrySet().iterator().next();
                    memorySubListsList.set(index,result.getKey());
                    brPointer = result.getValue();
                }
            }

            // create the first line to compare
            firstLine = new ArrayList<>();
            for (int i=0;i<subListsNum;i++){
                firstLine.add(memorySubListsList.get(i).get(0));
            }

            //get the index of biggest value
            int maxIndex;
            maxIndex = po.maxIndex(firstLine);
            if (maxIndex == -1){
                break;
            }

            //get the line of biggest value
            String maxLine;
            maxLine = memorySubListsList.get(maxIndex).get(0);

            //process bufferList
            bufferList = po.bufferProcess(bufferList,maxLine,memorySubListsSize);

            //remove the biggest line in block of memory
            memorySubListsList.get(maxIndex).remove(0);
        }
        //process the last sublist
        if (bufferList != null){
            po.outputFile(bufferList);
        }
    }

}
