package com.dkg.casey.lab6;

import android.app.Service;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Debug;
import android.os.IBinder;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyService extends Service
{
    public String randomChar;
    boolean isActive = false;
    ArrayList<String> letters = new ArrayList<String>();
    TextView textView;
    @Override
    public void onCreate()
    {
        Toast.makeText(this, "Service Created!", Toast.LENGTH_SHORT).show();
        super.onCreate();

    }
    @Override
    public void onDestroy() {

        Toast.makeText(this, "Service Destroyed!", Toast.LENGTH_SHORT).show();
        StopRandomLetter();
        super.onDestroy();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Service Started!", Toast.LENGTH_SHORT).show();
        isActive = true;

        new Thread(new Runnable() {
            @Override
            public void run() {
                StartRandomLetter();
            }
        }
        ).start();

        return START_STICKY;

        //return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return  null;
    }

    public void StartRandomLetter()
    {

        Random rand = new Random();
       //Character a = 'A', b = 'B',c = 'C',d = 'D',e = 'E',f = 'F',g = 'G',h = 'H',i = 'I',j = 'J',k = 'K',l = 'L',m = 'M',n = 'N',o = 'O',p = 'P',q = 'Q',r = 'R',s = 'S',t = 'T',u = 'U',v = 'V',w = 'W',x = 'X',y = 'Y',z = 'Z';
        letters.add("A");letters.add("B");letters.add("C");letters.add("D");letters.add("E");letters.add("F");letters.add("G");letters.add("H");letters.add("I");letters.add("J");
        letters.add("K");letters.add("L");letters.add("M");letters.add("N");letters.add("O");letters.add("P");letters.add("Q");letters.add("R");letters.add("S");letters.add("T");
        letters.add("U");letters.add("V");letters.add("W");letters.add("X");letters.add("Y");letters.add("Z");
        while (isActive == true)
        {
            try {
                Thread.sleep(1000);
                if(isActive == true)
                {
                    randomChar = letters.get(rand.nextInt(letters.size()));
                    Log.i("Random Letter", randomChar.toString());
                }

            }
            catch (InterruptedException ex)
            {
                Log.i("Random Letter", "Thread Interruped");
            }
        }
    }
   // public  Character  GetRandomCharacter () {return  randomChar;}
    private  void StopRandomLetter(){isActive = false;}

}
