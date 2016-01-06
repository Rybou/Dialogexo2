package com.example.bourymbodj.dialogexo2;

/**
 * Created by bourymbodj on 16-01-06.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by bourymbodj on 16-01-03.
 */
public class MyTask extends AsyncTask< Void,Integer, String> {

    Context context;
    TextView textView;
    Button button;

    ProgressDialog bar1;

    MyTask( Context context,TextView textView,Button button  ){
        this.context= context;
        this.textView= textView;
        this.button= button;

    }

    @Override
    protected String doInBackground(Void... params) {
        int i = 0 ;
        synchronized(this)
        {
            while(i<10)
            {
                try {
                    wait(1500);
                    i++;
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }

        return "Download complete ....";
    }

    protected void onPreExecute() {
        bar1= new ProgressDialog(context);
        bar1.setTitle("Download in progress ...");
        bar1.setMax(10);
        bar1.setProgress(0);
        bar1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        bar1.show();


    }

    protected void onPostExecute(String result) {
        textView.setText(result);
        button.setEnabled(true);
        bar1.hide();
    }

    protected void onProgressUpdate(Integer... values){
        int progress = values[0];
        bar1.setProgress(progress);
        textView.setText("Download in Progress...");
    }

}

