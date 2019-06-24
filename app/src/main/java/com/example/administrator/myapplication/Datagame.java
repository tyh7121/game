package com.example.administrator.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Datagame {
    private static Datagame datagame;
    private  ArrayList<Integer> arrayList = new ArrayList<>();
    private int[] colorTable;
    private int [][] mang2chieu = new int[4][4];
    private Random random = new Random();
    public static int tmp = 0;
    private int lose;
    static {
        datagame = new Datagame();
    }
    public static Datagame getDatagame(){
        return datagame;
    }
    public void numberItem(Context context){
        for(int i = 0;i < 4;i++){
            for (int j = 0;j < 4;j++){
                mang2chieu [i][j] = 0;
                arrayList.add(0);
            }
        }
        TypedArray typeArray = context.getResources().obtainTypedArray(R.array.colorItem);
        colorTable = new int[typeArray.length()];
        for(int i=0;i<typeArray.length();i++){
            colorTable[i] = typeArray.getColor(i,0);
        }
        typeArray.recycle();
        createNumber();
        change();
    }

    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }
    public int color(int number){
        if(number==0){
            return Color.WHITE;
        }else {
            int a = (int) (Math.log(number)/Math.log(2));
            return colorTable[a - 1];
        }
    }
    public int createNumber(){
        int number = 0;
        for(int i = 0;i<16;i++){
            if(arrayList.get(i)==0){
                number++;
            }

        }
        int randomNumber;
        if(number>1){
             randomNumber = random.nextInt(2)+1;
        }else {
            if(number==1){
                randomNumber = 1;
            }else {
                randomNumber = 0;
            }
        }
        while (randomNumber!=0){
            int i = random.nextInt(4),j = random.nextInt(4);
            if(mang2chieu[i][j]==0){
                mang2chieu[i][j] = 2;
                randomNumber--;
            }
            return 1;
        }
        return 0;
    }
    public void change(){
        arrayList.clear();
        for(int i = 0;i < 4;i++){
            for (int j = 0;j < 4;j++){

                arrayList.add(mang2chieu[i][j]);
            }
        }
    }
    public void rightTouch(){
        for(int i = 3;i >= 0;i--){
            for(int j = 3;j >= 0;j--){
                int so = mang2chieu[i][j];
                if(so == 0){
                    continue;
                }else {
                    for(int k = j-1;k >= 0;k--){
                        int soX = mang2chieu[i][k];
                        if(soX == 0){
                            continue;
                        }else{
                            if(soX == so){
                                mang2chieu[i][j] = so*2;
                                mang2chieu[i][k] = 0;
                                break;
                            }else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        for(int i = 3;i >= 0;i--){
            for(int j = 3;j >= 0;j--){
                int so = mang2chieu[i][j];
                if(so ==0 ){
                    for(int k = j-1;k >= 0;k--) {
                        int so1 = mang2chieu[i][k];
                        if (so1 == 0) {
                            continue;
                        }else {
                            mang2chieu[i][j] = mang2chieu[i][k];
                            mang2chieu[i][k] = 0;
                            break;
                        }
                    }
                }
            }
        }
        tmp = createNumber();
        change();
    }
    public void leftTouch(){
        for(int i = 0;i < 4;i++){
            for(int j = 0;j < 4;j++){
                int so = mang2chieu[i][j];
                if(so == 0){
                    continue;
                }else {
                    for(int k = j+1;k < 4;k++){
                        int soX = mang2chieu[i][k];
                        if(soX == 0){
                            continue;
                        }else{
                            if(soX == so){
                                mang2chieu[i][j] = so*2;
                                mang2chieu[i][k] = 0;
                                break;
                            }else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0;i < 4;i++) {
            for (int j = 0; j < 4; j++) {
                int so = mang2chieu[i][j];
                if(so ==0 ){
                    for(int k = j+1;k < 4;k++) {
                        int so1 = mang2chieu[i][k];
                        if (so1 == 0) {
                            continue;
                        }else {
                            mang2chieu[i][j] = mang2chieu[i][k];
                            mang2chieu[i][k] = 0;
                            break;
                        }
                    }
                }
            }
        }
        tmp = createNumber();
        change();
    }
    public void upTouch(){
        for(int i = 0;i < 4;i++){
            for(int j = 0;j < 4;j++){
                int so = mang2chieu[j][i];
                if(so == 0){
                    continue;
                }else {
                    for(int k = j+1;k < 4;k++){
                        int soX = mang2chieu[k][i];
                        if(soX == 0){
                            continue;
                        }else{
                            if(soX == so){
                                mang2chieu[j][i] = so*2;
                                mang2chieu[k][i] = 0;
                                break;
                            }else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0;i < 4;i++) {
            for (int j = 0; j < 4; j++) {
                int so = mang2chieu[j][i];
                if(so ==0 ){
                    for(int k = j+1;k < 4;k++) {
                        int so1 = mang2chieu[k][i];
                        if (so1 == 0) {
                            continue;
                        }else {
                            mang2chieu[j][i] = mang2chieu[k][i];
                            mang2chieu[k][i] = 0;
                            break;
                        }
                    }
                }
            }
        }
        tmp = createNumber();
        change();
    }
    public void downTouch(){
        for(int i = 3;i >= 0;i--){
            for(int j = 3;j >= 0;j--){
                int so = mang2chieu[j][i];
                if(so == 0){
                    continue;
                }else {
                    for(int k = j-1;k >= 0;k--){
                        int soX = mang2chieu[k][i];
                        if(soX == 0){
                            continue;
                        }else{
                            if(soX == so){
                                mang2chieu[j][i] = so*2;
                                mang2chieu[k][i] = 0;
                                break;
                            }else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        for(int i = 3;i >= 0;i--){
            for(int j = 3;j >= 0;j--){
                int so = mang2chieu[j][i];
                if(so ==0 ){
                    for(int k = j-1;k >= 0;k--) {
                        int so1 = mang2chieu[k][i];
                        if (so1 == 0) {
                            continue;
                        }else {
                            mang2chieu[j][i] = mang2chieu[k][i];
                            mang2chieu[k][i] = 0;
                            break;
                        }
                    }
                }
            }
        }
        tmp = createNumber();
        change();
    }


}
