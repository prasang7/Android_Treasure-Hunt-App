package com.devil07.divyang.hunt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView questions;
    EditText answers;
    Button  next;
    int i;
    int ans;
    ImageView images;
    SharedPreferences sharedPreferences;
    SurfaceView surfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        inivariables();
        checkIvalue();
        setquestion();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (i <= 11 && checkanswer())
                {
                    answers.setText("");

                    i++;
                    setI(i);
                    if (i == 12) {

                        Intent i=new Intent(MainActivity.this,WInner.class);
                        startActivity(i);
                    } else {

                        setquestion();
                    }

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "wrong code", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/



    void inivariables()
    {
        questions=(TextView)findViewById(R.id.questions);
        answers=(EditText)findViewById(R.id.answers);
        next=(Button)findViewById(R.id.next);
        i=0;
        sharedPreferences=getSharedPreferences("ques",MODE_PRIVATE);
        images=(ImageView)findViewById(R.id.images);
        surfaceView=(SurfaceView)findViewById(R.id.surfaceView);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    void setquestion()
    {
        switch (i)
        {
            case 0:
            {
                questions.setText(" Q1: 1-20-13 I am not a date.\n                 (near you)");
                ans = 54312;
                break;
            }
            case 10:
            {
                //questions.setText("Image poti");
                surfaceView.setVisibility(View.INVISIBLE);
                questions.setVisibility(View.INVISIBLE);
                images.setVisibility(View.VISIBLE);
                images.setImageResource(R.drawable.porticomin);
                ans = 456735;
                break;
            }
            case 1:
            {
                images.setVisibility(View.INVISIBLE);
                surfaceView.setVisibility(View.VISIBLE);
                questions.setVisibility(View.VISIBLE);
                questions.setText("Q2: No ID Card No Entry.");
                ans = 219638;
                break;
            }
            case 2:
            {

                //questions.setText("Q4: image");
                surfaceView.setVisibility(View.INVISIBLE);
                questions.setVisibility(View.INVISIBLE);
                images.setVisibility(View.VISIBLE);
                images.setImageResource(R.drawable.wellmin);
                ans = 78363;
                break;
            }
            case 3:
            {

                images.setVisibility(View.INVISIBLE);
                surfaceView.setVisibility(View.VISIBLE);
                questions.setVisibility(View.VISIBLE);
                questions.setText("Q4:NSS visits me on 15 and 26.");
                ans = 325414;
                break;
            }
            case 4:
            {
                surfaceView.setVisibility(View.INVISIBLE);
                questions.setVisibility(View.INVISIBLE);

                images.setVisibility(View.VISIBLE);
                images.setImageResource(R.drawable.pointmin);
                ans = 71425;
                break;
            }
            case 5:
            {
                images.setVisibility(View.INVISIBLE);
                surfaceView.setVisibility(View.VISIBLE);
                questions.setVisibility(View.VISIBLE);
                questions.setText("Q6: Add 2 to 11 \n     You still get 1. ");
                ans = 832643;
                break;
            }
            case 6:
            {
                surfaceView.setVisibility(View.INVISIBLE);
                questions.setVisibility(View.INVISIBLE);

                images.setVisibility(View.VISIBLE);
                images.setImageResource(R.drawable.fishmin);
                ans = 13245;
                break;
            }
            case 7:
            {
                images.setVisibility(View.INVISIBLE);
                surfaceView.setVisibility(View.VISIBLE);
                questions.setVisibility(View.VISIBLE);
                questions.setText("Q8:12 English wooden sticks\n                   at this place.");
                ans = 910564;
                break;
            }
            case 8:
            {

                questions.setText("Q9:Which is the tallest building in\n                          VIT? \n      (Depends on the no.of storeys*)");
                questions.setTextSize(20);
                ans = 103469;
                break;
            }
            case 9:
            {

                questions.setText("Q10: Shots fired at me each day. Its hot in Miami");
                ans = 61238;
                break;
            }
            case 11:
            {
                images.setVisibility(View.INVISIBLE);
                surfaceView.setVisibility(View.VISIBLE);
                questions.setVisibility(View.VISIBLE);
                questions.setText("      Q12: If in a circuit\nwhere would you finish? ");
                ans = 783799;
                break;
            }

        }

    }
    boolean checkanswer()
    {
        String k;
        int m;
        k=answers.getText().toString();
        if(k.equals(""))
        {
            m = 0;
        }
        else
        {

            m = Integer.parseInt(k);
        }

        if(ans==m)
        {
         return true;
        }
        else
        {
            return false;
        }
    }
    void checkIvalue()
    {
        int w;
        w=sharedPreferences.getInt("i",99);
        if(w==99)
        {
            i=0;

        }
        else if (w==12)
        {
            Intent i=new Intent(MainActivity.this,WInner.class);
            startActivity(i);
            //finish
        }
        else
        {
            i = w;
        }
    }
    void setI(int m)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("i",m);
        editor.commit();
    }
}
