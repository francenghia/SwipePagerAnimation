package com.example.franc.swipepager.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franc.swipepager.Model.Singer;
import com.example.franc.swipepager.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends PagerAdapter {
    private Context context;
    private List<Singer> singers;

    public Adapter(Context context, List<Singer> singers) {
        this.context = context;
        this.singers = singers;
    }

    @Override
    public int getCount() {
        return singers.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, container, false);

        ImageView image = view.findViewById(R.id.image);
        TextView txtTitle = view.findViewById(R.id.title);
        TextView txtDesciption = view.findViewById(R.id.description);

        image.setImageResource(singers.get(position).getImage());
        txtTitle.setText(singers.get(position).getTitle());
        txtDesciption.setText(singers.get(position).getDescription());

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
