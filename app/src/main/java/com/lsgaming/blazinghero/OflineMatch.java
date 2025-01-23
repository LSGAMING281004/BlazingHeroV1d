package com.lsgaming.blazinghero;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class OflineMatch extends AppCompatActivity {

    View blueview1;
    TextView brand,rrand;
    ImageView bh1,bh2,bh3,rh2,rh3,rh1;
    ImageView body1;
    ImageView blue_book,red_book;
    boolean bg_point=true;
    int rand;
    int one=0;
    ContextThemeWrapper contextThemeWrapper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ofline_match);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RandomNum randomNum = new RandomNum();
        RelativeLayout relativeLayout = findViewById(R.id.main2);
        blueview1 = findViewById(R.id.blue1);

        bh1 = findViewById(R.id.bh1);
        rh1 = findViewById(R.id.rh1);
        bh2 = findViewById(R.id.bh2);
        bh3 = findViewById(R.id.bh3);
        rh2 = findViewById(R.id.rh2);
        rh3 = findViewById(R.id.rh3);

        body1=findViewById(R.id.body);

        brand = findViewById(R.id.brand);
        rrand = findViewById(R.id.rrand);

        blue_book = findViewById(R.id.blue_boolk);
        red_book = findViewById(R.id.red_boolk);
        relativeLayout.setBackground(getResources().getDrawable(R.drawable.box_shape));

        MediaPlayer mp = MediaPlayer.create(this,R.raw.popup);

        Random random = new Random();

        blue_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                blue_book.setVisibility(View.GONE);
                red_book.setVisibility(View.VISIBLE);
                relativeLayout.setBackground(getResources().getDrawable(R.drawable.box_shape2));
                rand = randomNum.getOddRand();
                brand.setText(String.valueOf(rand));
                setUp();

            }
        });
        red_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                red_book.setVisibility(View.GONE);
                blue_book.setVisibility(View.VISIBLE);
                relativeLayout.setBackground(getResources().getDrawable(R.drawable.box_shape));
                rand = randomNum.getEvenRand();
                rrand.setText(String.valueOf(rand));
                setUp();
            }
        });

    }


    public void setUp()
    {
        if(rand==1)
        {
            bh1.setVisibility(View.VISIBLE);

            if(one==1)
            {
                body1.setVisibility(View.VISIBLE);
            }
            one++;

        } else if (rand==2) {
            rh1.setVisibility(View.VISIBLE);
        } else if (rand==3) {
            bh2.setVisibility(View.VISIBLE);
        }else if (rand==4) {
            rh2.setVisibility(View.VISIBLE);
        }else if (rand==5) {
            bh3.setVisibility(View.VISIBLE);
        }else if (rand==6) {
            rh3.setVisibility(View.VISIBLE);
        }
    }
}