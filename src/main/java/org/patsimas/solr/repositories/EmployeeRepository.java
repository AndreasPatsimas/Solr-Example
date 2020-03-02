package org.patsimas.solr.repositories;

import org.patsimas.solr.domain.Employee;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends SolrCrudRepository<Employee, Integer> {

    List<Employee> findByNameContaining(String name);
}
