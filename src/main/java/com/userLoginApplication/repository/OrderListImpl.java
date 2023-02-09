package com.userLoginApplication.repository;


import com.userLoginApplication.model.OrderList;
import com.userLoginApplication.repository.mapper.OrderListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderListImpl implements OrderListRepository{
    private static final String ORDER_LIST_TABLE_NAME = "order_list";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createOrderList(OrderList orderList) {
        String sql = "INSERT INTO " + ORDER_LIST_TABLE_NAME + " (username,item_id,quantity_item) VALUES (?,?,?)";
        jdbcTemplate.update(sql,orderList.getUsername(),orderList.getItemId(),orderList.getQuantityItem());
    }

    @Override
    public void deleteList(String username) {
        String sql = "DELETE FROM " + ORDER_LIST_TABLE_NAME + " WHERE username = ?";
        jdbcTemplate.update(sql,username);
    }


    @Override
    public void deleteItemInList(String username, Long itemId) {
        String sql = "DELETE FROM " + ORDER_LIST_TABLE_NAME + " WHERE username = ? AND item_id = ?";
        jdbcTemplate.update(sql,username,itemId);
    }

    @Override
    public List<OrderList> getAllOrdersByUsername(String username) {
        String sql = "SELECT * FROM " + ORDER_LIST_TABLE_NAME + " WHERE username = ?";
        try {
            return jdbcTemplate.query(sql,new OrderListMapper(),username);
        } catch (EmptyResultDataAccessException error){
            return null;
        }    }
}
