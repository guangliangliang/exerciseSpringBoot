package com.testkshdata.dci.testdata.service;

import com.testkshdata.dci.testdata.pojo.MainLayers;


public interface MainLayerService {


     MainLayers getOneMainLayers(Integer layerId);

     Integer addMainLayerDatas(MainLayers MainLayers);

     Integer deleteMainLayerDatas(Integer layerId);

     Integer updateMainLayerDatas(MainLayers MainLayers);

}
