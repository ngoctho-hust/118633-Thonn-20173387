package com.example.android_118633_baitap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtDisplay;
    Button btnCE, btnC, btnBS, btnDivide, btnMultiply, btnMinus;
    Button btnPlus, btnEqual, btnDot, btnPlusMinus;
    Button btnZero, btnOne, btnTwo, btnThree, btnFour;
    Button btnFive, btnSix, btnSeven, btnEight, btnNine;
    Boolean isDefault = true;
    Boolean operatorSelected = false;

    String currentOperand = "0";
    String preOperand = "0";
    String currentOperator = "";
    String result = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDisplay = findViewById(R.id.txt_display);

        btnBS = findViewById(R.id.btn_bs);
        btnC = findViewById(R.id.btn_c);
        btnCE = findViewById(R.id.btn_ce);
        btnDivide = findViewById(R.id.btn_divide);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnMinus = findViewById(R.id.btn_minus);
        btnPlus = findViewById(R.id.btn_plus);
        btnEqual = findViewById(R.id.btn_equal);
        btnDot = findViewById(R.id.btn_dot);
        btnPlusMinus = findViewById(R.id.btn_plus_minus);

        btnZero = findViewById(R.id.btn_zero);
        btnOne = findViewById(R.id.btn_one);
        btnTwo = findViewById(R.id.btn_two);
        btnThree = findViewById(R.id.btn_three);
        btnFour = findViewById(R.id.btn_four);
        btnFive = findViewById(R.id.btn_five);
        btnSix = findViewById(R.id.btn_six);
        btnSeven = findViewById(R.id.btn_seven);
        btnEight = findViewById(R.id.btn_eight);
        btnNine = findViewById(R.id.btn_nine);

        btnBS.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnPlusMinus.setOnClickListener(this);

        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int clickId = v.getId();

        if (clickId == btnCE.getId()) {
            ceHandler();
        } else if (clickId == btnC.getId()) {
            cHandler();
        } else if (clickId == btnBS.getId()) {
            bsHandler();
        } else {
            switch (clickId) {
                case R.id.btn_zero:
                    if (!isDefault)
                        currentOperand += "0";
                    if (operatorSelected) {
                        preOperand = currentOperand;
                        currentOperand = "0";
                    }

                    operatorSelected = false;
                    txtDisplay.setText(currentOperand);
                    break;
                case R.id.btn_one:
                    numberHandler("1");
                    break;
                case R.id.btn_two:
                    numberHandler("2");
                    break;
                case R.id.btn_three:
                    numberHandler("3");
                    break;
                case R.id.btn_four:
                    numberHandler("4");
                    break;
                case R.id.btn_five:
                    numberHandler("5");
                    break;
                case R.id.btn_six:
                    numberHandler("6");
                    break;
                case R.id.btn_seven:
                    numberHandler("7");
                    break;
                case R.id.btn_eight:
                    numberHandler("8");
                    break;
                case R.id.btn_nine:
                    numberHandler("9");
                    break;
                case R.id.btn_divide:
                    currentOperator = "/";
                    operatorSelected = true;
                    break;
                case R.id.btn_multiply:
                    currentOperator = "x";
                    operatorSelected = true;
                    break;
                case R.id.btn_minus:
                    currentOperator = "-";
                    operatorSelected = true;
                    break;
                case R.id.btn_plus:
                    currentOperator = "+";
                    operatorSelected = true;
                    break;
                case R.id.btn_equal:
                    equalHandler();
                    break;
            }
        }
    }


    private void ceHandler() {
        isDefault = true;
        currentOperand = "0";
        txtDisplay.setText(currentOperand);
    }

    private void cHandler() {
        isDefault = true;
        currentOperand = "0";
        currentOperator = "";
        txtDisplay.setText(currentOperand);
    }

    private void bsHandler() {
        if (currentOperand.length() == 1) {
            currentOperand = "0";
            isDefault = true;
        }
        else {
            currentOperand = currentOperand.substring(0, currentOperand.length() - 1);
        }

        txtDisplay.setText(currentOperand);
    }

    private void numberHandler (String number) {
        if (isDefault)
            currentOperand = number;
        else if (operatorSelected) {
            preOperand = currentOperand;
            currentOperand = number;
        } else
            currentOperand += number;
        operatorSelected = false;

        txtDisplay.setText(currentOperand);
        if (!currentOperand.equals("0")) isDefault = false;
    }

    private void equalHandler() {
        if (!currentOperator.equals("")) {
            switch (currentOperator) {
                case "/":
                    if (currentOperand.equals("0")) {
                        result = "ERROR";
                    } else {
                        result = String.valueOf(Integer.parseInt(preOperand) / Integer.parseInt(currentOperand));
                    }
                    break;
                case "x":
                    result = String.valueOf(Integer.parseInt(preOperand) * Integer.parseInt(currentOperand));
                    break;
                case "-":
                    result = String.valueOf(Integer.parseInt(preOperand) - Integer.parseInt(currentOperand));
                    break;
                case "+":
                    result = String.valueOf(Integer.parseInt(preOperand) + Integer.parseInt(currentOperand));
                    break;
            }

            if (!result.equals("ERROR")) {
                preOperand = result;
                currentOperand = result;
            }
            txtDisplay.setText(result);
            isDefault = true;
            currentOperator = "";
        }
    }
}
