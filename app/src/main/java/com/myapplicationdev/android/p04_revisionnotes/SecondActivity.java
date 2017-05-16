package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Note> noteList;
    ArrayAdapter aN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //TODO implement the Custom ListView
        lv = (ListView) findViewById(R.id.lv);
        DBHelper db = new DBHelper(SecondActivity.this);
        noteList = db.getAllNotes();
        db.close();
        aN = new RevisionNotesArrayAdapter(SecondActivity.this,R.layout.row,noteList);
        lv.setAdapter(aN);

    }


}
