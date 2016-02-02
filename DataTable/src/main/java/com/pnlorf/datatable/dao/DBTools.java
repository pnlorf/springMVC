package com.pnlorf.datatable.dao;

import java.sql.*;
import java.util.LinkedList;

/**
 * Description:what's the use of this class?
 *
 * @author PNLORF
 * @version 1.0
 * @since 2016/2/1.
 */
public class DBTools {
    private Connection connection;

    private PreparedStatement preparedStatement;

    public DBTools() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_table", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sql, LinkedList<Object> params) {
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    preparedStatement.setObject(i + 1, params.get(i));
                }
            }
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
