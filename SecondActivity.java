//CASEY LORIA
package com.dkg.casey.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    String userName, password;
    String validUser = "cs4322", validPass = "123456";
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView)findViewById(R.id.textView3);

        Bundle extra = getIntent().getExtras();
        userName = getIntent().getStringExtra("USER_NAME");
        password =  getIntent().getStringExtra("PASSWORD");

        CheckLogin();

        final Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        final Button backButton = (Button)findViewById(R.id.button3);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(intent);
            }
        });

    }
    public void CheckLogin()
    {
        if(userName.equals("cs4322") && password.equals("123456"))
        {
            textView.setText("Congratulations " + userName + "!   Welcome to my web page!");
        }
        else
        {
            textView.setText("Sorry! Login Failed. Please Try Again. :( ");
        }
    }

}
