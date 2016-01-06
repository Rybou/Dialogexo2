package com.example.bourymbodj.dialogexo2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    final Context context = this;
    private Button button;
    private EditText text;
    private TextView textview;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonAlert);
        text= ( EditText) findViewById((R.id.text));
        textview= ( TextView) findViewById((R.id.textview));

        // add button listener
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.activity_prompt, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);

                // set title
                //alertDialogBuilder.setTitle("Enter a number");

                // set dialog message
                alertDialogBuilder
                        //.setMessage("Are you sure you want to exi")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity
                                //MainActivity.this.finish();
                                MyTask myTask= new MyTask(MainActivity.this,text, button );
                                myTask.execute();
                                button.setEnabled(false);
                                text.setText(userInput.getText());
                                textview.setText(userInput.getText());
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
       // textview.setText;
    }


}

