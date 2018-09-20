package com.dkg.casey.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    String userName = null, password = null;
    EditText userText, passText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userText = (EditText)findViewById(R.id.editText2);
        passText = (EditText)findViewById(R.id.editText);
        final Button loginButton = (Button)findViewById(R.id.button);

        final Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = userText.getText().toString();
                password = passText.getText().toString();
                intent.putExtra("USER_NAME",userName);
                intent.putExtra("PASSWORD",password);
                startActivity(intent);
            }
        });

    }


}
