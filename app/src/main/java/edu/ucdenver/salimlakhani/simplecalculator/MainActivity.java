/**
 * This is the main activity which represent a layout for a simple calculator ....
 * This file uses View Binding and also show how to number formattting.
 *
 * @author Salim Lakhani
 * @version 20230914
 */

package edu.ucdenver.salimlakhani.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import edu.ucdenver.salimlakhani.simplecalculator.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

//    private EditText editTextInput1;
//    private EditText editTextInput2;
//
//    private RadioButton radioButtonAdd;
//    private RadioButton radioButtonSub;
//    private RadioButton radioButtonMul;
//    private RadioButton radioButtonDiv;
//
//    TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //For using view binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

//        editTextInput1 = findViewById(R.id.editTextInput1);
//        editTextInput2 = findViewById(R.id.editTextInput2);
//
//        radioButtonDiv = findViewById(R.id.radioButtonDiv);
//        radioButtonMul = findViewById(R.id.radioButtonMult);
//        radioButtonAdd = findViewById(R.id.radioButtonAdd);
//        radioButtonSub = findViewById(R.id.radioButtonSubtract);
//
//        textViewResult = findViewById(R.id.textResult);

        binding.radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        calculate();

                    }
                }
        );

        binding.editTextInput1.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        calculate();
                    }
                }
        );

        binding.editTextInput2.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        calculate();
                    }
                }
        );


    }

    public void calculateClicked(View view) {
        calculate();
    }

    public void calculate () {
        double num1, num2, result;

        try {
            num1 = Double.parseDouble(binding.editTextInput1.getText().toString());
        }
        catch (NumberFormatException e) {
            Toast.makeText(this, "Number 1 can't be blank", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            num2 = Double.parseDouble(binding.editTextInput2.getText().toString());
        }
        catch (NumberFormatException e)
        {
            Toast.makeText(this, "Number 2 can't be blank", Toast.LENGTH_SHORT).show();
            return;
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
        else {
            if (num2 == 0)
            {
                Toast.makeText(this, "Cannot divide by 0", Toast.LENGTH_SHORT).show();
                return;

            }
            result = num1 /  num2;
        }

        binding.textResult.setText(Double.toString(result));

        DecimalFormat precision = new DecimalFormat("#,###.00");
        binding.textResultRounded.setText(precision.format(result));

        NumberFormat cf = NumberFormat.getCurrencyInstance(Locale.US);
        binding.textDecimal.setText(cf.format(result));
    }


    public void clearClicked(View view) {
        ClearFormDialog clearFormDialog = new ClearFormDialog();
        clearFormDialog.show(getSupportFragmentManager(), "");
    }

    public void clearForm () {
        binding.editTextInput1.setText("");
        binding.editTextInput2.setText("");
        binding.textResult.setText("0");
        binding.textDecimal.setText("0");
        binding.textResultRounded.setText("0");

        binding.radioButtonAdd.setChecked(true);
    }

}