package edu.ucdenver.salimlakhani.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view) {
        Toast.makeText(this,"You clicked on Calculate button",Toast.LENGTH_LONG).show();
    }

    public void clearForm(View view) {
        Toast.makeText(this,"You clicked on Clear button",Toast.LENGTH_SHORT).show();
    }



}