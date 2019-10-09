package com.zsj.customer.dao;

import com.zsj.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zsj
 * @date 2019.9.23
 */

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
