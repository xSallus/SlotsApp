package com.example.slotsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {

    ImageView slot_0;
    ImageView slot_1;
    ImageView slot_2;
    TextView credits;
    Button go_btn;
    Integer draw;
    Random rnd;
    int c;
    int d;
    int e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        credits = findViewById(R.id.credits);
        draw = 1000;
        credits.setText(draw.toString());
        go_btn = findViewById(R.id.goButton);
        slot_0 = findViewById(R.id.slot0);
        slot_1 = findViewById(R.id.slot1);
        slot_2 = findViewById(R.id.slot2);
        rnd = new Random();

        go_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = rnd.nextInt(3);
                d = rnd.nextInt(3);
                e = rnd.nextInt(3);

                slot_0.setBackgroundResource(getResources().getIdentifier(slotDraw(c), "drawable", getPackageName()));
                slot_1.setBackgroundResource(getResources().getIdentifier(slotDraw(d), "drawable", getPackageName()));
                slot_2.setBackgroundResource(getResources().getIdentifier(slotDraw(e), "drawable", getPackageName()));

                if(c==d && d==e) {
                    draw += 10;
                    credits.setText(draw.toString());
                } else if(c==d || c == e || d==e) {
                    draw += 5;
                    credits.setText(draw.toString());
                }  else {
                    draw -= 10;
                    credits.setText(draw.toString());
                }
            }
        });
    }

    public static String slotDraw(int x) {
        String validate = null;
        switch (x) {
            case 0:
                validate = "apple_3x";
                break;
            case 1:
                validate = "cherry_3x";
                break;
            case 2:
                validate = "star_3x";
                break;
        }
        return validate;
    }
}
