package com.abarnanrajkhowa.basiccalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity{
    String total = "";
    double num1,num2;
    String sign = "";
    String checker = ".0123456789";
    String checker2 ="+-/^x";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void Onclick(View v){
        Button button = (Button)v;
        String str = button.getText().toString();
        if (checker.contains( str ))
        total +=str;
        else {
            Toast toastMessage = Toast.makeText(this,"NO THERE IS SOMWETHING WRONG WITH YOUR INPUT..!!!",Toast.LENGTH_LONG);
            toastMessage.show();


        }
        EditText screen = (EditText)findViewById(R.id.editText);
        screen.setText(total);

    }
    public void onAdd(View v){
        EditText screen = null;
        Button button = (Button) v;
        String str = button.getText().toString();
        sign = str;
        if(checker2.contains(total)){
            Toast toastMessage = Toast.makeText(this,"NO THERE IS SOMWETHING WRONG WITH YOUR INPUT..!!!",Toast.LENGTH_LONG);
            toastMessage.show();


        } else {
            num1 = Double.parseDouble( total );
            total = "";
            screen = (EditText) findViewById( R.id.editText );
            screen.setText( total );
        }


        }



    public void onCalculate(View v) {
        EditText screen = (EditText)findViewById(R.id.editText);
        String str2 = screen.getText().toString();
        num2 = Double.parseDouble(str2);
        double grandTotal = 0 ;
        if(sign.equals("/")){
            grandTotal = num1/num2;
        }
        else if (sign.equals("+")){
            grandTotal = num1+num2;
        } else if(sign.equals("-")){
            grandTotal = num1 - num2;
        }else if(sign.equals("x")){
            grandTotal=num1*num2;
        } else if(sign.equals("^")){
            grandTotal= Math.pow(num1,num2);
        }else if(sign.length()>=1) {
            Toast toastMessage = Toast.makeText(this,"NO THERE IS SOMWETHING WRONG WITH YOUR INPUT..!!!",Toast.LENGTH_LONG);
            toastMessage.show();

        }
        screen.setText(grandTotal+"");
        total="";
        num1=0;
        num2=0;

    }
    public void onClear(View v){
        EditText screen = (EditText)findViewById(R.id.editText);
        screen.setText("");
        total="";
    }


}
