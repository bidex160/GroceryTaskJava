package com.example.javahngtask3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class SecondActivity extends AppCompatActivity {

TextView txt1, txt2, txt3, txt4, tot;

    String name, price, qt, subtotal, Total;
  //  int;
    Button btshare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
        try {
            Intent intent = getIntent();
             name = intent.getStringExtra("name");
            price = intent.getStringExtra("price");
           qt = intent.getStringExtra("qt");
           subtotal = intent.getStringExtra("total");
           Total = intent.getStringExtra("Total");




        }catch (Exception e){
            Log.e(TAG, "onCreate: " + e );
        }
        txt1.setText(name);
        txt2.setText(price);
        txt3.setText(qt);
        txt4.setText(subtotal);
        tot.setText(Total);
        btshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: " );


                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:bidex890@gmail.com" ));
                intent.putExtra(Intent.EXTRA_SUBJECT, "My grocery List");
                intent.putExtra(Intent.EXTRA_TEXT, name +"\t" + price + "\t" + qt);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }


            }
        });

    }

    private void init() {
        txt1 = findViewById(R.id.textView);
        txt2 = findViewById(R.id.textView2);
        txt3 = findViewById(R.id.textView3);
        txt4 = findViewById(R.id.textView4);
        tot = findViewById(R.id.to);
        btshare = findViewById(R.id.sharbt);

    }



}
