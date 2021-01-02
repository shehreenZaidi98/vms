package com.vms.QrCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QrCodeController {
   @Autowired
 QrcodeRepository qrcodeRepository;
   @Autowired
    MongoTemplate mongoTemplate;

   @PostMapping("insertQrcode")
    public String insertQrcode(@RequestBody QrCode qrCode){
       String message="Successful";
       QrCode qrCode1=qrcodeRepository.save(qrCode);
       if(!qrCode1.getId().isEmpty()){
           message="inserted";
       }
       return  message;
   }

}
