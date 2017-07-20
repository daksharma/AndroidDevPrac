package com.dakshsharma.palindromic;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpWidgets();
    }


    public void setUpWidgets() {
        final EditText editText = (EditText) findViewById(R.id.editText);
        final TextView tv       = (TextView) findViewById(R.id.validCheckTV);
        final Button   btn      = (Button) findViewById(R.id.checkPalindrome);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(editText.getText().toString())) {
                    tv.setText(isPalindromic(editText.getText().toString()));

                } else {
                    tv.setText("Please enter a word to check Palindrome!");
                }
                hideKeyboard(v);
            }
        });

        final EditText fizzET = (EditText) findViewById(R.id.fizzbuzzET);
        final TextView fizzTV = (TextView) findViewById(R.id.fizzbuzzTV);
        final Button fizzBtn = (Button) findViewById(R.id.checkFizzBuzz);
        fizzBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = fizzET.getText().toString();
                if (!TextUtils.isEmpty(word) && TextUtils.isDigitsOnly(word)) {
                    fizzTV.setText(dryFizzBuzz(word));
                } else {
                    fizzTV.setText("Please enter a number!");
                }
                hideKeyboard(v);
            }
        });

        final EditText revEditText = (EditText) findViewById(R.id.reverseEditText);
        final TextView revTextView = (TextView) findViewById(R.id.reverseTextView);
        final Button revButton = (Button) findViewById(R.id.reverseButton);
        revButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(revEditText.getText().toString())) {
                    revTextView.setText(revString(revEditText.getText().toString()));
                } else {
                    revTextView.setText("Please enter a word to reverse!");
                }
                hideKeyboard(v);
            }
        });

    }


    public static String isPalindromic(String string) {
        String palinWord = string.toLowerCase();
        for (int i = 0, j = palinWord.length() -1; i < j; ++i, --j) {
            if (palinWord.charAt(i) != palinWord.charAt(j)) {
                return "False: " + string + " is not Palindrome";
            }
        }
        return "True: " + string + " is Palindromic";
    }

    public static String dryFizzBuzz(String number) {
        int num = Integer.parseInt(number);
        if (num % 15 == 0) return num + ": FizzBuzz";
        else if (num % 3 == 0) return num + ": Fizz";
        else if (num % 5 == 0) return num + ": Buzz";
        else return num + " is just is number. -_-";
    }

    public static String revString(String string) {
        StringBuilder sb = new StringBuilder(string).reverse();
        String revLowerCase = sb.toString().toLowerCase();
        StringBuilder result = new StringBuilder();
        for (String str: revLowerCase.split(" ")) {
            String rev = str;
            rev = Character.toUpperCase(rev.charAt(0)) + rev.substring(1);
            result.append(rev).append(" ");
        }
        return result.toString();
    }

    public void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}