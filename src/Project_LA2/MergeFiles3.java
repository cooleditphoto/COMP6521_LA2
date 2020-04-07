package Project_LA2;

import javafx.util.Pair;

import java.io.*;
import java.util.*;

public class MergeFiles3 {

    /**
     * main method
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        long time1 = new Date().getTime();
        Runtime rt = Runtime.getRuntime();
        long totalMemory = rt.totalMemory();
        start(totalMemory);
        long time2 = new Date().getTime();
        System.out.println("merge phase time: "+(time2-time1));
    }

    /**
     * phase2 start method
     * @param totalMemory
     * @throws IOException
     */
    public static void start(long totalMemory) throws IOException{
        MergeFiles3 mergeFiles = new MergeFiles3();
        MergeOperation mergeOperation = new MergeOperation();

        //init file
        mergeOperation.fileInit();

        //sublist number
        int subListsNum = 150;
        // one block size
        int memorySubListsSize = (int) (totalMemory/Configuration.tupleSize / 750);

        //init file address
        String[] fileAddress = mergeOperation.fileAddress(subListsNum);
        //init pointer
        BufferedReader[] brInit = mergeOperation.bufferInit(fileAddress);

        mergeFiles.duplicateInsert(subListsNum,memorySubListsSize,brInit);

    }


    /**
     * Remove duplicated data and insert new data
     * @param subListsNum
     * @param memorySubListsSize
     * @param brPointer
     * @throws IOException
     */
    public void duplicateInsert( int subListsNum, int memorySubListsSize, BufferedReader[] brPointer) throws IOException{
        MergeOperation mergeOperation = new MergeOperation();
        //init n blocks in memory
        List <List<String>> memorySubListsList = mergeOperation.init(subListsNum);
        //buffer list in memory
        List <String> bufferList = new ArrayList<>();

        while (true){
            //add data to memory
            for (int index=0;index<subListsNum;index++){
                if (memorySubListsList.get(index).size() == 0){
                    BufferedReader br = brPointer[index];
                    Pair<BufferedReader,List<String>> pair  =  mergeOperation.fetchSublist(br,memorySubListsSize);
                    BufferedReader br2 =pair.getKey();
                    brPointer[index] = br2;
                    memorySubListsList.set(index,pair.getValue());
                }
            }

            // create the first line to compare
            List <String> firstLine = new ArrayList<>();
            for (int i=0;i<subListsNum;i++){
                firstLine.add(memorySubListsList.get(i).get(0));
            }

            //get the index of biggest value
            int maxIndex;
            maxIndex = mergeOperation.maxIndex(firstLine);
            if (maxIndex == -1){
                break;
            }

            //get the line of biggest value
            String maxLine;
            maxLine = memorySubListsList.get(maxIndex).get(0);

            //process bufferList
            bufferList = mergeOperation.bufferProcess(bufferList,maxLine,memorySubListsSize);

            //remove the biggest line in block of memory
            memorySubListsList.get(maxIndex).remove(0);
        }
        //process the last sublist
        if (bufferList != null){
            mergeOperation.outputFile(bufferList);
        }
    }

}
