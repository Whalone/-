package com.fangxiaofeng.passbook.service;

import com.alibaba.fastjson.JSON;
import com.fangxiaofeng.passbook.vo.CreateMerchantsRequest;
import com.fangxiaofeng.passbook.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 商户服务测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServTest {

    @Autowired
    private IMerchantsServ merchantsServ;

    /* 添加transaction会执行事务管理 对test函数里面的操作进行回滚*/
    @Test
    //@Transactional
    public void testCreateMerchantsServ() {

        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("test");
        request.setLogoUrl("test");
        request.setBusinessLicenseUrl("test");
        request.setPhone("test");
        request.setAddress("test");

        System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
    }

    @Test
    public void testBuildMerchantsInfoById() {

        System.out.println(JSON.toJSONString(merchantsServ.buildMerchantsInfoById(2)));
    }

    /**
     * DropPassTemplate:{"background":2,"desc":"test","end":1567345865698,
     * "hasToken":false,"id":2,"limit":10000,
     * "start":1566481865698,"summary":"test","title":"test"}
     */
    @Test
    public void testDropPassTemplate() {
        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(2);
        passTemplate.setTitle("test");
        passTemplate.setSummary("test");
        passTemplate.setDesc("test");
        passTemplate.setLimit(10000L);
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStart(new Date());
        passTemplate.setEnd(DateUtils.addDays(new Date(), 10));

        System.out.println(JSON.toJSONString(
                merchantsServ.dropPassTemplate(passTemplate)
        ));
    }
}
