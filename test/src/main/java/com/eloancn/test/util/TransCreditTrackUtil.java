package com.eloancn.test.util;

import com.eloancn.framework.sevice.api.ResultDTO;
import com.eloancn.transloan.api.ITransCreditNewSanBServiceApi;
import com.eloancn.transloan.dto.NewTransCreditTrackDto;
import com.eloancn.transloan.dto.NewTransCreditTrackResultDTO;
import com.google.gson.Gson;
import org.apache.commons.lang.ObjectUtils;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eloancn on 2018/4/3.
 */
public class TransCreditTrackUtil extends AbstractJavaSamplerClient {
    @Autowired
    private ITransCreditNewSanBServiceApi transCreditNewSanBServiceApi;

    public void setupTest(JavaSamplerContext javaSamplerContext){
        DubboInit init = DubboInit.getInstance();
        init.initApplicationContext();
        transCreditNewSanBServiceApi = (ITransCreditNewSanBServiceApi)init.getBean("transCreditNewSanBServiceApi");
    }


    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        SampleResult sampleResult = new SampleResult();
        try {
            String param = javaSamplerContext.getParameter("newTransCreditTrackDto");
            System.out.println(param);
            if(null == param){
                System.out.println("so sorry");
                sampleResult.setResponseMessage("param is null");
                sampleResult.setSuccessful(true);
                return sampleResult;
            }
            Gson gson = new Gson();
            NewTransCreditTrackDto newTransCreditTrackDto = gson.fromJson(param,NewTransCreditTrackDto.class);
            List<NewTransCreditTrackDto> list = new ArrayList<NewTransCreditTrackDto>();
            list.add(newTransCreditTrackDto);
            ResultDTO<List<NewTransCreditTrackResultDTO>> resultDTO = this.transCreditNewSanBServiceApi.addTransCreditTrack(list);
            if(resultDTO.getStatus() == 0){
                System.out.println("so good");
                sampleResult.setResponseMessage("addTransCreditTrack success");
                sampleResult.setSuccessful(true);
                sampleResult.setResponseData(gson.toJson(resultDTO),null);
                sampleResult.setDataType(SampleResult.TEXT);
            }else {
                System.out.println("so sorry");
                sampleResult.setResponseMessage("addTransCreditTrack fail" + resultDTO.getMessage());
                sampleResult.setResponseData(gson.toJson(resultDTO),null);
                sampleResult.setSuccessful(true);
            }

        }catch (Exception e){
            e.printStackTrace();
            sampleResult.setResponseMessage("addTransCreditTrackexception");
            sampleResult.setSuccessful(true);
        }catch (Throwable e){
            System.out.println(e.getMessage());
            sampleResult.setResponseMessage("addTransCreditTrack error");
            sampleResult.setSuccessful(true);
        }

        return sampleResult;
    }
}
