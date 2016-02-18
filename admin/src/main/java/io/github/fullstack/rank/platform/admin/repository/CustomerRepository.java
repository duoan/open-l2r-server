package io.github.fullstack.rank.platform.admin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Summary: CustomerRepository
 * Author : anduo@qq.com
 * Version: 1.0
 * Date   : 16/2/18
 * Time   : 上午11:29
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
