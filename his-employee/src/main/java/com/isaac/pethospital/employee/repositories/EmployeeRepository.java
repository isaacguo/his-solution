package com.isaac.pethospital.employee.repositories;

import com.isaac.pethospital.employee.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.EnumMap;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    EmployeeEntity findByLoginAccount(String userAccount);
    EmployeeEntity findBySurnameAndGivenName(String surname, String givenName);

    EmployeeEntity findByUuid(String uuid);

    //List<EmployeeEntity> findDistinctEmployeeEntityByGivenNameContainsOrSurnameContains(String keyword,String keyword1);
    List<EmployeeEntity> findDistinctByFullNameContains(String keyword);

}
