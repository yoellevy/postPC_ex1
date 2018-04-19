package com.example.yoel.postpcex1;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ListView msgList;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter adapter;
    Context con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msgList = (ListView) findViewById(R.id.MsgList);
        msgList.setEnabled(true);
        con = this;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        msgList.setAdapter(adapter);


        Button button = (Button) findViewById(R.id.Button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText text = (EditText) findViewById(R.id.EditText);
                String msg = "Me:" + text.getText().toString();
                Date date = new Date();
                msg += " \n" + date.getHours()+":"+date.getMinutes();
                list.add(msg);

                adapter = new ArrayAdapter<String>(con, android.R.layout.simple_list_item_1, list);

                msgList.setAdapter(adapter);
            }
        });


    }


}
