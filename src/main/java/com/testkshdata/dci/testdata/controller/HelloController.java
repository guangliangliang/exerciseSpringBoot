package com.testkshdata.dci.testdata.controller;


import com.jayway.jsonpath.JsonPath;
import com.testkshdata.dci.testdata.pojo.MainLayers;
import com.testkshdata.dci.testdata.service.HelloService;
import com.testkshdata.dci.testdata.service.MainLayerService;
import com.testkshdata.dci.testdata.util.RedisClient;
import com.testkshdata.dci.testdata.util.RedisDataTimeActive;
import com.testkshdata.dci.testdata.util.ResultVo;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    @Value("classpath:static/data/mapTestData.json")
    private Resource mapTestData;
    @Value("classpath:static/data/chartTestData.json")
    private Resource chartTestData;
    @Autowired
    private HelloService helloService;
    @Autowired
    private MainLayerService mainLayerService;
    @Autowired
    private RedisClient redisClinet;

    @RequestMapping("/add")
    public String add(){
        redisClinet.add("internetVo",this.getObjectData(mapTestData).toString(),0, RedisDataTimeActive.treeListTimeActive,RedisDataTimeActive.treeListTimeUnit);
        return "add redis";
    }
    @RequestMapping("/get")
    public String get(){
        Object objTreeList= redisClinet.getDataByIndex("internetVo",0);
        return objTreeList.toString();
    }


    @RequestMapping("/mapData")
    public Object mapData(){
        Object value = this.getObjectData(chartTestData);
        return value;
    }

    public Object getObjectData(Resource JsonData){
        Object resultObj = "";
        for (int i = 1; i < 5; i ++) {
            try {
                String areaData =  IOUtils.toString(JsonData.getInputStream(), Charset.forName("UTF-8"));
                resultObj = JsonPath.read(areaData, "$");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return resultObj;
    }

    @RequestMapping("/chartData")
    public Object chartData(){
        Object value = this.getObjectData(chartTestData);
        return value;
    }


    @RequestMapping("/hellotest")
    public MainLayers hellotest(){
        System.out.println("0k");
        MainLayers data = helloService.getMainLayerAllDatas();
        return data;
    }

    @RequestMapping(value = "/geoSqlData/{sql}",method= RequestMethod.GET)
    public List<Object> geoSqlData(@PathVariable("sql")  String sql){
        return helloService.getSqlData(sql);
    }



    @RequestMapping(value = "/selectGetOneMainLayer/{layerId}",method= RequestMethod.GET)
    public ResultVo selectGetOneMainLayer(@PathVariable("layerId")  Integer layerId){
        MainLayers data = mainLayerService.getOneMainLayers(layerId);
        return ResultVo.success(data);
    }

    @PostMapping(value = "/selectPostOneMainLayer")
    @ResponseBody
    public ResultVo selectPostOneMainLayer(@RequestParam Map<String, Object> fuvalue){
        MainLayers data = mainLayerService.getOneMainLayers(Integer.parseInt((String)fuvalue.get("layerId")));
        return ResultVo.success(data);
    }

    @PostMapping("/addMainLayer")
    public Integer addMainLayer(MainLayers MainLayers){
        Integer returnIndex = mainLayerService.addMainLayerDatas(MainLayers);
        return returnIndex;
    }

    @RequestMapping("/deleteMainLayer")
    public Integer deleteMainLayer(Integer layerId){
        Integer returnIndex = mainLayerService.deleteMainLayerDatas(layerId);
        return returnIndex;
    }

    @PostMapping("/updateMainLayer")
    public Integer updateMainLayer(MainLayers MainLayers){
        Integer returnIndex = mainLayerService.updateMainLayerDatas(MainLayers);
        return returnIndex;
    }


}