package com.testkshdata.dci.testdata.service;

import com.testkshdata.dci.testdata.pojo.MainLayers;
import java.util.List;

public interface HelloService {

    public MainLayers getMainLayerAllDatas();

    public List<Object> getSqlData(String sql);

}
