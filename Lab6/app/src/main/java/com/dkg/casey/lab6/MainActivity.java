package com.dkg.casey.lab6;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button startService_b, stopService_b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService_b = (Button)findViewById(R.id.button);
        stopService_b  = (Button)findViewById(R.id.button2);
        textView = (TextView)findViewById(R.id.textView);



        startService_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startService(new Intent(MainActivity.this, MyService.class));

            }
        });

        stopService_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                stopService(new Intent(MainActivity.this, MyService.class));
            }
        });
    }

    private void SetRandomLetter()
    {
        //textView.setText("Random Letter:  ");

    }

}

