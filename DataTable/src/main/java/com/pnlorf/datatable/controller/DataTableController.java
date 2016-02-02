package com.pnlorf.datatable.controller;

import com.pnlorf.datatable.entity.DataTableResponse;
import com.pnlorf.datatable.service.DataTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:what's the use of this class?
 *
 * @author PNLORF
 * @version 1.0
 * @since 2016/2/1.
 */
@Controller
@RequestMapping("/dataTable")
public class DataTableController {

    @Autowired
    private DataTableService dataTableService;

    private final Logger logger = LoggerFactory.getLogger(DataTableController.class);

    @RequestMapping("/main")
    public String main() {
        return "/overview";
    }

    @ResponseBody
    @RequestMapping("/getAddressInfo")
    public DataTableResponse getProvinces(String selectId, String selectInfo) throws SQLException {
        logger.info("selectedId: "+ selectId + " ===== selectInfo: " + selectInfo);
        List list = new ArrayList<>();
        if ("province".equals(selectInfo)) {
            list = dataTableService.getProvinces();
        } else if ("city".equals(selectInfo)) {
            list = dataTableService.getCities(selectId);
        } else if ("district".equals(selectInfo)) {
            list = dataTableService.getDistricts(selectId);
        }
        DataTableResponse dataTableResponse = new DataTableResponse();
        dataTableResponse.setAaData(list);
        return dataTableResponse;
    }
}
