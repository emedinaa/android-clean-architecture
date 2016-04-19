package com.emedinaa.perutravel.presentation.view;

import android.content.Context;
import android.os.Bundle;

import com.emedinaa.perutravel.domain.model.Place;

import java.util.List;

/**
 * Created by emedinaa on 16/04/16.
 */
public interface MainView extends BaseView {

    void showLoading();
    void hideLoading();
    void renderPlaces(List<Place> places);
    void showErrorMessage(String message);
    void gotoPlace(Bundle bundle);
}
