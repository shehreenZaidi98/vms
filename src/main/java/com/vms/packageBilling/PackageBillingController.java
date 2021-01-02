package com.vms.packageBilling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackageBillingController {
    @Autowired
    PackageBillingRepository packageBillingRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    @PostMapping("insertPackage")
    public String insertPackage(@RequestBody PackageBilling packageBilling){
        String message ="UnSuccessful";
        PackageBilling packageBilling1=packageBillingRepository.save(packageBilling);
        if(!packageBilling1.getId().isEmpty()){
            message="inserted";
        }
        return message;
    }
}
