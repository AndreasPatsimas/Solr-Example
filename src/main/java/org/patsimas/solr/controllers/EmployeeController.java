package org.patsimas.solr.controllers;

import org.patsimas.solr.domain.Employee;
import org.patsimas.solr.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

//    @PostConstruct --> runs before executing dependencies
//                      Spring calls methods annotated with @PostConstruct only once, just after the initialization of bean properties.
//                      Keep in mind that these methods will run even if there is nothing to initialize.
//                      The method annotated with @PostConstruct can have any access level but it can't be static.
//                      One example usage of @PostConstruct is populating a database.
//                        @PostConstruct annotation is part of Java EE.
//                        And since Java EE has been deprecated in Java 9 and removed in Java 11 we have to
//                        add an additional dependency to use this annotation:
//                                            <dependency>
//                                                <groupId>javax.annotation</groupId>
//                                                <artifactId>javax.annotation-api</artifactId>
//                                                <version>1.3.2</version>
//    @PostConstruct                                        </dependency>
//    public void addEmployees(){
//
//        List<Employee> employees = new ArrayList<>();
//
//        employees.add(Employee.builder()
//                .id(1)
//                .name("Andreas")
//                .email("andreas-patsim@hotmail.com")
//                .build());
//
//        employees.add(Employee.builder()
//                .id(2)
//                .name("Sotiris")
//                .email("sotirinio@hotmail.com")
//                .build());
//
//        employees.add(Employee.builder()
//                .id(3)
//                .name("Chris")
//                .email("bolosis@gmail.com")
//                .build());
//
//        employeeSolrRepository.saveAll(employees);
//    }

    @GetMapping(value = "employees")
    public Iterable<Employee> findAll(){

        return employeeRepository.findAll();
    }

    @GetMapping(value = "employees/{name}")
    public List<Employee> findByName(@PathVariable String name){

        return employeeRepository.findByNameContaining(name);
    }
}
