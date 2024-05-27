package com.firstProject.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.firstProject.model.Item;
import com.firstProject.model.OrderItem;
import com.firstProject.repository.cache.CacheRepository;
import com.firstProject.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository{
    private static final String ITEM_TABLE_NAME = "item";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private CacheRepository cacheRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Long createItem(Item item) throws JsonProcessingException{
        String sql = "INSERT INTO " + ITEM_TABLE_NAME + " " + "(item_name, price, old_price, img_url, category, stock) values (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                item.getItemName(),
                item.getPrice(),
                item.getOldPrice(),
                item.getImgUrl(),
                item.getCategory(),
                item.getStock()
        );
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public void updateItem(Item item) {
        //String cacheKey = createCustomerIdCacheKey(customer.getId());
        //if(cacheRepository.isKeyExists(cacheKey)){
        //     cacheRepository.removeCacheEntity(cacheKey);
        //  }
        String sql = "UPDATE " + ITEM_TABLE_NAME + " SET item_name=?, price=?, old_price=?, img_url=?, category=?, stock=? WHERE item_id=?";
        jdbcTemplate.update(
                sql,
                item.getItemName(),
                item.getPrice(),
                item.getOldPrice(),
                item.getImgUrl(),
                item.getCategory(),
                item.getStock(),
                item.getItemId()
        );
    }

    @Override
    public void deleteItemById(Long id) {
        // String cacheKey = createCustomerIdCacheKey(id);
        // if(cacheRepository.isKeyExists(cacheKey)){
        //    cacheRepository.removeCacheEntity(cacheKey);
        //  }
        String sql = "DELETE FROM " + ITEM_TABLE_NAME + " WHERE item_id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Item getItemById(Long id) throws JsonProcessingException {
        // String cacheKey = createCustomerIdCacheKey(id);
        //  if(cacheRepository.isKeyExists(cacheKey)){
        // String customer = cacheRepository.getCacheEntity(cacheKey);
        // return objectMapper.readValue(customer, Customer.class);
        //  } else {
        String sql = "SELECT * FROM " + ITEM_TABLE_NAME + " WHERE item_id=?";
        //  try {
        Item item = jdbcTemplate.queryForObject(sql, itemMapper, id);
        //  String customerAsString = objectMapper.writeValueAsString(customer);
        //   cacheRepository.createCacheEntity(cacheKey, customerAsString);
        return item;
        //  } catch (EmptyResultDataAccessException e) {
        //    System.out.println("Empty Data Warning");
        //   return null;
        //  }
        //  }
    }
    @Override
    public List<Item> getAllItems() throws JsonProcessingException {
        String sql = "SELECT * FROM " +ITEM_TABLE_NAME;
        return jdbcTemplate.query(sql, itemMapper);
    }
    //  private String createCustomerIdCacheKey(Long customerId){
    //  return "customer.id: " + customerId;
    //  }
}
