package com.testkshdata.dci.testdata.service.serviceImpl;

import com.testkshdata.dci.testdata.mapper.MainLayersMapper;
import com.testkshdata.dci.testdata.pojo.MainLayers;
import com.testkshdata.dci.testdata.service.MainLayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainLayerServiceImpl implements MainLayerService {

    @Autowired
    private MainLayersMapper mainLayersMapper;




    @Override
    public MainLayers getOneMainLayers(Integer layerId) {
        System.out.println(mainLayersMapper.selectByPrimaryKey(layerId));
        return  mainLayersMapper.selectByPrimaryKey(layerId);
    }

    @Override
    public Integer addMainLayerDatas(MainLayers MainLayers) {
        return mainLayersMapper.insert(MainLayers);
    }

    @Override
    public Integer deleteMainLayerDatas(Integer layerId) {
        return mainLayersMapper.deleteByPrimaryKey(layerId);
    }

    @Override
    public Integer updateMainLayerDatas(MainLayers MainLayers) {
        return mainLayersMapper.updateByPrimaryKey(MainLayers);
    }
}
