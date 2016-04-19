package com.emedinaa.perutravel.data.datasource;

import com.emedinaa.perutravel.domain.repository.RepositoryCallback;

/**
 * Created by emedinaa on 16/04/16.
 */
public interface PlaceDataSource {

    void loadPlaces(RepositoryCallback repositoryCallback);
}
