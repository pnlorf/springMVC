package com.pnlorf.datatable.entity;

import java.util.Date;

/**
 * Description:what's the use of this class?
 *
 * @author PNLORF
 * @version 1.0
 * @since 2016/2/1.
 */
public class City {

    private Long id;

    private String name;

    private String zipCode;

    private Long provinceId;

    private Date dateCreated;

    private Date dateUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public City(Long id, String name, String zipCode, Long provinceId, Date dateCreated, Date
            dateUpdated) {
        this.id = id;
        this.name = name;
        this.zipCode = zipCode;
        this.provinceId = provinceId;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }
}
