package com.emedinaa.perutravel.presentation.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.emedinaa.perutravel.R;
import com.emedinaa.perutravel.domain.model.Place;
import com.emedinaa.perutravel.presentation.utils.media.ImageLoaderHelper;

import butterknife.Bind;

public class PlaceActivity extends BaseActivity {

    @Bind(R.id.toolbar)Toolbar toolbar;
    @Bind(R.id.iviPlace)ImageView iviPlace;
    @Bind(R.id.tviTitle)TextView tviTitle;
    @Bind(R.id.tviDesc)TextView tviDesc;

    private Place place;
    private ImageLoaderHelper imageLoaderHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        extras();
        injectView();
        ui();
        populate();
    }

    private void ui() {

        setSupportActionBar(toolbar);
        toolbar.setContentInsetsAbsolute(0, 0);

        //events
        toolbar.findViewById(R.id.iviBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeApp();
            }
        });

        imageLoaderHelper= new ImageLoaderHelper(ImageLoaderHelper.GLIDE);
    }

    private void closeApp() {
        finish();
    }

    private void populate() {
        if(place!=null)
        {
            int color= place!=null?(Color.parseColor(place.getHeaderColor())):(R.color.white);
            toolbar.setBackgroundColor(color);
            ((TextView)(toolbar.findViewById(R.id.tviToolbar))).setText(place.getNick());

            tviTitle.setText(place.getTitle());
            tviDesc.setText(place.getDesc());
            imageLoaderHelper.getLoader().load(place.getPhoto(),iviPlace);
        }
    }

    private void extras() {
        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                place = (Place) bundle.getSerializable("PLACE");
            }
        }
    }

}
