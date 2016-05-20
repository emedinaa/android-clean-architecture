package com.emedinaa.perutravel.data.model;

import java.util.List;

/**
 * Created by emedinaa on 16/04/16.
 */
public class PlaceResponse  extends BaseResponse{

    private int offset;
    private List<PlaceEntity> data;
    private Object nextPage;
    private int totalObjects;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public List<PlaceEntity> getData() {
        return data;
    }

    public void setData(List<PlaceEntity> data) {
        this.data = data;
    }

    public Object getNextPage() {
        return nextPage;
    }

    public void setNextPage(Object nextPage) {
        this.nextPage = nextPage;
    }

    public int getTotalObjects() {
        return totalObjects;
    }

    public void setTotalObjects(int totalObjects) {
        this.totalObjects = totalObjects;
    }
}
