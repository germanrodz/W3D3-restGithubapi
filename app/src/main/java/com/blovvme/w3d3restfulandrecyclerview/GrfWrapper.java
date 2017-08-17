package com.blovvme.w3d3restfulandrecyclerview;

import com.blovvme.w3d3restfulandrecyclerview.model.Grf;

import java.util.List;

/**
 * Created by Blovvme on 8/16/17.
 */

public class GrfWrapper {

    private List<Grf> grf;

    public List<Grf> getGrfList(){
        return grf;
    }

    public void setGrfList(List<Grf> grfList) {
        this.grf = grfList;
    }

}
