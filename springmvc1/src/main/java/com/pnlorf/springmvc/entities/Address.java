package com.pnlorf.springmvc.entities;

/**
 * Description:地址实体
 *
 * @author PNLORF
 * @version 1.0
 * @since 2015/12/23.
 */
public class Address {

    private String province;

    private String city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
