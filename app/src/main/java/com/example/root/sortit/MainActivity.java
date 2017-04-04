package com.example.root.sortit;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;
//import java.util.Random;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {
    //long millisInFuture=0;
    final String LOG_TAG = MainActivity.class.getSimpleName();
    CountDownTimer timer = new CountDownTimer(60000, 1000) {


        public void onTick(long millisUntilFinished) {
            mTextField.setText("00:" + (millisUntilFinished )/ 1000);
        }



        public void onFinish() {

            start.setEnabled(true);
            default_stage(false);
            mTextField.setText("Time Up!");
            raw.setText("");
        }
    };



    TreeSet<Character> treeSet;
    static int userScore = 0;
    static int buttonClick=0;
    TextView mTextField ;
    TextView answer, raw, score;
    Button b1, b2, b3, b4, b5, b6, b7, b8, start,pass;
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer = (TextView) findViewById(R.id.answer);
        raw = (TextView)findViewById(R.id.raw_string);
        score = (TextView)findViewById(R.id.score_textView);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        pass=(Button)findViewById(R.id.pass);
        start=(Button)findViewById(R.id.start_button);
      //  submit = (Button) findViewById(R.id.submit_button);
        mTextField=(TextView)findViewById(R.id.counter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String old_string = answer.getText().toString();
                String new_string = old_string+b1.getText().toString();

                answer.setText(new_string);
                b1.setEnabled(false);
                buttonClick++;
                check();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String old_string = answer.getText().toString();
                String new_string = old_string+b2.getText().toString();

                answer.setText(new_string);
                b2.setEnabled(false);
                buttonClick++;
                check();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String old_string = answer.getText().toString();
                String new_string = old_string+b3.getText().toString();

                answer.setText(new_string);
                b3.setEnabled(false);
                buttonClick++;
                check();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String old_string = answer.getText().toString();
                String new_string = old_string+b4.getText().toString();

                answer.setText(new_string);
                b4.setEnabled(false);
                buttonClick++;
                check();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String old_string = answer.getText().toString();
                String new_string = old_string+b5.getText().toString();

                answer.setText(new_string);
                b5.setEnabled(false);
                buttonClick++;
                check();
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String old_string = answer.getText().toString();
                String new_string = old_string+b6.getText().toString();

                answer.setText(new_string);
                b6.setEnabled(false);
                buttonClick++;
                check();
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String old_string = answer.getText().toString();
                String new_string = old_string+b7.getText().toString();

                answer.setText(new_string);
                b7.setEnabled(false);
                buttonClick++;
                check();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String old_string = answer.getText().toString();
                String new_string = old_string+b8.getText().toString();

                answer.setText(new_string);
                b8.setEnabled(false);
                buttonClick++;
                check();
            }
        });

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                generate();

            }
        });


    }

    @Override
    protected void onStart() {
        pass.setEnabled(false);
        default_stage(false);
        super.onStart();
    }

    public void setLetter(){
        int count = 1;
        SecureRandom random = new SecureRandom();
        while(treeSet.size()<8){
            int number = random.nextInt(26);
            Log.v(LOG_TAG, String.valueOf(number));
            Log.v(LOG_TAG, String.valueOf(alphabet[number]));
            String old = raw.getText().toString();
            String newString = old+alphabet[number];
            raw.setText(newString);
            if(treeSet.contains(alphabet[number])){
                continue;
            }
            treeSet.add(alphabet[number]);
            Log.v(LOG_TAG, "TreeSet "+treeSet.toString());
            switch (count){
                case 1:
                    b1.setText(String.valueOf(alphabet[number]));
                    break;
                case 2:
                    b2.setText(String.valueOf(alphabet[number]));
                    break;
                case 3:
                    b3.setText(String.valueOf(alphabet[number]));
                    break;
                case 4:
                    b4.setText(String.valueOf(alphabet[number]));
                    break;
                case 5:
                    b5.setText(String.valueOf(alphabet[number]));
                    break;
                case 6:
                    b6.setText(String.valueOf(alphabet[number]));
                    break;
                case 7:
                    b7.setText(String.valueOf(alphabet[number]));
                    break;
                case 8:
                    b8.setText(String.valueOf(alphabet[number]));
                    break;
            }
            count++;
        }
    }
    public void resetGame(){

        buttonClick=0;
        answer.setText("");
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);

        treeSet = new TreeSet<>();
        raw.setText("");
        setLetter();
    }

    public void check()
    {

        if(buttonClick==8) {

            String temp = new String();
            for (char w : treeSet) {
                temp = temp + w;
            }


            Log.v(LOG_TAG, temp);
            if (answer.getText().toString().equals(temp)) {
                Toast.makeText(getApplicationContext(), "Right!!  ", Toast.LENGTH_SHORT).show();
                userScore++;
               // millisInFuture+=5000;

                score.setText("Score : " + userScore);
            } else {
                Toast.makeText(getApplicationContext(), "Wrong..Try Again!!", Toast.LENGTH_SHORT).show();
                score.setText("Score : " + userScore);
            }
            resetGame();
        }

    }



    public void resetClicked(View view){
        userScore = 0;
        buttonClick=0;
        score.setText("Score : " + userScore);
        timer.cancel();
        resetGame();
        startGame(view);
    }
    public void startGame(View view){

        start.setEnabled(false);
        pass.setEnabled(true);
        userScore=0;
        score.setText("Score : " + userScore);
        treeSet = new TreeSet<>();
        answer.setText("");

        default_stage(true);
        setLetter();
        timer.start();
    }


    public void default_stage(boolean state)
    {
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b1.setEnabled(state);
        b2.setEnabled(state);
        b3.setEnabled(state);
        b4.setEnabled(state);
        b5.setEnabled(state);
        b6.setEnabled(state);
        b7.setEnabled(state);
        b8.setEnabled(state);
    }

    public void generate()
    {
        buttonClick=0;
        score.setText("Score : " + userScore);
        treeSet = new TreeSet<>();
        raw.setText("");
        answer.setText("");
        default_stage(true);
        setLetter();
    }

}

