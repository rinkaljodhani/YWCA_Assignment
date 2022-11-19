package com.example.ywca_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_one, btn_two, btn_three, btn_four, btn_five, btn_six, btn_seven, btn_eight, btn_nine, btn_add, btn_zero, btn_sub, btn_mumlti, btn_div, btn_clear, btn_equal, btn_advance, btn_standard;
    ArrayList<String> calculate;
    String merge = "";
    Calculator c;
    TextView tv_display, tv_history;
    boolean global_flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = new Calculator();
        calculate = new ArrayList<>();

        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        btn_three = findViewById(R.id.btn_three);
        btn_four = findViewById(R.id.btn_four);
        btn_five = findViewById(R.id.btn_five);
        btn_six = findViewById(R.id.btn_six);
        btn_seven = findViewById(R.id.btn_seven);
        btn_eight = findViewById(R.id.btn_eight);
        btn_nine = findViewById(R.id.btn_nine);
        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_mumlti = findViewById(R.id.btn_multi);
        btn_div = findViewById(R.id.btn_div);
        btn_zero = findViewById(R.id.btn_zero);
        btn_equal = findViewById(R.id.btn_equal);
        btn_clear = findViewById(R.id.btn_clear);
        tv_display = findViewById(R.id.tv_display);
        tv_history = findViewById(R.id.tv_history);
        btn_advance = findViewById(R.id.btn_advance);
        btn_standard = findViewById(R.id.btn_standard);

        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_zero.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_mumlti.setOnClickListener(this);
        btn_advance.setOnClickListener(this);
        btn_standard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                addfunction("1", global_flag);
                break;
            case R.id.btn_two:
                addfunction("2", global_flag);
                break;
            case R.id.btn_three:
                addfunction("3", global_flag);
                break;
            case R.id.btn_four:
                addfunction("4", global_flag);
                break;
            case R.id.btn_five:
                addfunction("5", global_flag);
                break;
            case R.id.btn_six:
                addfunction("6", global_flag);
                break;
            case R.id.btn_seven:
                addfunction("7", global_flag);
                break;
            case R.id.btn_eight:
                addfunction("8", global_flag);
                break;
            case R.id.btn_nine:
                addfunction("9", global_flag);
                break;
            case R.id.btn_equal:
                merge = merge + "=";
                int answer = c.calculateExpression(calculate);
                merge = merge + answer;
                tv_display.setText(merge);
                if(btn_standard.getVisibility()==View.VISIBLE){
                    tv_history.setText(tv_history.getText().toString()+"\n"+merge);
                }
                break;
            case R.id.btn_zero:
                addfunction("0", true);
                break;
            case R.id.btn_clear:
                global_flag = true;
                calculate = new ArrayList<>();
                merge = "";
                tv_display.setText(merge);
                break;
            case R.id.btn_add:
                addoperator("+", global_flag);
                break;
            case R.id.btn_sub:
                addoperator("-", global_flag);
                break;
            case R.id.btn_div:
                addoperator("/", global_flag);
                break;
            case R.id.btn_multi:
                addoperator("*", global_flag);
                break;
            case R.id.btn_standard:
                tv_history.setText("");
                btn_standard.setVisibility(View.GONE);
                btn_advance.setVisibility(View.VISIBLE);
                tv_history.setVisibility(View.GONE);
                break;
            case R.id.btn_advance:
                btn_advance.setVisibility(View.GONE);
                btn_standard.setVisibility(View.VISIBLE);
                tv_history.setVisibility(View.VISIBLE);
                break;


        }
    }

    private void addfunction(String s, boolean flag) {

        if (flag) {
            merge = merge + s;
            tv_display.setText(merge);
            calculate.add(s);
            global_flag = false;

        } else {
            Toast.makeText(MainActivity.this, "Please enter any operator", Toast.LENGTH_LONG).show();
        }

    }

    private void addoperator(String s, boolean flag) {

        if (!flag) {
            merge = merge + s;
            tv_display.setText(merge);
            calculate.add(s);
            global_flag = true;

        } else {
            Toast.makeText(MainActivity.this, "Please enter any number", Toast.LENGTH_LONG).show();
        }

    }

}