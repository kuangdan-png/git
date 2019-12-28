package com.medicine.factory;

import java.util.LinkedHashMap;

/**
 * @Auther: 刘涵
 * @Date: 2019-12-03 14:38
 * @Description:获得页面权限
 */
public class FilterChainDefinitionsBuilder {
   public LinkedHashMap<String,String> builderFilterChainDefinitions(){
        LinkedHashMap<String,String> map=new LinkedHashMap<String, String>();
        //获得页面权限
        map.put("/login.html","anon");
       map.put("/login.html","logout ");
       map.put("**","authc ");
        return map;
    }
}
