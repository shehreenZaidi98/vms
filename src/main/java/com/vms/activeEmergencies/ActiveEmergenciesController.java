package com.vms.activeEmergencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController

public class ActiveEmergenciesController {
@Autowired
    ActiveEmergenciesRepository activeEmergenciesRepository;
@Autowired
    MongoTemplate mongoTemplate;

@PostMapping("insertActiveEmergiencies")
    public String insertActiveEmergiencies(@RequestBody ActiveEmergencies activeEmergencies){
    String message="UnSuccessful";
    Date date=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
    activeEmergencies.setCheck_in_date_time(sdf.format(date));
    activeEmergencies.setDate(sdf1.format(date));
    ActiveEmergencies activeEmergencies1=activeEmergenciesRepository.save(activeEmergencies);
    if(!activeEmergencies1.getId().isEmpty()){
        message="Inserted";
    }
    return message;

}

@GetMapping("getActiveEmergencies")
    public Map<String, List<ActiveEmergencies>>getActiveEmergencies()
{
    Date date=new Date();
    SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd ");

    List<ActiveEmergencies>list=activeEmergenciesRepository.getActiveEmergencies(sdf1.format(date));
    if(list.size()>0) {
        System.out.println("for date :" + sdf1.format(date) + " size we get : " + list.size());
        HashMap<String, List<ActiveEmergencies>> hMap = new HashMap<>();
        hMap.put("ActiveEmergencies", list);
        return hMap;
    }else
        return null;
}
}
