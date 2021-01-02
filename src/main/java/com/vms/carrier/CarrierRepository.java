package com.vms.carrier;

import com.vms.visitorPass.VisitorPass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CarrierRepository extends MongoRepository<Carrier,String> {

    @Query("{'id':?0}")
    List<Carrier>getUpdated(String id);

    @Query("{'date':{$gte:?0,$lte:?1}}")
    List<Carrier>getExcel(String date, String to);


    @Query("{'date':?0}")
    List<Carrier>getTodayData(String date);

    @Query("{'check_in':?0}")
    List<Carrier>getCheckInData(String check_in);

    @Query("{'status':?0,'date':?1}")
    List<Carrier>getActiveStatus(String status,String date);

    @Query("{'status':?0}")
    List<Carrier>getCloseCarrierStatus(String status);
}
