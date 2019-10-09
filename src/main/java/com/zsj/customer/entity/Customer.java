package com.zsj.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author zsj55
 * @date 2019.9.23
 */
@Entity
public class Customer implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @Id
    @Column(length = 50)
    private String customerId;

    /**
     * 用户名
     */
    private String customerName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 注册时间
     */
    private String registerTime;

    /**
     * 用户地址
     */
    private String customerAddress;

    /**
     * 用户联系电话
     */
    private String customerTel;

    /**
     * 用户手机号
     */
    private String customerPhone;

    /**
     * 用户账号状态（0 冻结，1 正常）
     */
    private Integer status;

    /**
     * 用户性别( 0女,1男)
     */
    private Integer customerSex;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(Integer customerSex) {
        this.customerSex = customerSex;
    }
}
