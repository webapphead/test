package com.eloancn.test.util;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.container.Main;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.eloancn.test.model.ApplicationParam;
import com.eloancn.test.model.MonitorParam;
import com.eloancn.test.model.ProtocolParam;
import com.eloancn.test.model.RegistryParam;
import com.eloancn.transloan.dto.TransCreditListQueryDTO;
import com.google.gson.Gson;

/**
 * Created by eloancn on 2018/5/29.
 */
public class DubboConfig {
    // 当前应用的信息

    public static ApplicationConfig getApplication(ApplicationParam applicationParam){
        ApplicationConfig application = new ApplicationConfig();
        application.setName(applicationParam.getName());
        application.setOwner(applicationParam.getOwner());
        application.setOrganization(applicationParam.getOrganization());
        return application;
    }

    public static RegistryConfig getRegister(RegistryParam registryParam){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol(registryParam.getProtocol());
        registryConfig.setAddress(registryParam.getAddress());
        registryConfig.setId(registryParam.getId());
        registryConfig.setTimeout(registryParam.getTimeout());

        return registryConfig;

    }

    public static ProtocolConfig getProtocol(ProtocolParam protocolParam){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(protocolParam.getName());
        protocolConfig.setPort(protocolParam.getPort());

        protocolConfig.setId(protocolParam.getId());
        return protocolConfig;
    }

    public static MonitorConfig monitor(MonitorParam monitorParam){
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol(monitorParam.getProtocol());
        monitorConfig.setAddress(monitorParam.getAddress());
        monitorConfig.setGroup(monitorConfig.getGroup());
        monitorConfig.setUsername(monitorParam.getUsername());
        monitorConfig.setPassword(monitorParam.getPassword());
        monitorConfig.setVersion(monitorParam.getVersion());
        return  monitorConfig;
    }


     /**
       * 获取服务的代理对象
       * @return
       */
    private static ReferenceConfig<GenericService> getReferenceConfig(String interfaceName) throws Exception {
        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<GenericService>();
        ApplicationParam applicationParam = getApplicationParam();

        RegistryParam registryParam = getRegistryParam();

        referenceConfig.setApplication(getApplication(applicationParam));
        referenceConfig.setRegistry(getRegister(registryParam));
        Class cl = Class.forName(interfaceName);
        referenceConfig.setInterface(cl);
        referenceConfig.setVersion("1.1.0");
        referenceConfig.setGroup("trans-soa");
        referenceConfig.setRetries(0);
        referenceConfig.setGeneric(true);
        /*referenceConfig.setProtocol();
        referenceConfig.setMonitor();*/
        referenceConfig.setValidation("false");

        return referenceConfig;
    }

    public static ApplicationParam getApplicationParam(){
        ApplicationParam applicationParam = new ApplicationParam();
        applicationParam.setName("transloan-provider");
        applicationParam.setOrganization("dubbox");
        applicationParam.setOwner("transloan");
        return applicationParam;
    }

    public static RegistryParam getRegistryParam(){
        RegistryParam registryParam = new RegistryParam();
        registryParam.setProtocol("zookeeper");
        registryParam.setAddress("192.168.0.79:2181");
        registryParam.setId("elZookeeper_trans");
        registryParam.setTimeout(15000);
        return  registryParam;
    }

    public Object invoke(String interfaceName,String[] paramType,Object[] paramValue,String method) throws Exception{
        ReferenceConfig<GenericService> referenceConfig = getReferenceConfig(interfaceName);
        if(null != referenceConfig){
            System.out.println(referenceConfig.get());
            GenericService service = referenceConfig.get();
            Object object = service.$invoke(method,paramType,paramValue);
            return object;
        }
        return null;
    }

    public static void main(String[] args) {
       /* DubboConfig dubboConfig = new DubboConfig();
        String interfaceName = "com.eloancn.transloan.api.ITransCreditNewSanBServiceApi";
        String[] paramType = {"com.eloancn.transloan.dto.TransCreditListQueryDTO"};
        TransCreditListQueryDTO transCreditListQueryDTO = new TransCreditListQueryDTO();
        Object[] paramValue = {transCreditListQueryDTO};
        String method = "";

        dubboConfig.invoke(interfaceName,paramType,paramValue,method);*/
        TransCreditListQueryDTO transCreditListQueryDTO = new TransCreditListQueryDTO();
        Gson gson = new Gson();
        String tojson =  gson.toJson(transCreditListQueryDTO);
        System.out.println(tojson);
    }


}
