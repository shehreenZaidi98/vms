package com.vms.packageTracking;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PackageTrackingRepository extends MongoRepository<PackageTracking,String> {

    @Query("{'id:?0}")
    List<PackageTracking>getOrder_id(String id);

    @Query("{'product_name':?0}")
    List<PackageTracking>getProductName(String product_name);
}
