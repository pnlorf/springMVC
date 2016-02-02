package com.pnlorf.datatable.entity;

import java.util.Date;

/**
 * Description:what's the use of this class?
 *
 * @author PNLORF
 * @version 1.0
 * @since 2016/2/1.
 */
public class Province {
    private Long id;

    private String name;

    private Date dateCreated;

    private Date dateUpdate;

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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Province(Long id, String name, Date dateCreated, Date dateUpdate) {
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
        this.dateUpdate = dateUpdate;
    }
}
