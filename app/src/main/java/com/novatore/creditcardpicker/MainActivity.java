package com.novatore.creditcardpicker;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity  {

    private EditText editCardNumber;
    private TextView cardInfo;
    private ImageView cardImage;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            getSupportActionBar().hide();
        }catch (Exception e){

        }

        setScreenViews();


    }

    private void setScreenViews() {



        editCardNumber=(EditText)findViewById(R.id.get_card);
        cardImage=(ImageView)findViewById(R.id.card_image);

        cardInfo=(TextView)findViewById(R.id.textViewCardInfo);
        Typeface typ2 = Typeface.createFromAsset(getAssets(), "fonts/proximanova-regular.ttf");
        Typeface light = Typeface.createFromAsset(getAssets(), "fonts/ProximaNova-Light.ttf");
        cardInfo.setTypeface(typ2);

        editCardNumber.setTypeface(light);
        editCardNumber.addTextChangedListener(cardWatcher);

    }




    private TextWatcher cardWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String working = s.toString();
            chnageImage(working);
            boolean isValid = true;
            if (working.length()==4 && before == 0) {
                working+=" ";
                editCardNumber.setText(working);
                editCardNumber.setSelection(working.length());
            }
            else if (working.length()==9 && before ==0) {
                working+=" ";
                editCardNumber.setText(working);
                editCardNumber.setSelection(working.length());
            }
            else if (working.length()==14 && before ==0) {
                working+=" ";
                editCardNumber.setText(working);
                editCardNumber.setSelection(working.length());
            }

            else if (working.length()==0 && before==0){
                cardImage.setImageResource(R.drawable.add_card_placeholder);
            }
            else if (working.equalsIgnoreCase("")){
                cardImage.setImageResource(R.drawable.add_card_placeholder);
            }


        }

        @Override
        public void afterTextChanged(Editable s) {

            //String cardNumber=s.toString();

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    };
    private void chnageImage(String cardNumber){

        if (cardNumber.startsWith("4")){

            cardImage.setImageResource(R.drawable.visatwo);
        }
        else if (cardNumber.startsWith("5")){
            cardImage.setImageResource(R.drawable.mastercardtwo);
        }

        else if (cardNumber.startsWith("3")){
            cardImage.setImageResource(R.drawable.amextwo);
        }

        if (cardNumber.startsWith("1")){
            cardImage.setImageResource(R.drawable.add_card_placeholder);
        }


    }


    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }





















}

