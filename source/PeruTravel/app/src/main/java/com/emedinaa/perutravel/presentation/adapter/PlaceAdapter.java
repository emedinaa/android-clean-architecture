package com.emedinaa.perutravel.presentation.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.emedinaa.perutravel.R;
import com.emedinaa.perutravel.domain.model.Place;
import com.emedinaa.perutravel.presentation.utils.media.ImageLoaderHelper;

import java.util.List;

/**
 * Created by emedinaa on 16/04/16.
 */
public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {
    private List<Place> places;
    private ImageLoaderHelper imageLoaderHelper;
    private int DESCLMAX=40;
    private String DEFAULTCOLOR="#585858";

    public PlaceAdapter(List<Place> places) {
        this.places = places;
        imageLoaderHelper= new ImageLoaderHelper(ImageLoaderHelper.GLIDE);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView tviNick;
        public TextView tviTitle;
        public TextView tviDesc;
        public ImageView iviPlace;

        public ViewHolder(View v) {
            super(v);
            tviNick = (TextView) v.findViewById(R.id.tviNick);
            tviTitle = (TextView) v.findViewById(R.id.tviTitle);
            tviDesc = (TextView) v.findViewById(R.id.tviDesc);
            iviPlace = (ImageView) v.findViewById(R.id.iviPlace);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_place, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Place place = places.get(position);
        if (place != null) {
            String name= (TextUtils.isEmpty(place.getTitle())?(""):(place.getTitle()));
            String desc= (TextUtils.isEmpty(place.getDesc())?(""):(place.getDesc()));
            String nick= (TextUtils.isEmpty(place.getNick())?(""):(place.getNick()));
            if(nick.length()>=0) nick= nick.substring(0,1);
            if(desc.length()>=DESCLMAX) desc= desc.substring(0,DESCLMAX)+"...";
            nick= nick.toUpperCase();

            String path= place.getPhoto();
            int headerColor=Color.parseColor(place.getHeaderColor()!=null?(place.getHeaderColor()):(DEFAULTCOLOR));
            holder.tviTitle.setText(name);
            holder.tviDesc.setText(desc);
            holder.tviNick.setText(nick);
            holder.tviNick.setBackgroundColor(headerColor);
            imageLoaderHelper.getLoader().load(path,holder.iviPlace);
        }
    }

    @Override
    public int getItemCount() {
        return places.size();
    }
}
