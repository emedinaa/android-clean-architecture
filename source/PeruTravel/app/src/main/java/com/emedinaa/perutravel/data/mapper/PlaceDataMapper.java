package com.emedinaa.perutravel.data.mapper;

import com.emedinaa.perutravel.data.model.PlaceEntity;
import com.emedinaa.perutravel.data.model.PlaceResponse;
import com.emedinaa.perutravel.domain.model.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emedinaa on 16/04/16.
 */
public class PlaceDataMapper {

    public Place transform(PlaceEntity placeEntity)
    {
        Place place= new Place();
        if(placeEntity==null)return place;
        place.setId(placeEntity.getObjectId());
        place.setTitle(placeEntity.getTitle() != null ? placeEntity.getTitle() : "");
        place.setDesc(placeEntity.getDesc() != null ? placeEntity.getDesc() : "");
        place.setNick(placeEntity.getCity()!=null?placeEntity.getCity():"");
        place.setHeaderColor(placeEntity.getColor());
        place.setPhoto(placeEntity.getPhoto());
        return place;
    }
    public List<Place> transformResponse(PlaceResponse placeResponse)
    {
        List<Place> places= new ArrayList<>();
        if(placeResponse==null)return  places;
        for (PlaceEntity placeEntity:placeResponse.getData()) {
            places.add(transform(placeEntity));
        }
        return places;
    }
}
