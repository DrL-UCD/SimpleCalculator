package edu.ucdenver.salimlakhani.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import edu.ucdenver.salimlakhani.simplecalculator.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
//    private EditText editTextInput1;
//    private EditText editTextInput2;
//
//    private RadioButton radioButtonAdd;
//    private RadioButton radioButtonSubtract;
//    private RadioButton radioButtonMul;
//    private RadioButton radioButtonDiv;
//
//    private TextView textViewResult;

    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Find reference to views
//        editTextInput1 = findViewById(R.id.editTextInput1);
//        editTextInput2 = findViewById(R.id.editTextInput2);

        //Get references to radio buttons
//        radioButtonAdd = findViewById(R.id.radioButtonAdd);
//        radioButtonSubtract = findViewById(R.id.radioButtonSubtract);
//        radioButtonMul = findViewById(R.id.radioButtonMult);
//        radioButtonDiv = findViewById(R.id.radioButtonDiv);

        //Get reference for text view
//        textViewResult = findViewById(R.id.textResult);
    }

    public void calculate(View view) {
        //Toast.makeText(this,"You clicked on Calculate button",Toast.LENGTH_LONG).show();
        double num1 = 0;
        double num2 =0;
        double result = 0;
        try {
            num1 = Double.parseDouble(binding.editTextInput1.getText().toString());
        }
        catch (NumberFormatException ex) {
                Toast.makeText(this, "Input must be a number", Toast.LENGTH_SHORT).show();
        }

        try {
            num2 = Double.parseDouble(binding.editTextInput2.getText().toString());
        }
        catch (NumberFormatException ex) {
            Toast.makeText(this, "Input must be a number", Toast.LENGTH_SHORT).show();
        }

        if (binding.radioButtonAdd.isChecked()) {
            result = num1 + num2;
        }
        else if (binding.radioButtonSubtract.isChecked()) {
            result = num1 - num2;
        }
        else if (binding.radioButtonMult.isChecked()) {
            result = num1 * num2;
        }
        else if (binding.radioButtonDiv.isChecked()) {
            result = num1 / num2;
        }

        binding.textResult.setText(Double.toString(result));

        DecimalFormat precision = new DecimalFormat("#,##0.00");
        binding.textResultRounded.setText(precision.format(result));

        NumberFormat cf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        binding.textDecimal.setText(cf.format(result));



    }

    public void clearForm(View view) {
        binding.editTextInput1.setText ("");
        binding.editTextInput2.setText("");
        binding.textResult.setText("0");
        binding.radioButtonAdd.setChecked(true);
        //Toast.makeText(this,"You clicked on Clear button",Toast.LENGTH_SHORT).show();

    }



}