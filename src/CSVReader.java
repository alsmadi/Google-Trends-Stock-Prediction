/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package JavaProject34;
/**
 *
 * @author ialsmadi
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class CSVReader {

    static String inputFolder = "C:\\Users\\ialsmadi\\Desktop\\Stock_Prediction_2018\\lm_res2";//input path where you read the file 
static File folder = new File(inputFolder); 
  //0 is the level where we start reading

    public static void main(String[] args) {

        List<String> listOfFiles=listDirectory(folder, 0);
        int counter=0;
        PrintWriter out1 = null;
   String outCSF="out";
   try{out1=new PrintWriter(outCSF+"Main2.csv");}
   catch(Exception ex){
       String test=ex.getMessage();
   }
   out1.println("Ticker"+","+ 	"Estimate"+","	+"Std..Error"+","+	"t.value"+","+"	Pr...t	");
        for(int k=0; k<listOfFiles.size();k++){
            counter=0;
        String csvFile = listOfFiles.get(k);
        int k2=csvFile.lastIndexOf("\\");
        int k1=csvFile.indexOf(".csv")-6;
        String t1=csvFile.substring(k1,k1+10);
        String name=t1.substring(0, t1.indexOf("."));
        String name1=csvFile.substring(k2+1, csvFile.indexOf("."));
        String line = "";
        String cvsSplitBy = ",";
   PrintWriter out = null;
   String outCSF1="out";
   try{out=new PrintWriter(outCSF1+name1+".csv");}
   catch(Exception ex){
       String test=ex.getMessage();
   }
   BufferedReader br=null;
        try {
            try{
            br = new BufferedReader(new FileReader(csvFile)) ;}
            catch(Exception ex){
                String test=ex.getMessage();
            }

            while ((line = br.readLine()) != null) {
                String tmp1=name+line;
                if(counter<1){
                        out.println(tmp1);
                        // out1.println(tmp1);
                    counter++;
                    continue;
                }
                

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                Integer v1=null;
                try{
                   v1= Integer.parseInt(country[5]);
                }
                catch(Exception ex){
                    
                }
                if(v1 !=null && v1>0){
                    String tmp2=name+","+line;
                    try  {
                             out.println(tmp2);
                              out1.println(tmp2);
                                  }
                                catch(Exception ex){
                                    
                                }
                }

            //    System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

            }

        } catch (Exception e) {
            String text=e.getMessage();
            e.printStackTrace();
        }
out.close();
    }
        out1.close();
    }
    //This method for Reading the file in directory manner(folder under folder all the csv)
private static List<String> listDirectory(File file, int level) {

    List<String> lstFiles = new ArrayList<String>();

    File[] firstLevelFiles = file.listFiles();
    if (firstLevelFiles != null && firstLevelFiles.length > 0) {
     for (File aFile : firstLevelFiles) {
      if (aFile.isDirectory() && !"ProcressedEMLs".equalsIgnoreCase(aFile.getName())
        && !"FailedEMLs".equalsIgnoreCase(aFile.getName())) {
       lstFiles.addAll(listDirectory(aFile, level + 1));
      } else if (!aFile.isDirectory()) {
       if (aFile.toString().toLowerCase().endsWith(".csv")) {
        lstFiles.add(aFile.getAbsolutePath());
       }
      }
     }
    
    firstLevelFiles = null;
    return lstFiles;
}
return lstFiles;
}
}
