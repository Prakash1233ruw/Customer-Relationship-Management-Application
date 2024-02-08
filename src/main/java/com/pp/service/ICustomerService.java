package com.pp.service;

import java.util.List;

import com.pp.bo.CustomerInfo;

public interface ICustomerService {
public Iterable<CustomerInfo> registerAllCustomers(List<CustomerInfo> cList);

public List<CustomerInfo> getCustomers();
public void registerCustomer(CustomerInfo info);
public void deleteCx(Integer id);
public CustomerInfo getCx(Integer id);
}
