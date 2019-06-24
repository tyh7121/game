package com.example.administrator.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private View.OnTouchListener listener;
    private GridView gridView;
    private TextView max,point;
    numberAdapter numberAdapter;

    private float X,Y;
    private final String Highscore = "highscore";
    private int click;
    private int a,b,c,d;
    private ArrayList<Integer> arrayList;


   @Override
   protected void onResume() {
       max.setText(""+Max.getBestScore());
       super.onResume();
   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.game);
        max      = (TextView) findViewById(R.id.max);
        point    = (TextView) findViewById(R.id.point);

        khoitao();
        setData();





    }

    public int checkData(){
       ArrayList<Integer> tmp = Datagame.getDatagame().getArrayList();
       for(int i : tmp){

       }
       return 0;
    }

    private void khoitao(){
        Datagame.getDatagame().numberItem(MainActivity.this);
        numberAdapter = new numberAdapter(MainActivity.this,0,
                Datagame.getDatagame().getArrayList());
        listener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        X = event.getX();
                        Y = event.getY();

                        break;
                    case MotionEvent.ACTION_UP:
                        if(Math.abs(event.getX()-X)> Math.abs(event.getY()-Y)){
                            if(event.getX()>X){
                                Datagame.getDatagame().rightTouch();

                                Toast.makeText(MainActivity.this, Datagame.tmp+"", Toast.LENGTH_SHORT).show();


                                numberAdapter.notifyDataSetChanged();
                               // Toast.makeText(MainActivity.this,"ABC", Toast.LENGTH_SHORT).show();
                                a = a+1;
                            }else {
                                Datagame.getDatagame().leftTouch();

                                numberAdapter.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this, Datagame.tmp+"", Toast.LENGTH_SHORT).show();                                b = b+1;
                            }
                        }else {
                            if(event.getY()<Y){
                                Datagame.getDatagame().upTouch();
                                numberAdapter.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this, Datagame.tmp+"", Toast.LENGTH_SHORT).show();                                c= c+1;
                            }else {
                                Datagame.getDatagame().downTouch();

                                numberAdapter.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this, Datagame.tmp+"", Toast.LENGTH_SHORT).show();                                d = d+1;
                            }
                        }
                        break;
                }
                if(X>0){
                    click= a + b +c +d;
                    point.setText(""+click);

                    if(click>Max.getBestScore()){
                        max.setText(""+click);
                        Max.saveBestScore(click);
                    }
                }


                return true;
            }
        };

    }
    private void setData(){
        gridView.setAdapter(numberAdapter);

        gridView.setOnTouchListener(listener);


    }



}
