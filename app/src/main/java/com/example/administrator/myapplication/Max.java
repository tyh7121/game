package com.example.administrator.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class Max {

    enum Key {
        BEST_SCORE,
    }
    private static SharedPreferences prefs;

    public static void initialize(Context context) {
        if (prefs == null) {
            prefs = context.getSharedPreferences("highscore", Context.MODE_PRIVATE);
        }
    }

    public static void saveBestScore(int score) {
        prefs.edit().putInt(Key.BEST_SCORE.name(), score).commit();
    }

    public static int getBestScore() {
        return prefs.getInt(Key.BEST_SCORE.name(), 0);
    }


}
