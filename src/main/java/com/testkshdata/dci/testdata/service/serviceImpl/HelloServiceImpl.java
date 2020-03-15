package com.testkshdata.dci.testdata.service.serviceImpl;

import com.testkshdata.dci.testdata.mapper.MainLayersMapper;
import com.testkshdata.dci.testdata.pojo.MainLayers;
import com.testkshdata.dci.testdata.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private MainLayersMapper mainLayersMapper;

    @Override
    public MainLayers getMainLayerAllDatas() {
        MainLayers MainLayersObj = mainLayersMapper.selectByPrimaryKey(1);
        System.out.println(MainLayersObj);
        Object s = MainLayersObj;
       String a = "a";
       String b = "test";
       String result = a+b;
        return MainLayersObj;
    }
}
