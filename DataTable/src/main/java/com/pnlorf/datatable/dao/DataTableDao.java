package com.pnlorf.datatable.dao;

import com.pnlorf.datatable.entity.City;
import com.pnlorf.datatable.entity.District;
import com.pnlorf.datatable.entity.Province;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:模拟查询数据库，构造dataTable显示数据
 *
 * @author PNLORF
 * @version 1.0
 * @since 2016/2/1.
 */
@Repository
public class DataTableDao {

    private DBTools dbTools = new DBTools();

    public List<Province> getProvinceList() throws SQLException {
        ResultSet rs = dbTools.executeQuery("select * from s_province", null);
        ResultSetMetaData rsd = rs.getMetaData();
        List<Province> provinceList = new ArrayList<Province>();
        while (rs.next()) {
            Province province = new Province((Long) rs.getObject("ProvinceID"), rs.getObject("ProvinceName")
                    .toString(), (Date) rs.getObject("DateCreated"), (Date) rs.getObject("DateUpdated"));
            provinceList.add(province);
        }
        return provinceList;
    }

    public List<City> getCityList(LinkedList<Object> provinceIds) throws SQLException {
        ResultSet rs = dbTools.executeQuery("select * from s_city where ProvinceID = ?", provinceIds);
        List<City> cityList = new ArrayList<>();
        while (rs.next()) {
            City city = new City((Long) rs.getObject("CityID"), rs.getString("CityName"),
                    rs.getString("ZipCode"), (Long) rs.getObject("ProvinceID"),
                    (Date) rs.getObject("DateCreated"), (Date) rs.getObject("DateUpdated"));
            cityList.add(city);
        }
        return cityList;
    }

    public List<District> getDistrictList(LinkedList<Object> cityIds) throws SQLException {
        ResultSet rs = dbTools.executeQuery("select * from s_district where CityID = ?", cityIds);
        List<District> districtList = new ArrayList<>();
        while (rs.next()) {
            District district = new District((Long) rs.getObject("DistrictID"), rs.getString("DistrictName")
                    , (Long) rs.getObject("CityID"), rs.getDate("DateCreated"), rs.getDate("DateUpdated"));
            districtList.add(district);
        }
        return districtList;
    }

}
