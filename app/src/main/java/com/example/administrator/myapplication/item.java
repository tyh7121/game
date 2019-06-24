package com.example.administrator.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class item extends TextView {
    public item(Context context) {
        super(context);
    }

    public item(Context context,@Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public item(Context context,@Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int lenght = getMeasuredWidth();
        setMeasuredDimension(lenght,lenght);
    }
    public void setNumber(int so){
        if(so<100){
            setTextSize(40);
        }else if (so<1000){
            setTextSize(35);
        }else {
            setTextSize(30);
        }
        if(so>=8){
            setTextColor(Color.WHITE);
        }else {
            setTextColor(Color.BLACK);
        }
        GradientDrawable drawable = (GradientDrawable)this.getBackground();
        drawable.setColor(Datagame.getDatagame().color(so));

        setBackground(drawable);

        if(so==0){
            setText("");
        }else {
            setText(""+so);
        }
    }
}
