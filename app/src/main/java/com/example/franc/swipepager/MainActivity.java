package com.example.franc.swipepager;

import android.animation.ArgbEvaluator;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.franc.swipepager.Adapter.Adapter;
import com.example.franc.swipepager.Model.Singer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Singer> singers;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singers = new ArrayList<>();
        singers.add(new Singer(R.drawable.image, "Hoang Yen chibi", "Hôm này trời đẹp"));
        singers.add(new Singer(R.drawable.beerpassaranan, "Beer Passaranan", "Hôm này trời đẹp"));
        singers.add(new Singer(R.drawable.jangmi, "Jang Mi", "Hôm này trời đẹp"));
        singers.add(new Singer(R.drawable.phungdemac, "Phụng Đề Mạc", "Hôm này trời đẹp"));

        adapter = new Adapter(this, singers);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(80, 0, 80, 0);

        Integer[] color_temp = {getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)};

        colors = color_temp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                } else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
