package com.vms.packageTracking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
public class PackageTrackingController {
    @Autowired
    PackageTrackingRepository packageTrackingRepository;
    @Autowired
    MongoTemplate mongoTemplate;


    @PostMapping("insertPackageTracking")
    public String insertPackageTracking(@RequestBody PackageTracking packageTracking){
        String message="UnSuccessful";
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        packageTracking.setDate(sdf.format(date));
        packageTracking.setStatus("In Process");
        PackageTracking packageTracking1=packageTrackingRepository.save(packageTracking);

        if(!packageTracking1.getId().isEmpty()){
            message="successful";
        }
        return  message;
    }
        @PostMapping("/updateTracking")
    public void updatePackageTracking(@RequestParam("_id")String id){
        //String message="Unsuccessful";
            List<PackageTracking>list=packageTrackingRepository.getOrder_id(id);
            if(list.size()>0) {
                Query query = new Query();
                query.addCriteria(Criteria.where("id").is(list.get(0).getId()));
                Update update = new Update();
                update.set("status", "delivered");
                mongoTemplate.updateMulti(query, update, PackageTracking.class);
            }
        }

        @GetMapping("getPackageData")
    public Map<String,List<PackageTracking>> getPackageData(@RequestParam("product_name")String product_name){
        List<PackageTracking>list=packageTrackingRepository.getProductName(product_name);
        HashMap<String,List<PackageTracking>>hMap=new HashMap<>();
        hMap.put("data",list);
        return hMap;



        }


}
