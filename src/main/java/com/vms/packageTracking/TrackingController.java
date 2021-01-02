package com.vms.packageTracking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class TrackingController {
@Autowired
    TrackingRepository trackingRepository;
@Autowired
    MongoTemplate mongoTemplate;
@PostMapping("insertTracking")
    public String insertTracking(@RequestBody Tracking tracking) {
    String message = "UnSuccessful";
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    tracking.setDate(sdf.format(date));


    Tracking tracking1 = trackingRepository.save(tracking);
    if (!tracking1.getId().isEmpty()) {
        message = "inserted";
    }

    return message;
}
}

