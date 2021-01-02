package com.vms.walkin;

import com.vms.visitorPass.VisitorPass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalkinRepository extends MongoRepository<Walkin,String> {

    @Query("{'meeting_date':?0}")
    List<Walkin> getWalkin(String meeting_date);

    @Query("{'meeting_date':?0}")
    List<Walkin>getActiveCheckIn(String meeting_date);

    @Query("{'meeting_date':{$gte:?0,$lte:?1}}")
    List<Walkin>getExcel(String meeting_time,String to);

}
