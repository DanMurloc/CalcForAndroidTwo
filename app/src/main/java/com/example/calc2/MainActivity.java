package com.example.calc2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    String count1="";
    String count2="";
    String oper = "";
    boolean operator = false;
    boolean virag = false;
    public  void onClick(View view){
        // Преобразуем переданный View в Button
        TextView screen = findViewById(R.id.editText);
        Button button = (Button) view;
        if (operator==false)
            nonOperator(button,screen);
        else
            yesOperator(button,screen);


    }

    public void nonOperator(Button button, TextView screen ){
        int id =button.getId();
        if (id == R.id.num0) {
            count1 += "0";
        } else if (id == R.id.num1) {
            count1 += "1";
        }else if (id == R.id.num2) {
            count1 += "2";
        } else if (id == R.id.num3) {
            count1 += "3";
        }else if (id == R.id.num4) {
            count1 += "4";
        }else if (id == R.id.num5) {
            count1 += "5";
        }else if (id == R.id.num6) {
            count1 += "6";
        }else if (id == R.id.num7) {
            count1 += "7";
        }else if (id == R.id.num8) {
            count1 += "8";
        }
        else if (id == R.id.num9) {
            count1 += "9";
        }

        screen.setText(count1);
        if (id == R.id.numac) {
            sbros(screen);

        } else if (id == R.id.nummin) {
            oper = "-";
            operator = true;
        }
        else if (id == R.id.numplus) {
            oper = "-";
            operator = true;
        }
        else if (id == R.id.numdel) {
            oper = "/";
            operator = true;
        }
        else if (id == R.id.numpmult) {
            oper = "*";
            operator = true;
        }
    }
    public void sbros(TextView screen){
        count1 = "";
        count2 = "";
        oper = " ";
        operator=false;
        screen.setText("0");
    }
    public void yesOperator(Button button, TextView screen){
        int id =button.getId();
        screen.setText(count1);
        if (id == R.id.numac) {
            sbros(screen);

        }
    }

}