/*
import com.eloancn.framework.sevice.api.PageParsDTO;
import com.eloancn.framework.sevice.api.ResultDTO;
import com.eloancn.test.util.DubboUtil;
import com.eloancn.transloan.api.ITransCreditNewSanBServiceApi;
import com.eloancn.transloan.dto.NewTransCreditDetailDto;
import com.eloancn.transloan.dto.NewTransCreditTrackDto;
import com.eloancn.transloan.dto.PageNationDTO;
import com.eloancn.transloan.dto.TransCreditListQueryDTO;
import com.google.gson.Gson;
import org.apache.jmeter.config.Argument;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.report.core.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

*/
/**
 * Created by eloancn on 2018/3/30.
 *//*

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml",
                                 "classpath:spring/applicationContext-dubbo.xml"})
public class BaseJunit4Test {
    @Autowired
    private ITransCreditNewSanBServiceApi transCreditNewSanBServiceApi;
    @Autowired
    private  DubboUtil dubboUtil;

    @Test
    public void test(){
        TransCreditListQueryDTO transCreditListQueryDTO = new TransCreditListQueryDTO();
        transCreditListQueryDTO.setType(2);
        ResultDTO<PageNationDTO<NewTransCreditDetailDto>> resultDTO = this.transCreditNewSanBServiceApi.searchZmkhTransferList(transCreditListQueryDTO);
        System.out.println(resultDTO.getData().getTotalCount());

        Gson gson = new Gson();
        System.out.println(gson.toJson(transCreditListQueryDTO));

    }
    @Test
    public void test1(){
        Argument argument = new Argument("paramDto","{\"currentPage\":1,\"pageSize\":10,\"dir\":\"desc\",\"sort\":0}");
        Arguments arguments = new Arguments();
        arguments.addArgument(argument);

        JavaSamplerContext javaSamplerContext = new JavaSamplerContext(arguments);
        dubboUtil.runTest(javaSamplerContext);

        // {"currentPage":1,"pageSize":10,"dir":"desc","sort":0}
    }
    @Test
    public void test2(){
        NewTransCreditTrackDto newTransCreditTrackDto = new NewTransCreditTrackDto();
        newTransCreditTrackDto.setUserDevice(1);
        newTransCreditTrackDto.setInAccountId("I00000000001");
        newTransCreditTrackDto.setTransCreditId(2698461);
        newTransCreditTrackDto.setOldUserId(1);
        newTransCreditTrackDto.setInUserId(1);

        Gson gson = new Gson();
        System.out.println(gson.toJson(newTransCreditTrackDto));
        //  {"userDevice":1,"inUserId":1,"inAccountId":"I00000000001","transCreditId":2698461,"oldUserId":1}
    }

    public void getDto(){
        */
/*{"userDevice":1,"inUserId":1,"inAccountId":"I00000000001","transCreditId":2698461,"oldUserId":1}
        {"userDevice":1,"inUserId":1,"inAccountId":"I00000000001","transCreditId":2698501,"oldUserId":1}
        {"userDevice":1,"inUserId":1,"inAccountId":"I00000000001","transCreditId":2702398,"oldUserId":1}
        {"userDevice":1,"inUserId":1,"inAccountId":"I00000000001","transCreditId":2702421,"oldUserId":1}
        {"userDevice":1,"inUserId":1,"inAccountId":"I00000000001","transCreditId":2702399,"oldUserId":1}
        {"userDevice":1,"inUserId":1,"inAccountId":"I00000000001","transCreditId":2703015,"oldUserId":1}
        {"userDevice":1,"inUserId":1,"inAccountId":"I00000000001","transCreditId":2703070,"oldUserId":1}
        {"userDevice":1,"inUserId":1,"inAccountId":"I00000000001","transCreditId":2703016,"oldUserId":1}
        {"userDevice":1,"inUserId":2,"inAccountId":"I00000000002","transCreditId":2703088,"oldUserId":2}
        {"userDevice":1,"inUserId":3,"inAccountId":"I00000000003","transCreditId":2698461,"oldUserId":3}
        {"userDevice":1,"inUserId":4,"inAccountId":"I00000000004","transCreditId":2698461,"oldUserId":4}
        {"userDevice":1,"inUserId":5,"inAccountId":"I00000000005","transCreditId":2698461,"oldUserId":5}
        {"userDevice":1,"inUserId":6,"inAccountId":"I00000000006","transCreditId":2698461,"oldUserId":6}
        {"userDevice":1,"inUserId":7,"inAccountId":"I00000000007","transCreditId":2698461,"oldUserId":7}
        {"userDevice":1,"inUserId":8,"inAccountId":"I00000000008","transCreditId":2698461,"oldUserId":8}
        {"userDevice":1,"inUserId":9,"inAccountId":"I00000000009","transCreditId":2698461,"oldUserId":9}
        {"userDevice":1,"inUserId":10,"inAccountId":"I00000000010","transCreditId":2698461,"oldUserId":10}
        {"userDevice":1,"inUserId":11,"inAccountId":"I00000000011","transCreditId":2698461,"oldUserId":11}
        {"userDevice":1,"inUserId":12,"inAccountId":"I00000000012","transCreditId":2698461,"oldUserId":12}
        {"userDevice":1,"inUserId":13,"inAccountId":"I00000000013","transCreditId":2698461,"oldUserId":13}
        {"userDevice":1,"inUserId":14,"inAccountId":"I00000000014","transCreditId":2698461,"oldUserId":14}
        {"userDevice":1,"inUserId":15,"inAccountId":"I00000000015","transCreditId":2698461,"oldUserId":15}
        {"userDevice":1,"inUserId":16,"inAccountId":"I00000000016","transCreditId":2698461,"oldUserId":16}
        {"userDevice":1,"inUserId":17,"inAccountId":"I00000000017","transCreditId":2698461,"oldUserId":17}
        {"userDevice":1,"inUserId":18,"inAccountId":"I00000000018","transCreditId":2698461,"oldUserId":18}
        {"userDevice":1,"inUserId":19,"inAccountId":"I00000000019","transCreditId":2698461,"oldUserId":19}
        {"userDevice":1,"inUserId":20,"inAccountId":"I00000000020","transCreditId":2698461,"oldUserId":20}
        {"userDevice":1,"inUserId":21,"inAccountId":"I00000000021","transCreditId":2698461,"oldUserId":21}
        {"userDevice":1,"inUserId":22,"inAccountId":"I00000000022","transCreditId":2698461,"oldUserId":22}
        {"userDevice":1,"inUserId":23,"inAccountId":"I00000000023","transCreditId":2698461,"oldUserId":23}*//*

    }
}


*/
