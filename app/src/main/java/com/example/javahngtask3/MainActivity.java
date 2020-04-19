package com.example.javahngtask3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


import static androidx.constraintlayout.widget.Constraints.TAG;
public class MainActivity extends AppCompatActivity  {
    RecyclerView recyclerView;

    TextView grocrytxt, pricetxt, Qttxt, totaltxt, to1txt, to2txt, to3txt;
    EditText e1name, e2name, e3name, eqt1, eqt2, eqt3, epric1, eprice2, eprice3, tst;

    Button vlistbt;

    int price1, price2, price3;
    int qt1 , qt2, qt3;
    int total1, total2, total3, Total;
    String  prdname1="" , prdname2="", prdname3="";

    String name, price, qt, subtotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        Log.e(TAG, "onCreate: " );

     vlistbt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

try {


    prdname1 = e1name.getText().toString();
    prdname2 = e2name.getText().toString();
    prdname3 = e3name.getText().toString();

    price1 = Integer.parseInt(String.valueOf(epric1.getText()));
    price2 = Integer.parseInt(String.valueOf(eprice2.getText()));
    price3 = Integer.parseInt(String.valueOf(eprice3.getText()));


    qt2 = Integer.parseInt(String.valueOf(eqt2.getText()));
    qt3 = Integer.parseInt(String.valueOf(eqt3.getText()));




    String qtt = eqt1.getText().toString();
    qt1 = Integer.parseInt(qtt);
    eqt1.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    });

    if (String.valueOf(qt1) != null) {
        total1 = qt1 * price1;
        Log.e(TAG, "onCreate: " + total1);

    }
    if (String.valueOf(qt2) != null) {
        total2 = qt2 * price2;
        Log.e(TAG, "onCreate: " + total2);
    }
    if (String.valueOf(qt3) != null) {
        total3 = qt3 * price3;
        Log.e(TAG, "onCreate: " + total3);
    }
    name = prdname1 + "\n" + "\n" + prdname2 + "\n" + "\n" + prdname3;
    price = price1 + "\n" + "\n" + price2 + "\n" + "\n" + price3;
    qt = qt1 + "\n" + "\n" + qt2 + "\n" + "\n" + qt3;
    subtotal = total1 + "\n" + "\n" + total2 + "\n" + "\n" + total3;
    Total = total1+ total2+ total3;
    Log.e(TAG, "onClick: " + name);
    Log.e(TAG, "onClick: " + price);
    Log.e(TAG, "onClick: " + eqt1.getText().toString());

}catch (Exception e){
    Log.e(TAG, "onClick: " + e );

}



        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("name", name );
        intent.putExtra("price", price);
        intent.putExtra("qt", qt);
        intent.putExtra("total", subtotal);
        intent.putExtra("Total", String.valueOf(Total));

        startActivity(intent);

    }
});

    }




    private void init() {
    //    itemclasses = new ArrayList<>();
        grocrytxt = findViewById(R.id.grocerytxt);
        pricetxt = findViewById(R.id.pricetxt);
      Qttxt = findViewById(R.id.qttxt);


        e1name = findViewById(R.id.editText1);
        e2name = findViewById(R.id.editText2);
        e3name = findViewById(R.id.editText3);

       epric1 = findViewById(R.id.editText4);
        eprice2= findViewById(R.id.editText5);
        eprice3 = findViewById(R.id.editText6);

        eqt1 = findViewById(R.id.editText11);
        eqt2= findViewById(R.id.editText13);
        eqt3= findViewById(R.id.editText14);


    //   addbt = findViewById(R.id.addbt);
        vlistbt = findViewById(R.id.viewlist);



    }


}
