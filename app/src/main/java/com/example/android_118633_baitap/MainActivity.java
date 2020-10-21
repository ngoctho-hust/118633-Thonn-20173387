package com.example.android_118633_baitap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtDisplay, txtOperator;

    int state = 1; // trang thai 1: nhap toan hang 1, 2: nhap toan hang 2;
    int op1, op2; // toan hang
    int op = 0; // toan tu: 1 - ADD, 2 - SUB, 3 - MUL, 4 - DIV

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDisplay = findViewById(R.id.txt_display);
        txtOperator = findViewById(R.id.txt_operator);

        findViewById(R.id.btn_bs).setOnClickListener(this);
        findViewById(R.id.btn_c).setOnClickListener(this);
        findViewById(R.id.btn_ce).setOnClickListener(this);
        findViewById(R.id.btn_divide).setOnClickListener(this);
        findViewById(R.id.btn_multiply).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);
        findViewById(R.id.btn_dot).setOnClickListener(this);
        findViewById(R.id.btn_plus_minus).setOnClickListener(this);

        findViewById(R.id.btn_zero).setOnClickListener(this);
        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);
        findViewById(R.id.btn_four).setOnClickListener(this);
        findViewById(R.id.btn_five).setOnClickListener(this);
        findViewById(R.id.btn_six).setOnClickListener(this);
        findViewById(R.id.btn_seven).setOnClickListener(this);
        findViewById(R.id.btn_eight).setOnClickListener(this);
        findViewById(R.id.btn_nine).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btn_zero)
            addDigit(0);
        else if (id == R.id.btn_one)
            addDigit(1);
        else if (id == R.id.btn_two)
            addDigit(2);
        else if (id == R.id.btn_three)
            addDigit(3);
        else if (id == R.id.btn_four)
            addDigit(4);
        else if (id == R.id.btn_five)
            addDigit(5);
        else if (id == R.id.btn_six)
            addDigit(6);
        else if (id == R.id.btn_seven)
            addDigit(7);
        else if (id == R.id.btn_eight)
            addDigit(8);
        else if (id == R.id.btn_nine)
            addDigit(9);
        else if (id == R.id.btn_plus)
            setOperator(1);
        else if (id == R.id.btn_minus)
            setOperator(2);
        else if (id == R.id.btn_multiply)
            setOperator(3);
        else if (id == R.id.btn_divide)
            setOperator(4);
        else if (id == R.id.btn_equal)
            calc();
        else if (id == R.id.btn_bs)
            removeDigit();
        else if (id == R.id.btn_plus_minus)
            reverseOperand();
        else if (id == R.id.btn_ce)
            resetOperand();
        else if (id == R.id.btn_c)
            resetOperator();
    }

    private void resetOperator() {
        state = 1;
        op1 = 0;
        op2 = 0;
        op = 0;
        txtDisplay.setText(String.valueOf(op1));
    }

    private void resetOperand() {
        if (state == 1) {
            op1 = 0;
            txtDisplay.setText(String.valueOf(op1));
        } else {
            op2 = 0;
            txtDisplay.setText(String.valueOf(op2));
        }
    }

    private void reverseOperand() {
        if (state == 1) {
            op1 = -op1;
            txtDisplay.setText(String.valueOf(op1));
        } else {
            op2 = -op2;
            txtDisplay.setText(String.valueOf(op2));
        }
    }

    private void removeDigit() {
        if (state == 1) {
            op1 = op1 / 10;
            txtDisplay.setText(String.valueOf(op1));
        } else {
            op2 = op2 / 10;
            txtDisplay.setText(String.valueOf(op2));
        }
    }

    private void calc() {
        int res = 0;
        if (op == 1) {
            res = op1 + op2;
        } else if (op == 2) {
            res = op1 - op2;
        } else if (op == 3) {
            res = op1 * op2;
        } else if (op == 4) {
            res = op1 / op2;
        }

        txtDisplay.setText(String.valueOf(res));
        state = 1;
        op1 = 0;
        op2 = 0;
    }

    private void setOperator(int type) {
        state = 2;
        op = type;
        txtDisplay.setText(String.valueOf(op2));
    }

    private void addDigit(int digit) {
        if (state == 1) {
            op1 = op1 * 10 + digit;
            txtDisplay.setText(String.valueOf(op1));
        } else {
            op2 = op2 * 10 + digit;
            txtDisplay.setText(String.valueOf(op2));
        }
    }
}
