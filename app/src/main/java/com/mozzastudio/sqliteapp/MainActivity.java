package com.mozzastudio.sqliteapp;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnStore, btnGetAll;
    EditText etName;
    TextView tvName;
    DatabaseHelper databaseHelper;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStore = (Button) findViewById(R.id.btnStore);
        btnGetAll = (Button) findViewById(R.id.btnGet);
        etName = (EditText) findViewById(R.id.etName);
        tvName = (TextView) findViewById(R.id.tvNames);

        databaseHelper = new DatabaseHelper(this);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addStudentDetail(etName.getText().toString());
                etName.setText("");
                Toast.makeText(MainActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        btnGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = databaseHelper.getAllStudentList();
                tvName.setText(arrayList.get(0));
                for (int i = 1; i < arrayList.size(); i++) {
                    tvName.setText(tvName.getText().toString() + ", " + arrayList.get(i));
                }
            }
        });
    }
}
