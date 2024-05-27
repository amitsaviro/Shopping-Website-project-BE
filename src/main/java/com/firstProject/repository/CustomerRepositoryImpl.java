package com.firstProject.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.firstProject.model.Customer;
import com.firstProject.model.Item;
import com.firstProject.repository.cache.CacheRepository;
import com.firstProject.repository.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private static final String CUSTOMER_TABLE_NAME = "customer";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CacheRepository cacheRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Long createCustomer(Customer customer)throws Exception {
        String sql = "INSERT INTO " + CUSTOMER_TABLE_NAME + " " + "(first_name, last_name, email, phone_number, address, user_name, password) values (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getAddress(),
                customer.getUserName(),
                customer.getPassword()
        );
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public void updateCustomer(Customer customer) {
        //String cacheKey = createCustomerIdCacheKey(customer.getId());
        //if(cacheRepository.isKeyExists(cacheKey)){
       //     cacheRepository.removeCacheEntity(cacheKey);
      //  }
        String sql = "UPDATE " + CUSTOMER_TABLE_NAME + " SET first_name=?, last_name=?, email=?, phone_number=?, address=?, user_name=?, password=? WHERE id=?";
        jdbcTemplate.update(
            sql,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getAddress(),
                customer.getUserName(),
                customer.getPassword(),
                customer.getId()
        );
    }

    @Override
    public void deleteCustomerById(Long id) {
       // String cacheKey = createCustomerIdCacheKey(id);
       // if(cacheRepository.isKeyExists(cacheKey)){
        //    cacheRepository.removeCacheEntity(cacheKey);
      //  }
        String sql = "DELETE FROM " + CUSTOMER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Customer getCustomerById(Long id) throws JsonProcessingException {
       // String cacheKey = createCustomerIdCacheKey(id);
      //  if(cacheRepository.isKeyExists(cacheKey)){
           // String customer = cacheRepository.getCacheEntity(cacheKey);
           // return objectMapper.readValue(customer, Customer.class);
      //  } else {
            String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME + " WHERE id=?";
          //  try {
                Customer customer = jdbcTemplate.queryForObject(sql, customerMapper, id);
              //  String customerAsString = objectMapper.writeValueAsString(customer);
             //   cacheRepository.createCacheEntity(cacheKey, customerAsString);
                return customer;
          //  } catch (EmptyResultDataAccessException e) {
            //    System.out.println("Empty Data Warning");
             //   return null;
          //  }
      //  }
    }
    @Override
    public List<Customer> getAllCustomer() throws JsonProcessingException {
        String sql = "SELECT * FROM " +CUSTOMER_TABLE_NAME;
        return jdbcTemplate.query(sql, customerMapper);
    }
    @Override
    public Customer findUserByUsername(String username) {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME + " WHERE user_name=?";
        try {
            return jdbcTemplate.queryForObject(sql, new CustomerMapper(), username);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }
  //  private String createCustomerIdCacheKey(Long customerId){
      //  return "customer.id: " + customerId;
  //  }
}














