package com.testkshdata.dci.testdata.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CodeMsg {



    private int code;
    private String msg;

    //通用
    public static CodeMsg ERROR = new CodeMsg(500,"数据有误");
    public static CodeMsg SHUJU_MEIYOU = new CodeMsg(501,"根据id查询右侧数据查询不存在");
    public static  CodeMsg GONGSI_SHUJU_BUCUNZAI = new CodeMsg(502,"查询公司的数据不存在") ;
    public static  CodeMsg GONGSI_xq_BUCUNZAI = new CodeMsg(503,"根据区域查询详情信息不存在");

    public static  CodeMsg QHYJZJDATE = new CodeMsg(505,"区划统计中间表没有匹配字段");
    public static  CodeMsg HQDW_JKSHUJU_NOT =new CodeMsg(506,"获取对外接口的数据不存在");
    public static  CodeMsg SHCABZQ = new CodeMsg(507,"这个值不能为空");
    public static  CodeMsg meiy = new CodeMsg(507,"没有查到数据");

    public static  CodeMsg meiyou = new CodeMsg(507,"接口没有查到数据");


}
