package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button btnInsert;
    Button btnShow;
    RadioGroup rgStars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.editTextNote);
        btnInsert = (Button) findViewById(R.id.buttonInsertNote);
        btnShow = (Button) findViewById(R.id.buttonShowList);
        rgStars = (RadioGroup) findViewById(R.id.radioGroupStars);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = et.getText().toString();
                //Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId = rgStars.getCheckedRadioButtonId();
                //Get the radio button object from the Id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                String selected = rb.getText().toString();
                int star = Integer.parseInt(selected);
                DBHelper db = new DBHelper(MainActivity.this);
                // Insert a task
                db.insertNote(note, star);
                db.close();
                //Show a Toast that display the text on the selected radio button
                Toast.makeText(MainActivity.this, "Inserted",
                        Toast.LENGTH_LONG).show();
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
