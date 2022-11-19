package com.example.ywca_assignment1;

import android.widget.Toast;

import java.util.ArrayList;

public class Calculator {

    public int calculateExpression(ArrayList<String> calculate) {

        if (calculate.size() > 2) {
            int a = Integer.parseInt(calculate.get(0));
            String b = calculate.get(1);
            int c = Integer.parseInt(calculate.get(2));

            int result_final = firstfunction(a, b, c);

            ArrayList<String> new_array = new ArrayList<>();
            new_array.add(String.valueOf(result_final));

            if (calculate.size() > 3) {

                for (int i = 3; i < calculate.size(); i++) {
                    new_array.add(calculate.get(i));
                }
                int ans = calculateExpression(new_array);
                return ans;
            } else {
                return result_final;
            }
        }else{
            return Integer.parseInt(calculate.get(0));
        }


    }

    private int firstfunction(int a, String b, int c) {

        int result = 0;
        switch (b) {
            case "+":
                result = a + c;
                break;
            case "-":
                result = a - c;
                break;
            case "*":
                result = a * c;
                break;
            case "/":
                result = a / c;
                break;

        }
        return result;
    }
}
