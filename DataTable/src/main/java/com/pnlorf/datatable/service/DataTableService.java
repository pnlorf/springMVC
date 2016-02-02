package com.pnlorf.datatable.service;

import com.pnlorf.datatable.dao.DataTableDao;
import com.pnlorf.datatable.entity.City;
import com.pnlorf.datatable.entity.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:what's the use of this class?
 *
 * @author PNLORF
 * @version 1.0
 * @since 2016/2/1.
 */
@Service
@Transactional
public class DataTableService {

    @Autowired
    private DataTableDao dataTableDao;

    public List<Province> getProvinces() throws SQLException {
        return dataTableDao.getProvinceList();
    }

    public List<City> getCities(String selectId) throws SQLException {
        LinkedList params = new LinkedList();
        params.add(selectId);
        return dataTableDao.getCityList(params);
    }

    public List getDistricts(String selectId) throws SQLException {
        LinkedList params = new LinkedList();
        params.add(selectId);
        return dataTableDao.getDistrictList(params);
    }
}
