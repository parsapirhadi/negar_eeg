package com.example.myapplication.V;

import android.graphics.Color;
import android.util.Log;

import com.example.myapplication.M.DataType.Counter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class DrawGraphView {
float count=0;
int channel_count;

    public DrawGraphView(int channel_count) {
        this.channel_count = channel_count;
    }

    void draw(int i, Counter counter, GraphView graphView,int r,int g,int b){


        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
        for (int j=0;j<8000;j+=7) {
            series.appendData(new DataPoint(j,  counter.getAll(j)+count), false, 9000);
            counter.getChannel(i, j);


        }
        series.setColor(Color.rgb(r,g,b));


        graphView.getViewport().setMaxX(4000);
        graphView.getViewport().setMinX(0);

        graphView.getViewport().setMaxY(channel_count*100-100);
        Log.e("[[[[",""+channel_count*100);

        graphView.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graphView.getGridLabelRenderer().setGridStyle( GridLabelRenderer.GridStyle.VERTICAL);
        graphView.getViewport().setDrawBorder(true);


        graphView.getViewport().setMinY(-100);
        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setYAxisBoundsManual(true);
        graphView.getViewport().setScrollable(true);
        graphView.getViewport().setScalableY(true);

        //graphView.setTitle("My Graph View");
        //// graphView.setTitleTextSize(9);

        graphView.addSeries(series);
        count+=100;
    }

}
