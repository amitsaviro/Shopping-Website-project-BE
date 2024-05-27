package com.firstProject.repository;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.firstProject.model.OrderList;
import com.firstProject.repository.cache.CacheRepository;
import com.firstProject.repository.mapper.OrderItemMapper;
import com.firstProject.repository.mapper.OrderListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class OrderListRepositoryImpl implements OrderListRepository{
    private static final String ORDER_LIST_TABLE_NAME = "order_list";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OrderListMapper orderListMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private CacheRepository cacheRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Long createOrderList(OrderList orderList) throws JsonProcessingException {
        String sql = "INSERT INTO " + ORDER_LIST_TABLE_NAME + " (customer_id, order_date, shipping_address, total_price, status) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, orderList.getCustomerId(), orderList.getOrderDate(), orderList.getShippingAddress(), orderList.getTotalPrice(), orderList.getStatus().name());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public void updateOrderList(OrderList orderList) {
        //String cacheKey = createCustomerIdCacheKey(customer.getId());
        //if(cacheRepository.isKeyExists(cacheKey)){
        //     cacheRepository.removeCacheEntity(cacheKey);
        //  }
        String sql = "UPDATE " + ORDER_LIST_TABLE_NAME + " SET customer_id=?, order_date=?, shipping_address=?, total_price=?, status=? WHERE order_list_id=?";
        jdbcTemplate.update(sql, orderList.getCustomerId(), orderList.getOrderDate(), orderList.getShippingAddress(), orderList.getTotalPrice(), orderList.getStatus().name(), orderList.getOrderListId());
    }

    @Override
    public void deleteOrderListById(Long id) {
        // String cacheKey = createCustomerIdCacheKey(id);
        // if(cacheRepository.isKeyExists(cacheKey)){
        //    cacheRepository.removeCacheEntity(cacheKey);
        //  }
        String sql = "DELETE FROM " + ORDER_LIST_TABLE_NAME + " WHERE order_list_id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public OrderList getOrderListById(Long id) throws JsonProcessingException {
        // String cacheKey = createCustomerIdCacheKey(id);
        //  if(cacheRepository.isKeyExists(cacheKey)){
        // String customer = cacheRepository.getCacheEntity(cacheKey);
        // return objectMapper.readValue(customer, Customer.class);
        //  } else {
        String sql = "SELECT * FROM " + ORDER_LIST_TABLE_NAME + " WHERE order_list_id=?";
        //  try {
        OrderList orderList = jdbcTemplate.queryForObject(sql, orderListMapper, id);
        //  String customerAsString = objectMapper.writeValueAsString(customer);
        //   cacheRepository.createCacheEntity(cacheKey, customerAsString);
        return orderList;
        //  } catch (EmptyResultDataAccessException e) {
        //    System.out.println("Empty Data Warning");
        //   return null;
        //  }
        //  }
    }

    //  private String createCustomerIdCacheKey(Long customerId){
    //  return "customer.id: " + customerId;
    //  }
}

