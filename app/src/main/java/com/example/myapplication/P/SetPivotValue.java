package com.example.myapplication.P;

import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.M.DataType.Counter;
import com.example.myapplication.M.DataType.String1;

public class SetPivotValue {
    String fileContent;
    String1 string1;
    float string;
    float l=0;
   Counter counter;
   int count=0;


    public SetPivotValue(String fileContent,String1 string1, Counter counter) {
        this.fileContent = fileContent;
        this.string1 = string1;
        this.counter = counter;
    }
    public void setvalueofeachchannel(){
        int b=0;
        int c=0;
        for(int i=0;i<65000;i++){
            if (b==counter.getChannel_count()){
                b=0;
                c++;
            }

            counter.setChannel(counter.getAll(i),b,c);
            b++;
        }

    }
public void y(){
        Log.e("/////////",""+counter.getChannel(7,1000));
}
    public void set(){
        one_item();
        findcountvalue();

    }
    public void setvalue(int i, int j) {///////////////////gh

        StringBuilder sum = new StringBuilder();
        String h;
        float ft = 0;
        for (int b = i; b <= j; b++) {
            sum.append(fileContent.charAt(b));
        }
        ft = Float.parseFloat(sum.toString());
        string=ft;
       // counter.setChannel(ft,counter.getB(),counter.getB1());
        counter.setAll(ft,counter.getAll_count());
        counter.setAll_count(counter.getAll_count()+1);
    }

    public void findcountvalue(){///////////////////////////////////sd
        for(int b=7;b<fileContent.length();b++){
            if(fileContent.charAt(b)==' '){
                for(int y=b-1;y>b-8;y--){
                    if(fileContent.charAt(y)==' '){

                        setvalue(y+1,b-1);
                        y=-1;

                        break;


                    }
                }
            }

        }
    }
    private void one_item() {
        String h="";
        float d=0;
        int s=0;
        for(s=0;s<7;s++){
            if(fileContent.charAt(s)!=' '){
                h+=fileContent.charAt(s);
            }
            else {break;}
        }
        setvalue(0,s);
        //Log.e("eeeeeeeeeeee1",""+d);
    }
}
