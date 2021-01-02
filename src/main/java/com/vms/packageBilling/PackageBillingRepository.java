package com.vms.packageBilling;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageBillingRepository extends MongoRepository<PackageBilling,String> {



}
