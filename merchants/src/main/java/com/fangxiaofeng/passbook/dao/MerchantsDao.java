package com.fangxiaofeng.passbook.dao;

import com.fangxiaofeng.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

/* Merchant Dao 接口*/
public interface MerchantsDao extends JpaRepository<Merchants, Integer> {

    /**
     * 根据id获取商户对象
     *
     * @param id 商户id
     * @return {@link Merchants}
     */
    Merchants findById(Integer id);

    /**
     * 根据商户名称获取商户对象
     *
     * @param name 商户名称
     * @return {@link Merchants}
     */
    Merchants findByName(String name);
}
