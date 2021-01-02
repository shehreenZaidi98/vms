package com.vms.registration;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface RegistrationRepository extends MongoRepository<Registration,String> {

    @Query("{'emp_code':?0}")
    List<Registration> getEmail(String emp_code);

    @Query("{'emp_code':?0,'password':?1}")
    List<Registration>getLogin(String emp_code,String password);
}
