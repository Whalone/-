package com.fangxiaofeng.passbook.service;

import com.fangxiaofeng.passbook.vo.CreateMerchantsRequest;
import com.fangxiaofeng.passbook.vo.PassTemplate;
import com.fangxiaofeng.passbook.vo.Response;

/**
 * 对商户服务接口定义
 */
public interface IMerchantsServ {

    /**
     * 创建商户服务
     *
     * @param request {@link CreateMerchantsRequest} 创建商户请求
     * @return {@link Response}
     */
    Response createMerchants(CreateMerchantsRequest request);

    /**
     * 根据id构造商户信息
     *
     * @param id 商户id
     * @return {@link Response}
     */
    Response buildMerchantsInfoById(Integer id);

    /**
     * 商户投放优惠卷
     *
     * @param passTemplate {@link PassTemplate} 优惠券对象
     * @return {@link Response}
     */
    Response dropPassTemplate(PassTemplate passTemplate);
}
