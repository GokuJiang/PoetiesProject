package com.yongming.service;


import com.yongming.model.poetoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by jiangyongming on 4/5/16.
 */
public class PoetiesService {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PoetiesService() {
        connection = new com.yongming.connection.Connection().getConnection();

    }

    /**
     * query poeties by poet_id
     *
     * @param uid poet_id from poetModel     int
     * @return List of poetries     List
     */
    public List queryPoetryByUid(int uid) {
        List poetories = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM poetries WHERE poet_id=? ");
            preparedStatement.setInt(1, uid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                com.yongming.model.poetoryModel poetory = new poetoryModel(uid);
                poetory.setId(resultSet.getInt(1));
                poetory.setPoet_id(uid);
                poetory.setContent(resultSet.getString(3));
                poetory.setTitle(resultSet.getString(4));
                poetories.add(poetory);
            }
            return poetories;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public poetoryModel queryPoetryByTitle(String title) {

        poetoryModel poetory = new poetoryModel();

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM poetries WHERE title=?");
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                poetory.setId(resultSet.getInt(1));
                poetory.setTitle(title);
                poetory.setContent(resultSet.getString(3));
                return poetory;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<poetoryModel> queryPoertiesByContent(String content) {

        System.out.println(content);
        List<poetoryModel> list = new ArrayList<>();

        String sql = "SELECT * FROM poetries WHERE content LIKE \"%" + content + "%\"";

        try {
            preparedStatement = connection.prepareStatement(sql);

            /**
             * // preparedStatement.setString(1,content);
             * // preparedStatement.setString(1,content);
             * 这两句话在这里总会抛出异常,所以我在之前用字符串拼接来实现SQL语句
             * java.sql.SQLException: Parameter index out of range (1 > number of parameters, which is 0).
             *
             */
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                poetoryModel poetory = new poetoryModel();
                poetory.setId(resultSet.getInt(1));
                poetory.setPoet_id(resultSet.getInt(2));

                /**
                 * 根据poet_id 去poets表查询数据
                 */
                String poetName = new PoetService().queryPoetNameById(poetory.getPoet_id());
                poetory.setTitle(resultSet.getString(4));
                poetory.setContent(resultSet.getString(3));
                poetory.setName(poetName);
                System.out.print(poetory.getId() + "&&" +
                        poetory.getPoet_id() + "&&" +
                        poetory.getTitle() + "&&" +
                        poetory.getContent() + "&&" +
                        poetory.getName());

                list.add(poetory);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
