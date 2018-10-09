package com.eloancn.test.util;

import com.eloancn.framework.sevice.api.ResultDTO;
import com.eloancn.transloan.api.ITransCreditNewSanBServiceApi;
import com.eloancn.transloan.dto.NewTransCreditDetailDto;
import com.eloancn.transloan.dto.PageNationDTO;
import com.eloancn.transloan.dto.TransCreditListQueryDTO;
import com.google.gson.Gson;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.report.core.JsonUtil;
import org.apache.jmeter.samplers.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.net.Proxy;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by eloancn on 2018/3/30.
 */
@Component
public class DubboUtil extends AbstractJavaSamplerClient {
    private ITransCreditNewSanBServiceApi transCreditNewSanBServiceApi;

    private String paramDtoStr = "{\"currentPage\":1,\"pageSize\":10,\"dir\":\"desc\",\"sort\":0}";

    @Override
    public void setupTest(JavaSamplerContext javaSamplerContext) {
        System.out.println("init start......");
        DubboInit init = DubboInit.getInstance();
        init.initApplicationContext();
        transCreditNewSanBServiceApi = (ITransCreditNewSanBServiceApi)init.getBean("transCreditNewSanBServiceApi");
    }

    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        SampleResult sampleResult = new SampleResult();
        Gson gson = new Gson();
        try {
            paramDtoStr = javaSamplerContext.getParameter("paramDto");
            if(null == paramDtoStr){
                System.out.println("so sorry");
                sampleResult.setResponseMessage("paramDto is null");
                sampleResult.setSuccessful(true);
                return sampleResult;
            }

            TransCreditListQueryDTO transCreditListQueryDTO = gson.fromJson(paramDtoStr,TransCreditListQueryDTO.class);
            System.out.println(transCreditNewSanBServiceApi);
            ResultDTO<PageNationDTO<NewTransCreditDetailDto>> resultDTO = transCreditNewSanBServiceApi.searchZmkhTransferList(transCreditListQueryDTO);
            if(resultDTO.getStatus() == 0){
                System.out.println("so good");
                sampleResult.setResponseMessage("get data success");
                sampleResult.setSuccessful(true);
                sampleResult.setResponseData(gson.toJson(resultDTO),null);
                sampleResult.setDataType(SampleResult.TEXT);
            }else {
                System.out.println("so sorry");
                sampleResult.setResponseMessage("get data error" + resultDTO.getMessage());
                sampleResult.setResponseData(gson.toJson(resultDTO),null);
                sampleResult.setSuccessful(true);
            }
        }catch (Exception e){
            e.printStackTrace();
            sampleResult.setResponseMessage("get data exception");
            sampleResult.setSuccessful(true);
        }catch (Throwable e){
            System.out.println(e.getMessage());
            sampleResult.setResponseMessage("get data error");
            sampleResult.setSuccessful(true);
        }

        return sampleResult;
    }

    public static void main(String[] args) throws Exception{
        String interfaceName = "com.eloancn.transloan.api.ITransCreditNewSanBServiceApi";
        String method = "searchZmkhTransferList";
        String[] paramTypes = {"com.eloancn.transloan.dto.TransCreditListQueryDTO"};
        String paramStr = "{\"currentPage\":1,\"pageSize\":10,\"dir\":\"desc\",\"sort\":0}";

        Object[] object = new Object[paramTypes.length];
        for (int i=0;i<paramTypes.length;i++ ){
            Class cl = Class.forName(paramTypes[i]);
            Gson gson = new Gson();
            object[i] =  gson.fromJson(paramStr,cl);
        }

        DubboConfig dubboConfig = new DubboConfig();
        Object retuenObject = dubboConfig.invoke(interfaceName,paramTypes,object,method);
        System.out.println(retuenObject);

    }

}
