package com.example.android1_homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Integer firstVar, secondVar;
    private Boolean isFirstVarChosen = false;
    private String operation;
    private Integer result;
    private Boolean isEqualRepair = false;
    private Button good;
    private boolean fix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
        good = findViewById(R.id.btn_good);
    }

    public void onNumberClick(View view) {
       if (fix){
           tvResult.setText("0");
           fix = false;
           good.setVisibility(View.GONE);
       }
        switch (view.getId()) {
            case R.id.btn_one:
                setTextTvResult("1");

                break;
            case R.id.btn_two:
                setTextTvResult("2");
                good.setVisibility(View.GONE);
                break;
            case R.id.btn_three:
                setTextTvResult("3");
                good.setVisibility(View.GONE);
                break;
            case R.id.btn_fore:
                setTextTvResult("4");
                good.setVisibility(View.GONE);
                break;
            case R.id.btn_five:
                setTextTvResult("5");
                good.setVisibility(View.GONE);
                break;
            case R.id.btn_six:
                setTextTvResult("6");
                good.setVisibility(View.GONE);
                break;
            case R.id.btn_seven:
                setTextTvResult("7");
                good.setVisibility(View.GONE);
                break;
            case R.id.btn_eight:
                setTextTvResult("8");
                break;
            case R.id.btn_nine:
                setTextTvResult("9");
                break;
            case R.id.btn_null:
                setTextTvResult("0");
                break;
            case R.id.btn_comma:
                setTextTvResult(",");
                break;
            case R.id.btn_ac:
                tvResult.setText("0");
                break;
        }
    }

    private void setTextTvResult(String number) {
        if (tvResult.getText().toString().equals("0")) {
            tvResult.setText(number);
        } else {
            tvResult.append(number);
        }
        if (isFirstVarChosen) {
            tvResult.setText(number);
        }
        isFirstVarChosen = false;
        isEqualRepair = false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isFirstVarChosen = true;
                isEqualRepair = false;
                operation = "+";
                break;
            case R.id.btn_dash:
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isFirstVarChosen = true;
                isEqualRepair = false;
                operation = "-";
                break;
            case R.id.btn_x:
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isFirstVarChosen = true;
                isEqualRepair = false;
                operation = "*";
                break;
            case R.id.btn_divide:
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isFirstVarChosen = true;
                isEqualRepair = false;
                operation = "/";
                break;
            case R.id.btn_equals:
                good.setVisibility(View.VISIBLE);
                fix = true;
                if (!isEqualRepair) {
                    secondVar = Integer.parseInt(tvResult.getText().toString());
                } else {
                    firstVar = Integer.parseInt(tvResult.getText().toString());
                }
                    switch (operation) {
                        case "+":
                            result = firstVar + secondVar;
                            break;
                        case "-":
                            result = firstVar - secondVar;
                            break;
                        case "*":
                            result = firstVar * secondVar;
                            break;
                        case "/":
                            result = firstVar / secondVar;
                            break;
                    }
                    tvResult.setText(result.toString());
                    isEqualRepair = true;
                    isFirstVarChosen = false;
                    break;
                }
        }


    public void onButtonClick(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        String text = result.toString();
        intent.putExtra("key1", text);
        startActivity(intent);
    }
}
