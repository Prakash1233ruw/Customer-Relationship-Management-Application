package com.pp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.bo.CustomerInfo;
import com.pp.dao.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private CustomerRepository repository;

	@Override
	public Iterable<CustomerInfo> registerAllCustomers(List<CustomerInfo> cList) {
		
		return repository.saveAll(cList);
	}

	
	@Override
	public List<CustomerInfo> getCustomers() {
		//int wTof=10/0;
		return (List<CustomerInfo>) repository.findAll();
	}

	@Override
	public void registerCustomer(CustomerInfo info) {
		
		repository.save(info);
	}


	@Override
	public void deleteCx(Integer id) {
		
		repository.deleteById(id);
		
	}


	@Override
	public CustomerInfo getCx(Integer id) {
	
		Optional<CustomerInfo> optCustomer = repository.findById(id);
	  
		    return optCustomer.get();
	
	}
}
