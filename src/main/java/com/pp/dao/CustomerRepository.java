package com.pp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pp.bo.CustomerInfo;
@Repository
public interface CustomerRepository extends CrudRepository<CustomerInfo, Integer> {

}
