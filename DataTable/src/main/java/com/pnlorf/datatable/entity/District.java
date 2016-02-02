package com.pnlorf.datatable.entity;

import java.util.Date;

/**
 * Description:what's the use of this class?
 *
 * @author PNLORF
 * @version 1.0
 * @since 2016/2/1.
 */
public class District {

    private Long id;

    private String name;

    private Long cityId;

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

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
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

    public District(Long id, String name, Long cityId, Date dateCreated, Date dateUpdated) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }
}
