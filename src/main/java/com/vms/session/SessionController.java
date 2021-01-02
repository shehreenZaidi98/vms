package com.vms.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
@Autowired
    SessionRepository sessionRepository;

    @PostMapping("insertSession")
    public String insertSession(@RequestBody Session session){
        String message="UnSuccessful";
        session.setEnd_time("");
        Session session1=sessionRepository.save(session);
        if(!session1.getId().isEmpty()){
            message="Successful";
        }
        return  message;
    }
    

}
