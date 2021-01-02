package com.vms.visitorPass;

import com.google.zxing.WriterException;
import com.vms.QrCode.QrCode;
import com.vms.QrCode.QrcodeRepository;
import com.vms.carrier.Carrier;
import com.vms.code.QRCodeGenerator;
import com.vms.packageTracking.PackageTracking;
import com.vms.walkin.Walkin;
import com.vms.walkin.WalkinRepository;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraReactiveRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class VisitorPassController {
    @Autowired
    VisitorPassRepository visitorPassRepository;
    @Autowired
    WalkinRepository walkinRepository;
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    QrcodeRepository qrcodeRepository;

   /* @PostMapping("insertVisitor")
    public String insertVisitor(@RequestBody VisitorPass visitorPass) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        String message = "UnSuccessful";
        visitorPass.setMeeting_date(sdf.format(date));
        visitorPass.setMeeting_time(sdf2.format(date));
        VisitorPass visitorPass1 = visitorPassRepository.save(visitorPass);
        if (!visitorPass1.getId().isEmpty()) {
            message = "Successful";
        }
        return message;
    }

    @GetMapping("getTodayCheckIn")
    public Map<String, Integer> getTodayCheckIn() {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<VisitorPass> list = visitorPassRepository.getTodayCheckIn(sdf.format(date));
        HashMap<String, Integer> hMap = new HashMap<>();
        hMap.put("data", list.size());
        return hMap;

    }

    @GetMapping("getAllVisitor")
    public Map<String, Integer> getAllVisitor() {
        List<VisitorPass> list = visitorPassRepository.findAll();
        HashMap<String, Integer> hMap = new HashMap<>();
        hMap.put("visitor", list.size());
        return hMap;
    }
    @GetMapping("getActiveCheckIn")
    public Map<String,Integer>getActiveCheckIn() throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<VisitorPass> list1 = visitorPassRepository.getActiveCheckIn(sdf.format(date));
        int count=0;
        for (VisitorPass visitorPass : list1) {
           Date d1=sdf1.parse(visitorPass.getExpected_check_out());
           long dif=date.getTime()-d1.getTime();
            if (dif<0){
                count++;
            }
        }
        HashMap<String, Integer> hMap = new HashMap<>();
        hMap.put("ActiveCheckIn", count);
        return hMap;
    }*/

    @GetMapping("uploadExcel")
    public void createOrderSheet(HttpServletResponse response1,@RequestParam("date")String date,
                                 @RequestParam("to")String to) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        HSSFCellStyle style1 = (HSSFCellStyle) workbook.createCellStyle();
        CellStyle style0 = workbook.createCellStyle();

        style0.setVerticalAlignment(VerticalAlignment.CENTER);
        style0.setAlignment(HorizontalAlignment.CENTER);
        ;
        style0.setBorderBottom(BorderStyle.THIN);
        style0.setBorderTop(BorderStyle.THIN);
        style0.setBorderLeft(BorderStyle.THIN);
        style0.setBorderRight(BorderStyle.THIN);


        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setVerticalAlignment(VerticalAlignment.CENTER);
        style1.setBorderBottom(BorderStyle.THIN);
        style1.setBorderTop(BorderStyle.THIN);
        style1.setBorderLeft(BorderStyle.THIN);
        style1.setBorderRight(BorderStyle.THIN);

        org.apache.poi.ss.usermodel.Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 10);

        org.apache.poi.ss.usermodel.Font font1 = workbook.createFont();
        font1.setFontHeightInPoints((short) 10);

        style0.setFont((org.apache.poi.ss.usermodel.Font) font);
        style0.setWrapText(true);

        style1.setFont((org.apache.poi.ss.usermodel.Font) font1);
        style1.setWrapText(true);



        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd");

        List<VisitorPass> visitorPassList = visitorPassRepository.getExcel(date,to);

        try {
            Sheet sheet = workbook.createSheet("Visitor Pass");
            Row row0 = sheet.createRow(0);

            row0.setHeight((short) 600);
            sheet.setColumnWidth(0, 5000);
            sheet.setColumnWidth(3, 5000);
            sheet.setColumnWidth(2, 5000);
            sheet.setColumnWidth(1, 5000);
            sheet.setColumnWidth(4, 5000);
            sheet.setColumnWidth(5, 5000);
            sheet.setColumnWidth(6, 5000);
            sheet.setColumnWidth(7, 5000);
            sheet.setColumnWidth(8, 5000);
            sheet.setColumnWidth(9, 5000);



            Cell cell0 = row0.createCell(0);
            Cell cell1 = row0.createCell(1);
            Cell cell2 = row0.createCell(2);
            Cell cell3 = row0.createCell(3);
            Cell cell4 = row0.createCell(4);
            Cell cell5 = row0.createCell(5);
            Cell cell6 = row0.createCell(6);
            Cell cell7 = row0.createCell(7);
            Cell cell8 = row0.createCell(8);
            Cell cell9= row0.createCell(9);



            cell0.setCellStyle(style0);
            cell1.setCellStyle(style0);
            cell2.setCellStyle(style0);
            cell3.setCellStyle(style0);
            cell4.setCellStyle(style0);
            cell5.setCellStyle(style0);
            cell6.setCellStyle(style0);
            cell7.setCellStyle(style0);
            cell8.setCellStyle(style0);
            cell9.setCellStyle(style0);



            cell0.setCellValue("name");
            cell1.setCellValue("phone_no");
            cell2.setCellValue("email");
            cell3.setCellValue("location");
            cell4.setCellValue("purpose_of_visit");
            cell5.setCellValue("whom_to_meet");
            cell6.setCellValue("date");
            cell7.setCellValue("status");
            cell8.setCellValue("check_in");
            cell9.setCellValue("check_out");


            int j = 1;
            for (VisitorPass visitorPass : visitorPassList) {

                Row row1 = sheet.createRow(j++);
                Cell cell11 = row1.createCell(0);
                Cell cell12 = row1.createCell(1);
                Cell cell13 = row1.createCell(2);

                Cell cell14 = row1.createCell(3);
                Cell cell15 = row1.createCell(4);
                Cell cell16 = row1.createCell(5);
                Cell cell17 = row1.createCell(6);
                Cell cell18 = row1.createCell(7);
                Cell cell19 = row1.createCell(8);
                Cell cell20 = row1.createCell(9);


                cell11.setCellStyle(style1);
                cell12.setCellStyle(style1);
                cell13.setCellStyle(style1);
                cell14.setCellStyle(style1);
                cell15.setCellStyle(style1);
                cell16.setCellStyle(style1);
                cell17.setCellStyle(style1);
                cell18.setCellStyle(style1);
                cell19.setCellStyle(style1);
                cell20.setCellStyle(style1);


                cell11.setCellValue(visitorPass.getName());
                cell12.setCellValue(visitorPass.getPhone_no());
                cell13.setCellValue(visitorPass.getEmail());

                cell14.setCellValue(visitorPass.getLocation());
                cell15.setCellValue(visitorPass.getPurpose_of_visit());
                cell16.setCellValue(visitorPass.getWhom_to_meet());
                cell17.setCellValue(visitorPass.getDate());
                cell18.setCellValue(visitorPass.getStatus());
                cell19.setCellValue(visitorPass.getCheck_in());
                cell20.setCellValue(visitorPass.getCheck_out());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<VisitorPass> getVisitor =visitorPassRepository.findAll();
        try {
            Sheet sheet = workbook.createSheet("All Visitor List");
            Row row0 = sheet.createRow(0);

            row0.setHeight((short) 600);
            sheet.setColumnWidth(0, 5000);
            sheet.setColumnWidth(3, 5000);
            sheet.setColumnWidth(2, 5000);
            sheet.setColumnWidth(1, 5000);
            sheet.setColumnWidth(4, 5000);
            sheet.setColumnWidth(5, 5000);
            sheet.setColumnWidth(6, 5000);
            sheet.setColumnWidth(7, 5000);
            sheet.setColumnWidth(8, 5000);
            sheet.setColumnWidth(9, 5000);


            Cell cell0 = row0.createCell(0);
            Cell cell1 = row0.createCell(1);
            Cell cell2 = row0.createCell(2);
            Cell cell3 = row0.createCell(3);
            Cell cell4 = row0.createCell(4);
            Cell cell5 = row0.createCell(5);
            Cell cell6 = row0.createCell(6);
            Cell cell7 = row0.createCell(7);
            Cell cell8 = row0.createCell(8);
            Cell cell9 = row0.createCell(9);


            cell0.setCellStyle(style0);
            cell1.setCellStyle(style0);
            cell2.setCellStyle(style0);
            cell3.setCellStyle(style0);
            cell4.setCellStyle(style0);
            cell5.setCellStyle(style0);
            cell6.setCellStyle(style0);
            cell7.setCellStyle(style0);
            cell8.setCellStyle(style0);
            cell9.setCellStyle(style0);


            cell0.setCellValue("name");
            cell1.setCellValue("phone_no");
            cell2.setCellValue("email");
            cell3.setCellValue("location");
            cell4.setCellValue("purpose_of_visit");
            cell5.setCellValue("whom_to_meet");
            cell6.setCellValue("date");
            cell7.setCellValue("status");
            cell8.setCellValue("check_in");
            cell9.setCellValue("check_out");


            int j = 1;
            for (VisitorPass visitorPass : getVisitor) {

                Row row1 = sheet.createRow(j++);
                Cell cell11 = row1.createCell(0);
                Cell cell12 = row1.createCell(1);
                Cell cell13 = row1.createCell(2);
                Cell cell14 = row1.createCell(3);
                Cell cell15 = row1.createCell(4);
                Cell cell16 = row1.createCell(5);
                Cell cell17 = row1.createCell(6);
                Cell cell18 = row1.createCell(7);
                Cell cell19 = row1.createCell(8);
                Cell cell20 = row1.createCell(9);



                cell11.setCellStyle(style1);
                cell12.setCellStyle(style1);
                cell13.setCellStyle(style1);
                cell14.setCellStyle(style1);
                cell15.setCellStyle(style1);
                cell16.setCellStyle(style1);
                cell17.setCellStyle(style1);
                cell18.setCellStyle(style1);
                cell19.setCellStyle(style1);
                cell20.setCellStyle(style1);


                cell11.setCellValue(visitorPass.getName());
                cell12.setCellValue(visitorPass.getPhone_no());
                cell13.setCellValue(visitorPass.getEmail());
                cell14.setCellValue(visitorPass.getLocation());
                cell15.setCellValue(visitorPass.getPurpose_of_visit());

                cell16.setCellValue(visitorPass.getWhom_to_meet());
                cell17.setCellValue(visitorPass.getDate());
                cell18.setCellValue(visitorPass.getStatus());
                cell19.setCellValue(visitorPass.getCheck_in());
                cell20.setCellValue(visitorPass.getCheck_out());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Date date1 = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        response1.setHeader("content-disposition", "attachment;filename=Visitor_Pass" + sdf2.format(date1) + ".xls");
        workbook.write(response1.getOutputStream());

    }
    /*
    @GetMapping("getWeekData")
    public Map<String,List<VisitorPass>>getWeekData(){
        Date date1=new Date(System.currentTimeMillis());
        Date date2=new Date(System.currentTimeMillis()-10080*60000);
        SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(date2));

        List<VisitorPass>getWeek=visitorPassRepository.getExcel(sdf.format(date2), sdf.format(date1));
        HashMap<String,List<VisitorPass>>hMap=new HashMap<>();
        hMap.put("weekData",getWeek);
        return hMap;

    }

    @GetMapping("getThisMonthData")
    public Map<String,List<VisitorPass>>getMonthData(){
        Date date=new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM");
        List<VisitorPass>list=visitorPassRepository.getExcel(sdf1.format(date)+"-01",sdf.format(date));
        HashMap<String, List<VisitorPass>> hMap = new HashMap<>();
        hMap.put("monthData", list);
        return hMap;

    }
    @GetMapping("getLastMonthData")
        public Map<String,List<VisitorPass>>getLastMonthData(){
        Date date1=new Date(System.currentTimeMillis());
        SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -30);
        System.out.println(sdf.format(cal.getTime()));

        List<VisitorPass>getMonth=visitorPassRepository.getExcel(sdf.format(cal.getTime()), sdf.format(date1));
        HashMap<String,List<VisitorPass>>hMap=new HashMap<>();
        hMap.put("lastMonthData",getMonth);
        return hMap;

    }

    @GetMapping("getMostVisited")
        public Map<String,Long>getMostVisited()throws ParseException{
        Date date= new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<VisitorPass>list=visitorPassRepository.getTodayCheckIn(sdf.format(date));
        long mostVisitedTime=0;
        for(VisitorPass visitorPass:list){
            Date d1=sdf1.parse(visitorPass.getExpected_check_out());
            Date d2=sdf1.parse(visitorPass.getMeeting_date()+" "+visitorPass.getMeeting_time());
           long dif=d1.getTime()-d2.getTime();
           System.out.println(dif);
           if(dif>mostVisitedTime){
               mostVisitedTime=dif;
           }
        }
        long mvtMin=mostVisitedTime/(1000*60);
        HashMap<String,Long>hMap=new HashMap<>();
        hMap.put("mostVisited",mvtMin);
        return hMap;
    }
    @GetMapping("getVisitorWalkin")
    public Map<String,VisitorVsWalkin>getVisitorWalkin(@RequestParam("date")String date,
                                                         @RequestParam("to")String to){
        List<VisitorPass>list=visitorPassRepository.getExcel(date,to);
        List<Walkin>list1=walkinRepository.getExcel(date,to);
        HashMap<String,VisitorVsWalkin>hMap=new HashMap<>();
        VisitorVsWalkin visitorVsWalkin=new VisitorVsWalkin(list.size(),list1.size());
        hMap.put("visitor",visitorVsWalkin);
        return hMap;
    }
    @GetMapping("getPurposeOfVisit")
    public List<VisitPurpose>getVisitorPurpose(@RequestParam("date")String date,
                                                     @RequestParam("to")String to)
    {
        List<VisitorPass>list1=visitorPassRepository.getExcel(date,to);
        if (list1.size()!=0)
        {
            List<VisitPurpose> vpl = new ArrayList<>();
            for (VisitorPass ls : list1)
            {
                VisitPurpose vp = new VisitPurpose();
                vp.setPurpose(ls.getPurpose());
                vp.setBusiness_name(ls.getBusiness_name());

                vpl.add(vp);
            }
            return vpl;
        }
        return null;
    }
*/
    @PostMapping("insertVisitorPass")
    public String getVisitorPass(@RequestBody VisitorPass visitorPass) throws IOException, WriterException {
        String message="Successful";
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        visitorPass.setDate(sdf.format(date));
        VisitorPass visitorPass1=visitorPassRepository.save(visitorPass);
        if(!visitorPass1.getId().isEmpty()){
            message="inserted";
            String visitor="{\"name\":\""+visitorPass.getName()+"\",\"phone_no\":\""+visitorPass.getPhone_no()+"\"" +
                    ",\"whom_to_meet\":\""+visitorPass.getWhom_to_meet()+"\",\"purpose_of_visit\":\""+visitorPass.getPurpose_of_visit()+"\"" +
                    ",\"location\":\""+visitorPass.getLocation()+"\",\"email\":\""+visitorPass.getEmail()+"\"" +
                    ",\"id\":\""+visitorPass1.getId()+"\"}";

            QRCodeGenerator.generateQRCodeImage(visitor, 200,
                    200, "./src/main/resources/"+visitorPass.getName()+".png");
            QrCode qrCode=new QrCode();
            qrCode.setCode("./src/main/resources/"+visitorPass.getName()+".png");
            qrCode.setMobile_no(visitorPass.getPhone_no());
            qrcodeRepository.save(qrCode);
        }
        return message;
    }

    @GetMapping("getTodayData")
    public Map<String,List<VisitorPass>> getTodayData(){

        Date date= new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<VisitorPass>list=visitorPassRepository.getTodayData(sdf.format(date));
        HashMap<String,List<VisitorPass>>hMap=new HashMap<>();
        hMap.put("todayData",list);
        return hMap;
    }

    @GetMapping("getDateData")
    public Map<String,List<VisitorPass>>getDateData(@RequestParam("date")String date){
        List<VisitorPass>list=visitorPassRepository.getTodayData(date);
        HashMap<String,List<VisitorPass>>hMap=new HashMap<>();
        hMap.put("dateData",list);
        return hMap;
    }

    @PostMapping("getUpdated")
    public String getUpdated( @RequestParam("photo") MultipartFile multipartFile,
                            @RequestParam("id")String id,
                             @RequestParam("status")String status)throws IOException {
        String message="Updated";
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("photo", new Binary(BsonBinarySubType.BINARY, multipartFile.getBytes()));
        update.set("status", status);
        update.set("check_in",sdf.format(date));

        mongoTemplate.updateMulti(query, update, VisitorPass.class);
        return message;

    }

    @PostMapping("getVisitorUpdated")
    public String getStatusUpdated(@RequestParam("id")String id,
                                 @RequestParam("status")String status){
        String message="Updated";
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("status", status);
        mongoTemplate.updateMulti(query, update, VisitorPass.class);
        return message;
    }

    @PostMapping("getCheckOutUpdate")
    public String getCheckOutUpdated(@RequestParam("id")String id,
                                   @RequestParam("status")String status){

            String message="Updated";
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("status", status);
        update.set("check_out", sdf.format(date));
        mongoTemplate.updateMulti(query, update, VisitorPass.class);
        return message;
    }


    @GetMapping("getTodayCheckIn")
    public Map<String,List<VisitorPass>>getCheckInData(){
        Date date= new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<VisitorPass>list=visitorPassRepository.getVisitorActiveStatus("active", sdf.format(date));

        HashMap<String,List<VisitorPass>>hMap=new HashMap<>();
        hMap.put("checkIn",list);
        return hMap;

    }
    @GetMapping("getAllVisitor")
    public Map<String,List<VisitorPass>>getALlData(){
        List<VisitorPass>list=visitorPassRepository.findAll();
        HashMap<String,List<VisitorPass>>hMap=new HashMap<>();
        hMap.put("AllData",list);
        return hMap;
    }

    @GetMapping("getCloseStatusList")
    public Map<String,List<VisitorPass>>getCloseStatus(){
        List<VisitorPass>list=visitorPassRepository.getCloseStatus("close");
        HashMap<String,List<VisitorPass>>hMap=new HashMap<>();
        hMap.put("closeData",list);
        return hMap;
    }

}




