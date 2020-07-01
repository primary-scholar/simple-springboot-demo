package com.mimu.springboot.demo.dao;

import com.mimu.springboot.demo.model.ChoiceInfo;
import com.mimu.springboot.demo.model.ChoiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 author: mimu
 date: 2020/3/5
 */
@Repository
public class ChoiceRepository {

    private JdbcTemplate userInfoJdbcTemplate;

    @Autowired
    public void setUserInfoJdbcTemplate(JdbcTemplate userInfoJdbcTemplate) {
        this.userInfoJdbcTemplate = userInfoJdbcTemplate;
    }

    public List<ChoiceInfo> listChoiceInfo() {
        String sql = "select * from choice_info";
        List<ChoiceInfo> choiceInfoList = userInfoJdbcTemplate.query(sql, new ChoiceInfoMapper());
        return choiceInfoList;
    }

    public int addChoiceItem(ChoiceItem item) {
        String sql = "INSERT INTO `choice_transform` (`itemId`, `itemKey`, `itemValue`, `itemType`) values (?,?,?,?)";
        int result = userInfoJdbcTemplate.update(sql, item.getItemId(), item.getItemKey(), item.getItemValue(), item.getItemType());
        return result;
    }


    public class ChoiceInfoMapper implements RowMapper<ChoiceInfo> {

        @Override
        public ChoiceInfo mapRow(ResultSet resultSet, int i) throws SQLException {
            ChoiceInfo choiceInfo =new ChoiceInfo();
            choiceInfo.setId(resultSet.getInt("id"));
            choiceInfo.setCa(resultSet.getString("a"));
            choiceInfo.setCb(resultSet.getString("b"));
            choiceInfo.setCc(resultSet.getString("c"));
            choiceInfo.setCd(resultSet.getString("d"));
            choiceInfo.setCe(resultSet.getString("e"));
            return choiceInfo;
        }
    }

}
