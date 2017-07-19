package com.dakshsharma.palindromic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
                String word = editText.getText().toString();
                tv.setText(isPalindromic(word));
            }
        });
    }


    public String isPalindromic(String string) {
        for (int i = 0, j = string.length() -1; i < j; ++i, --j) {
            if (string.charAt(i) != string.charAt(j)) {
                return "False: " + string + " is not Palindrome";
            }
        }
        return "True: " + string + " is Palindromic";
    }
}