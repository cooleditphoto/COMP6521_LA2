package Project_LA2;

import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MergeOperation {

    static int io=0;

    /**
     * get file address
     * @param subListsNum
     * @return
     * @throws IOException
     */
    public  String[] fileAddress(int subListsNum){
        String[] fileAddress = new String[subListsNum];
        for (int i=1;i<=subListsNum;i++){
            //fileAddress[i-1] = Configuration.tempContent2 + (i-1) + ".txt";
            fileAddress[i-1] = "src/Data_Files/output" + (i+2) + ".txt";
        }
        return  fileAddress;
    }

    /**
     * init bufferReader
     * @param fileAddress
     * @return
     * @throws IOException
     */
    public BufferedReader[] bufferInit(String[] fileAddress) throws IOException{
        BufferedReader[] brInit = new BufferedReader[fileAddress.length];
        for (int i=0;i<fileAddress.length;i++){
            FileReader fr = new FileReader(fileAddress[i]);
            BufferedReader br = new BufferedReader(fr);
            brInit[i] = br;
        }
        return brInit;
    }

    /**
     * init memorySubListsList
     * @param subListsNum
     * @return
     * @throws IOException
     */
    public List <List<String>> init(int subListsNum){
        List <List<String>> memorySubListsList = new ArrayList<>();
        List<String> initArr = new ArrayList<>();
        for (int i=0; i<subListsNum; i++){
            memorySubListsList.add(initArr);
        }
        return memorySubListsList;
    }

    /**
     * read new sublist from disk to memory and compute the position of br pointer
     * @param br
     * @param fetchNum
     * @return
     * @throws IOException
     */
    public Pair<BufferedReader,List<String>> fetchSublist(BufferedReader br, int fetchNum) throws IOException {

        List<String> fetchSubList = new ArrayList<>();
        String txt = "";
        for (int lines = 0; lines< fetchNum; lines++){
            txt = br.readLine();
            io++;
            if (txt == null){
                br.close();
                fetchSubList.add("99999999");
                break;
            }
            else{
                fetchSubList.add(txt);
            }
        }

        Pair<BufferedReader,List<String>> pair = new Pair<>(br,fetchSubList);
        return  pair;
    }

    /**
     * compute the max sublist index
     * @param firstLine
     * @return
     */
    public int maxIndex (List<String> firstLine){
        int maxIndex = 0;
        int num = Integer.parseInt(firstLine.get(0).substring(0,8));

        for (int i=1; i<firstLine.size();i++){
            Integer numI = Integer.parseInt(firstLine.get(i).substring(0,8));
            if (numI < num) {
                num = numI;
                maxIndex = i;

            }
        }
        if(num == 99999999){
            return -1;
        }
        return maxIndex;
    }

    /**
     * remove duplicate and add new line to buffer list then save it to disk
     * @param bufferList
     * @param maxLine
     * @param memorySubListsSize
     * @return
     * @throws IOException
     */
    public List <String> bufferProcess(List <String> bufferList,String maxLine,int memorySubListsSize) throws IOException{
        MergeOperation mergeOperation = new MergeOperation();
        int bufferSize1 = bufferList.size();
        int bufferSize2;

        if (bufferSize1==0){
            bufferList.add(maxLine);
        }
        else if (bufferSize1 <= memorySubListsSize){
            String currLine = bufferList.get(bufferSize1-1);
            if (maxLine.substring(0,8).equals(currLine.substring(0,8))){
                if (maxLine.substring(8,18).compareTo(currLine.substring(8,18)) > 0 ){
                    bufferList.set(bufferSize1-1,maxLine);
                }
            }
            else {
                bufferList.add(maxLine);
            }
        }
        bufferSize2 = bufferList.size();
        if (bufferSize2 == memorySubListsSize + 1){
            String lastLine = bufferList.get(bufferSize2-1);
            bufferList.remove(bufferSize2-1);
            mergeOperation.outputFile(bufferList);

            bufferList = new ArrayList<String>();
            bufferList.add(lastLine);
        }
        return bufferList;
    }

    /**
     * save sublist to disk
     * @param subList
     * @throws IOException
     */
    public void outputFile(List<String> subList) throws IOException {
        //FileWriter fw  = new FileWriter(Configuration.idOutput,true);
        FileWriter fw  = new FileWriter(Configuration.demoOutput,true);
        PrintWriter pw = new PrintWriter(fw);
        //output every element in the sublist
        for(String str:subList){
            pw.println(str);
        }
        pw.close();
        fw.close();
    }

    /**
     * init output file
     * @throws IOException
     */
    public void fileInit() throws IOException {
        //FileWriter fw  = new FileWriter(Configuration.idOutput);
        FileWriter fw  = new FileWriter(Configuration.demoOutput);
        PrintWriter pw = new PrintWriter(fw);
        pw.close();
        fw.close();
    }

}
