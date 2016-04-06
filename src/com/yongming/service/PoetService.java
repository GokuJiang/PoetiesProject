package com.yongming.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jiangyongming on 4/5/16.
 */
public class PoetService {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PoetService() {

        connection = new com.yongming.connection.Connection().getConnection();
    }


    /**
     * Returns poetModel by a author name
     *
     * @param author name String
     * @return
     */
    public com.yongming.model.poetModel queryInformationByname(String name) {
        com.yongming.model.poetModel poet = new com.yongming.model.poetModel(name);
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM poets WHERE name=?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                poet.setId(resultSet.getInt(1));
                return poet;

            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String queryPoetNameById(int id) {

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM poets WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(2);
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

}

