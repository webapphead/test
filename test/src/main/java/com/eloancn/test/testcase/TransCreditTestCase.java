package com.eloancn.test.testcase;

import com.eloancn.framework.sevice.api.ResultDTO;
import com.eloancn.test.util.DubboInit;
import com.eloancn.transloan.api.ITransCreditNewSanBServiceApi;
import com.eloancn.transloan.dto.*;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 债权转让功能测试
 * Created by eloancn on 2018/6/5.
 */
public class TransCreditTestCase {
    private ITransCreditNewSanBServiceApi transCreditNewSanBServiceApi;
    private PageNationDTO<NewTransCreditDetailDto> data;

    @BeforeSuite
    public void init(){
        DubboInit init = DubboInit.getInstance();
        init.initApplicationContext();
        transCreditNewSanBServiceApi = (ITransCreditNewSanBServiceApi)init.getBean("transCreditNewSanBServiceApi");
    }


    @Test(dataProvider="transcreditParam")
    public void testTransCreditList(TransCreditListQueryDTO transCreditListQueryDTO) throws Exception {
        ResultDTO<PageNationDTO<NewTransCreditDetailDto>> resultDTO = transCreditNewSanBServiceApi.searchTransferList(transCreditListQueryDTO);
        if(null == resultDTO || null == resultDTO.getData()){
            throw new Exception("resultDTO or getData is null");
        }else{
            PageNationDTO<NewTransCreditDetailDto> returnData = resultDTO.getData();
            System.out.println(returnData.getTotalCount());
            data = returnData;
        }
    }

    @Test(dataProvider="transcreditParam")
    public void testTransCreditZmkhList(TransCreditListQueryDTO transCreditListQueryDTO) throws Exception {
        ResultDTO<PageNationDTO<NewTransCreditDetailDto>> resultDTO = transCreditNewSanBServiceApi.searchZmkhTransferList(transCreditListQueryDTO);
        if(null == resultDTO || null == resultDTO.getData()){
            throw new Exception("resultDTO or getData is null");
        }else{
            PageNationDTO<NewTransCreditDetailDto> returnData = resultDTO.getData();
            System.out.println(returnData.getTotalCount());
            data = returnData;
        }
    }

    @Test(dependsOnMethods = {"testTransCreditList"})
    public void testTransCreditTrack() throws Exception{
        if(null == data || null == data.getData()){
            throw new Exception("data is null");
        }
        List<NewTransCreditDetailDto> dataList = data.getData();
        if(dataList.size()<0){
            throw new Exception("dataList is null");
        }
        for (NewTransCreditDetailDto detailDto : dataList){
            List<NewTransCreditTrackDto> trackList = new ArrayList<NewTransCreditTrackDto>();
            NewTransCreditTrackDto transCreditTrackDto = new NewTransCreditTrackDto();
            transCreditTrackDto.setInUserId(1);
            transCreditTrackDto.setOldUserId(1);
            transCreditTrackDto.setTransCreditId(detailDto.getTransCreditId());
            transCreditTrackDto.setUserDevice(5);
            transCreditTrackDto.setInAccountId("I00000000001");
            trackList.add(transCreditTrackDto);
            ResultDTO<List<NewTransCreditTrackResultDTO>> resultDTO = this.transCreditNewSanBServiceApi.addTransCreditTrack(trackList);
            Assert.assertNotNull(resultDTO);
            Assert.assertNotNull(resultDTO.getData());
            Assert.assertEquals(resultDTO.getStatus(),0);

        }
    }


    @Test
    public void addTransCreditTrackTest() throws Exception{

        List<NewTransCreditTrackDto> trackList = new ArrayList<NewTransCreditTrackDto>();
        NewTransCreditTrackDto transCreditTrackDto = new NewTransCreditTrackDto();
        transCreditTrackDto.setInUserId(1);
        transCreditTrackDto.setOldUserId(1);
        transCreditTrackDto.setTransCreditId(7009261);
        transCreditTrackDto.setUserDevice(5);
        transCreditTrackDto.setInAccountId("I00000000001");
        trackList.add(transCreditTrackDto);
        ResultDTO<List<NewTransCreditTrackResultDTO>> resultDTO = this.transCreditNewSanBServiceApi.addTransCreditTrack(trackList);
        Assert.assertNotNull(resultDTO);
        Assert.assertNotNull(resultDTO.getData());
        System.out.println(resultDTO.getMessage());
        Assert.assertEquals(resultDTO.getStatus(),0);

    }


    @DataProvider(name = "transcreditParam")
    public Object[][] getParam(){
        TransCreditListQueryDTO transCreditListQueryDTO = new TransCreditListQueryDTO();
       /* List<QueryConditionDTO> amountList = new ArrayList<QueryConditionDTO>();
        QueryConditionDTO queryConditionDTO = new QueryConditionDTO();
        queryConditionDTO.setTransferAmountFrom(0D);
        queryConditionDTO.setTransferAmountTo(100D);
        amountList.add(queryConditionDTO);
        transCreditListQueryDTO.setTransferAmount(amountList);*/
        transCreditListQueryDTO.setTransferAmount(null);
        transCreditListQueryDTO.setType(2);
        transCreditListQueryDTO.setLeftDays(null);
        transCreditListQueryDTO.setPageSize(10);
        transCreditListQueryDTO.setCurrentPage(1);
        //transCreditListQueryDTO.setDir();
        //transCreditListQueryDTO.setOldUserId();
        transCreditListQueryDTO.setDisCountCondition(null);
        transCreditListQueryDTO.setRepaymentWay(null);
     // transCreditListQueryDTO.setUserId();
        return new Object[][]{{transCreditListQueryDTO}};
    }

}
