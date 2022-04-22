package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
Connection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnConnect = (Button)findViewById(R.id.btnconnect);
        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView FirstName = (TextView) findViewById(R.id.textView);
                TextView LastName = (TextView) findViewById(R.id.textView2);
                TextView Department = (TextView) findViewById(R.id.textView3);
                ConnectionClass c = new ConnectionClass();
                connection = c.connClass();
                if(c !=null){
                try{
                String qry = "Select * from employees";
                Statement smt = connection.createStatement();
                ResultSet set = smt.executeQuery(qry);
                while (set.next()) {
                    FirstName.setText(set.getString(2));
                    LastName.setText(set.getString(3));
                    Department.setText(set.getString(4));
                }
                connection.close();
                }catch (Exception e){
                    Log.e("Error: ",e.getMessage());
                }
                }
            }
        });
    }
}