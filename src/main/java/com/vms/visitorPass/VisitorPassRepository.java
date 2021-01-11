package com.vms.visitorPass;

import com.vms.carrier.Carrier;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface VisitorPassRepository extends MongoRepository<VisitorPass,String> {

 @Query("{'status':?0,'date':?1}")
 List<VisitorPass>getVisitorActiveStatus(String status, String date);
/*
    @Query("{'meeting_date':?0}")
    List<VisitorPass>getActiveCheckIn(String meeting_date);*/

    @Query("{'date':{$gte:?0,$lte:?1}}")
    List<VisitorPass>getExcel(String date,String to);

  /*  @Query("{'purpose':?0,'business_name':?1}")
    List<VisitorPass>getVisitorPurpose(String purpose,String business_name);
*/

    @Query("{'date':?0}")
    List<VisitorPass>getTodayData(String date);

    @Query("{'id'}")
    List<VisitorPass>getUpdate(String id);

    @Query("{'status':?0}")
   List<VisitorPass>getCloseStatus(String status);

    @Query("{'phone_no':?0}")
    List<VisitorPass>getPhoneNo(String phone_no);

    @Query("{'id':?0,'status':?1}")
    List<VisitorPass>getDetails(String id,String status);

}
