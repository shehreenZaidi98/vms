package com.vms.activeEmergencies;

import com.vms.registration.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ActiveEmergenciesRepository extends MongoRepository<ActiveEmergencies,String> {


    @Query("{'date':?0}")
    List<ActiveEmergencies>getActiveEmergencies(String date);

}
