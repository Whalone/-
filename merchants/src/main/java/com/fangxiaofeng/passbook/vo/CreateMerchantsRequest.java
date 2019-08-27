package com.fangxiaofeng.passbook.vo;

import com.fangxiaofeng.passbook.constant.ErrorCode;
import com.fangxiaofeng.passbook.dao.MerchantsDao;
import com.fangxiaofeng.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建商户请求对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsRequest {

    /* 商户名称*/
    private String name;

    /* 商户logo*/
    private String logoUrl;

    /* 商户营业执照*/
    private String businessLicenseUrl;

    /* 商户电话*/
    private String phone;

    /* 商户地址*/
    private String address;

    public ErrorCode validate(MerchantsDao merchantsDao) {

        if (merchantsDao.findByName(this.name) != null) {
            return ErrorCode.DUPLICATE_NAME;
        }

        if (this.logoUrl == null) {
            return ErrorCode.EMPTY_LOGO;
        }

        if (this.businessLicenseUrl == null) {
            return ErrorCode.EMPTY_BUSINESS_LICENSE;
        }

        if(this.address == null){
            return ErrorCode.EMPTY_ADDRESS;
        }

        if(this.phone==null){
            return ErrorCode.ERROR_PHONE;
        }

        return ErrorCode.SUCCESS;
    }

    /**
     * 将请求对象转换为商户对象
     * @return {@link Merchants}
     */
    public Merchants toMerchants(){
        Merchants merchants = new Merchants();

        merchants.setName(name);
        merchants.setLogUrl(logoUrl);
        merchants.setBusinessesLicenseUrl(businessLicenseUrl);
        merchants.setPhone(phone);
        merchants.setAddress(address);

        return merchants;
    }
}
