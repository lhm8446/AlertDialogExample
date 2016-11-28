package com.estsoft.alertdialogexample;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean[] choices = { false, false, false, false, false, false};
    private int indexSingleChoiceSelected = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialogMessage( View view ) {
        new AlertDialog.Builder(this).setTitle("알림").setIcon(android.R.drawable.ic_dialog_alert).setMessage("Hello World\nHello World\n").show();
    }

    public void dialogColseButton( View view ) {
        new AlertDialog.Builder(this).setTitle("알림").
                setIcon(android.R.drawable.ic_dialog_alert).
                setMessage("Hello World\nHello World\n").
                setCancelable(true).
                setNegativeButton("닫기", null).
                show();
    }

    public void dialogOKCancelButton( View view ) {
        new AlertDialog.Builder(this).setTitle("알림").
                setIcon(android.R.drawable.ic_dialog_alert).
                setMessage("Hello World\nHello World\n").
                setCancelable(true).
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("dialogOKCancelButton", "" + which);
                    }
                }).
                setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("dialogOKCancelButton", "" + which);
                    }
                }).
                setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("dialogOKCancelButton", "" + which);
                    }
                }).
                show();
    }

    public void dialogList( View view ) {
        new AlertDialog.Builder(this).
                setTitle("선택하세요").setItems(R.array.lists,  new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.d("dialogList", ""+ which);
                }

        }).
        show();
    }

    public void dialogProgress( View vPew ) {
        ProgressDialog dialog = new ProgressDialog(this);

        dialog.setTitle("처리중");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setMessage("잠시만 기다려주세요");
        dialog.show();
    }


    public void dialogSingleChoice( View view ) {
        new AlertDialog.Builder(this).
                setIcon(R.mipmap.ic_launcher).
                setTitle("Single Choice").
                setSingleChoiceItems(R.array.lists, indexSingleChoiceSelected, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("dialogSingleChoice", ""+which);
                        MainActivity.this.indexSingleChoiceSelected = which;
                    }
                }).
                setPositiveButton("확인", null).
                show();
    }
    public void dialogMultipleChoice( View view ) {
        choices[1] = true;
        choices[2] = true;

        new AlertDialog.Builder(this).
                setIcon(R.mipmap.ic_launcher).
                setTitle("Multiple Choice").
                setMultiChoiceItems(R.array.lists,
                        choices,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Log.d("dialogMultipleChoice", "" + which+":"+isChecked);
                                MainActivity.this.choices[which] = isChecked;
                            }
                        }).
                setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for(boolean choice:MainActivity.this.choices) {
                            Log.d("---------->", "" + choice);
                        }
                    }
                }).
                show();

    }

    public void dialogCustomLayout( View view ) {
    }
}
