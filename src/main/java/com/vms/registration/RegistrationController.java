package com.vms.registration;

import com.sun.mail.smtp.SMTPTransport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Properties;

import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;




@RestController
public class RegistrationController {
@Autowired
    RegistrationRepository registrationRepository;
@Autowired
    MongoTemplate mongoTemplate;
    public static   String PASSWORD = "Cybershot@903";
/*    public static String EMAIL_FROM = "sandeepkumarsingh2546@gmail.com";
@PostMapping("insertRegistration")
    public String insertRegistration(@RequestBody Registration registration){
    Registration registration1=registrationRepository.save(registration);
    String message="UnSuccessful";
    if(!registration1.getId().isEmpty()){
        message="Successful";
        sendMail(registration.getEmail());
    }
        return message;

}*/

  /*  public static void sendMail(String email) {
        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        System.out.println("emails id we have = " );
        Session session = Session.getInstance(prop, (Authenticator)null);
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress("sandeepkumarsingh2546@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email, false));
            msg.setSubject("Stock Data");
            MimeBodyPart p1 = new MimeBodyPart();
            p1.setText("Today and All Stock Data");
          //  MimeBodyPart p2 = new MimeBodyPart();
//             FileDataSource fds = new FileDataSource("C:\\Users\\asd\\Desktop\\CMMS_Reports" + filename);
            //
           // p2.setDataHandler(new DataHandler(fds));
           // p2.setFileName(fds.getName());
           // System.out.println("fds value " + fds.getName());
            final Multipart mp = new MimeMultipart();
            mp.addBodyPart(p1);
           // mp.addBodyPart(p2);
            msg.setContent(mp);
            System.out.println("mp = " + mp+" email = "+EMAIL_FROM+" pswrd= "+PASSWORD);
            SMTPTransport t = (SMTPTransport)session.getTransport("smtp");
            t.connect("smtp.gmail.com", EMAIL_FROM, PASSWORD);
            t.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Response: " + t.getLastServerResponse());
            t.close();
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }*/
/*
    @PostMapping("verifyEmail")
    public void verifyEmail(@RequestParam("email")String email){
    List<Registration> list=registrationRepository.getEmail(email);
    if(list.size()>0){
        Query query=new Query();
        query.addCriteria(Criteria.where("barcode").is(list.get(0).getEmail()));
        Update update = new Update();
        update.set("status","active");
        mongoTemplate.upsert(query,update,Registration.class);
    }

    }*/

    @GetMapping("getLogin")
    public Map<String,List<Registration>> getLogin(@RequestParam("emp_code")String emp_code,
                           @RequestParam("password")String password){
        HashMap<String,List<Registration>>hMap=new HashMap<>();
        List<Registration>list=registrationRepository.getLogin(emp_code,password);
        if(list.size()>0){
        hMap.put("response",list);
        }else {
            hMap.put("response",null);
        }
        return  hMap;
    }
    @PostMapping("insertLogin")
    public String getLogin(@RequestBody Registration registration){
        String message="Successful";
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        registration.setDate(sdf.format(date));
        Registration registration1=registrationRepository.save(registration);
        if(!registration1.getId().isEmpty()){
            message="inserted";
        }
        return  message;
    }

}
