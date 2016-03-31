package com.devil07.divyang.hunt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PreEvent extends AppCompatActivity {
    EditText ed1;
    Button next;
    SharedPreferences sharedPreferences;
    int ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_event);
        initVariables();
        checkCode();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String k;
                int m;
                k = ed1.getText().toString();
                if (k.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "wrong", Toast.LENGTH_SHORT).show();
                }
                else
                {
                     m = Integer.parseInt(k);
                     if (m == ans)
                     {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("ing", m);
                        editor.commit();
                        Intent l = new Intent(PreEvent.this, MainActivity.class);
                        startActivity(l);

                    }
                     else
                     {
                        Toast.makeText(getApplicationContext(), "wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }
    void initVariables()
    {
        ed1=(EditText)findViewById(R.id.ed1);
        next=(Button)findViewById(R.id.next);
        sharedPreferences=getSharedPreferences("preEvent",MODE_PRIVATE);
        ans=414924;

    }
    void checkCode()
    {
        int w;
        w=sharedPreferences.getInt("ing",99);
        if(w==ans)
        {
            Intent l=new Intent(PreEvent.this,MainActivity.class);
            startActivity(l);
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}