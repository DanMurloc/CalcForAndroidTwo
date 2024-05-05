package com.example.calc2;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

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

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    String count1="";
    String count2="";
    String oper = "";
    boolean scheting = false;
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
        if(scheting){

        }
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
            oper = "+";
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
        if(operator){
            screen.setText("0");
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

        if (id == R.id.num0) {
            count2 += "0";
        } else if (id == R.id.num1) {
            count2 += "1";
        }else if (id == R.id.num2) {
            count2 += "2";
        } else if (id == R.id.num3) {
            count2 += "3";
        }else if (id == R.id.num4) {
            count2 += "4";
        }else if (id == R.id.num5) {
            count2 += "5";
        }else if (id == R.id.num6) {
            count2 += "6";
        }else if (id == R.id.num7) {
            count2 += "7";
        }else if (id == R.id.num8) {
            count2 += "8";
        }
        else if (id == R.id.num9) {
            count2 += "9";
        }

        screen.setText(count2);
        if (id == R.id.numac) {
            sbros(screen);
        }
        if(id == R.id.numproc)
        {
            schet(screen);
        }
    }

    public void schet(TextView screen){

        if(count1==" "){
            count1="0";
        }
        if(count2==""){
            count2="0";
        }

        Double a = Double.valueOf(count1);
        Double b = Double.valueOf(count2);
        Double c=0.0;
        if (oper == "-") {
            c=a-b;
        }
        else if (oper == "+") {
            c=a+b;
        }
        else if (oper == "/") {
            c=a/b;
        }
        else if (oper == "*") {
            c=a*b;
        }

        count1 = "";
        count2 = "";
        oper = " ";
        operator=false;
        screen.setText(String.valueOf(c));
    }
    private InterstitialAd mInterstitialAd;
    private static final String TAG = "MainActivity";

    public void launchAbout(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
        startActivity(browserIntent);
    }


}