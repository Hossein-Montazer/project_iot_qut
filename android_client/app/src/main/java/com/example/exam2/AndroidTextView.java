package com.example.exam2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import app.app;

public class AndroidTextView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androin_text_view);
        setTitle(getResources().getString(R.string.AndroidTextView));
        TextView textView=(TextView)findViewById(R.id.mainText);
        Typeface typeface=Typeface.createFromAsset(getAssets(),app.main.font_patch+app.main.font_IRANMarker);
        textView.setTypeface(typeface);
    }
}
