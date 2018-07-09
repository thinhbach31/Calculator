package com.example.admin.calculator;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.Format;

public class Fragment_Caculator extends android.app.Fragment implements View.OnClickListener {

    private TextView mTextViewCalculate;
    private Button mButtonAC, mButtonReveal, mButtonPercent, mButtonDivide, mButton7, mButton8, mButton9,
            mButtonmultiply, mButton4, mButton5, mButton6, mButtonMinus, mButton1, mButton2, mButton3,
            mButtonPlus, mButton0, mButtonDot, mButtonEqual;

    private double mNum = 0; //the numble will be showed

    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTI = '*';
    private static final char DIV = '/';
    private static final char PERCENT = '%';
    private char mCurrentAction; //showing the last calculation


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate
                (R.layout.activity_fragment__caculator, container, false);

        mTextViewCalculate = v.findViewById(R.id.text_caculate);
        mButton0 = v.findViewById(R.id.button_0);
        mButton1 = v.findViewById(R.id.button_1);
        mButton2 = v.findViewById(R.id.button_2);
        mButton3 = v.findViewById(R.id.button_3);
        mButton4 = v.findViewById(R.id.button_4);
        mButton5 = v.findViewById(R.id.button_5);
        mButton6 = v.findViewById(R.id.button_6);
        mButton7 = v.findViewById(R.id.button_7);
        mButton8 = v.findViewById(R.id.button_8);
        mButton9 = v.findViewById(R.id.button_9);
        mButtonAC = v.findViewById(R.id.button_ac);
        mButtonDivide = v.findViewById(R.id.button_divide);
        mButtonDot = v.findViewById(R.id.button_dot);
        mButtonReveal = v.findViewById(R.id.button_reveal);
        mButtonPercent = v.findViewById(R.id.button_percent);
        mButtonmultiply = v.findViewById(R.id.button_multiply);
        mButtonMinus = v.findViewById(R.id.button_minus);
        mButtonEqual = v.findViewById(R.id.button_equal);
        mButtonPlus = v.findViewById(R.id.button_plus);

        mButton0.setOnClickListener(this);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);
        mButton7.setOnClickListener(this);
        mButton8.setOnClickListener(this);
        mButton9.setOnClickListener(this);
        mButtonAC.setOnClickListener(this);
        mButtonDivide.setOnClickListener(this);
        mButtonDot.setOnClickListener(this);
        mButtonReveal.setOnClickListener(this);
        mButtonPercent.setOnClickListener(this);
        mButtonmultiply.setOnClickListener(this);
        mButtonMinus.setOnClickListener(this);
        mButtonEqual.setOnClickListener(this);
        mButtonPlus.setOnClickListener(this);

        setHasOptionsMenu(true);

        return v;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    //menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //Clear item
            case R.id.menu_clear:
                mTextViewCalculate.setText("");
                mNum = 0;
                break;
            //Save item
            case R.id.menu_save:
                sharePreference();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void sharePreference() {
        SharedPreferences preferences = this.getActivity().getSharedPreferences("my data", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putFloat("a", (float) mNum);
        editor.commit();
    }

    //numble printing
    public void print(String mTextButton){
        mTextViewCalculate.setText
                (String.format(mTextViewCalculate.getText()+ "%s", mTextButton));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //numble button onClick
            case R.id.button_0:
                print(getString(R.string.zero));
                break;

            case R.id.button_1:
                print(getString(R.string.one));
                break;

            case R.id.button_2:
                print(getString(R.string.two));
                break;

            case R.id.button_3:
                print(getString(R.string.three));
                break;

            case R.id.button_4:
                print(getString(R.string.four));
                break;

            case R.id.button_5:
                print(getString(R.string.five));
                break;

            case R.id.button_6:
                print(getString(R.string.six));
                break;

            case R.id.button_7:
                print(getString(R.string.seven));
                break;

            case R.id.button_8:
                print(getString(R.string.eight));
                break;

            case R.id.button_9:
                print(getString(R.string.nine));
                break;

            //AC, dot, percent and reveal button
            case R.id.button_dot:
                print(getString(R.string.dot));
                break;

            case R.id.button_ac:
                mTextViewCalculate.setText("");
                mTextViewCalculate.setHint(R.string.zero);
                break;

            case R.id.button_reveal:
                mNum = Double.parseDouble
                        (mTextViewCalculate.getText().toString()); //gan gia tri tren textview cho num
                mNum = -mNum;
                mTextViewCalculate.setText
                        (String.valueOf(mNum));
                break;

            case R.id.button_percent:
                mCurrentAction = PERCENT;
                mNum = Double.parseDouble
                        (mTextViewCalculate.getText().toString()); //gan gia tri tren textview cho num
                mNum = mNum / 100;
                mTextViewCalculate.setText
                        (String.valueOf(mNum));
                break;

            //plus, minus, multi, divide and equal
            case R.id.button_plus:
                mCurrentAction = PLUS;
                print(getString(R.string.plus));
                break;

            case R.id.button_minus:
                mCurrentAction = MINUS;
                print(getString(R.string.minus));
                break;

            case R.id.button_multiply:
                mCurrentAction = MULTI;
                print(getString(R.string.multi));
                break;

            case R.id.button_divide:
                mCurrentAction = DIV;
                print(getString(R.string.divide));
                break;

            case R.id.button_equal:
                Equal();
                mTextViewCalculate.setText
                        (String.valueOf(mNum) + "");
                mNum = Double.parseDouble
                        (mTextViewCalculate.getText().toString());
                mCurrentAction = 0;
                break;
        }
    }

    private void Equal(){
        //plus
        if (mCurrentAction == PLUS) {
            String[] S = mTextViewCalculate.getText().toString().split("\\+");
            double mNumble1, mNumble2;
            mNumble1 = Double.parseDouble(S[0]);
            mNumble2 = Double.parseDouble(S[1]);
            mNum = mNumble1 + mNumble2;
        }

        //minus
        if (mCurrentAction == MINUS) {
            String A = mTextViewCalculate.getText().toString();
            if (A.startsWith("-")) {
                String[] S;
                S = A.split("-", A.indexOf("-"));
                double mNumble1 = Double.parseDouble(S[1]);
                double mNumble2 = Double.parseDouble(S[2]);
                mNum = -mNumble1 - mNumble2;
            } else {
                String[] s = mTextViewCalculate.getText().toString().split("-");
                Double mNumble1, mNumble2;
                mNumble1 = Double.parseDouble(s[0]);
                mNumble2 = Double.parseDouble(s[1]);
                mNum = mNumble1 - mNumble2;
            }
        }

        //multi
        if (mCurrentAction == MULTI) {
            String[] S = mTextViewCalculate.getText().toString().split("\\*");
            Double mNumble1, mNumble2;
            mNumble1 = Double.parseDouble(S[0]);
            mNumble2 = Double.parseDouble(S[1]);
            mNum = mNumble1 * mNumble2;
        }

        //divide
        if (mCurrentAction == DIV) {
            String[] s = mTextViewCalculate.getText().toString().split("/");
            Double mNumble1, mNumble2;
            mNumble1 = Double.parseDouble(s[0]);
            mNumble2 = Double.parseDouble(s[1]);
            mNum = mNumble1 / mNumble2;

        }
    }

}
