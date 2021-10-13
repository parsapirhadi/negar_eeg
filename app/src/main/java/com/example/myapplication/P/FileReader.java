package com.example.myapplication.P;

import android.os.Environment;
import android.util.Log;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;



public class FileReader {
    BufferedReader myReader;
    String1 string1;
    Counter counter;
    SetPivotName namePivote;
    SetPivotValue pivotValue;
    String patch;

    public FileReader(String1 string1, Counter counter, SetPivotName namePivote, SetPivotValue pivotValue) {
        this.string1 = string1;
        this.counter = counter;
        this.namePivote = namePivote;
        this.pivotValue = pivotValue;
    }

    public void read(){
        final String fileName = "g8.txt";
        File extStore = Environment.getExternalStorageDirectory();
        String path = extStore.getAbsolutePath().toString() + "/Download/" + fileName;
        Log.e("ExternalStorageDemo", "Read file: " + path);

        String s = "";
        String fileContent = "";
        try {
            File myFile = new File(path);
            FileInputStream fIn = new FileInputStream(myFile);
            myReader = new BufferedReader(
                    new InputStreamReader(fIn));

            if ((s = myReader.readLine()) != null) {
                fileContent = s ;
            }

            char[] charArray = fileContent.toCharArray();
            Log.e("aaaaaaaaaaaaaa",""+fileContent);


            namePivote=new SetPivotName(fileContent,string1,counter);
            namePivote.set();



            while ((s = myReader.readLine()) != null) {
                fileContent = s ;
                pivotValue=new SetPivotValue(fileContent,string1,counter);
                pivotValue.set();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            myReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int o=0;o<98;o++) {

        }


        pivotValue.setvalueofeachchannel();
        pivotValue.y();

        Log.e("{{{{{{{{{{{",""+counter.getAll(5));

    }
}
