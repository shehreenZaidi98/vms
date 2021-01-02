package com.vms.carrier;

import com.vms.visitorPass.VisitorPass;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class CarrierController {
    @Autowired
    CarrierRepository carrierRepository;
    @Autowired
    MongoTemplate mongoTemplate;
    @PostMapping("insertCarrier")
    public String insertCarrier(@RequestBody Carrier carrier){
        String message="Successful";
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        carrier.setDate(sdf.format(date));
       Carrier carrier1=carrierRepository.save(carrier);
       if(!carrier1.getId().isEmpty()){
           message="inserted";
       }
       return message;

    }
    @PostMapping("getStatusUpdated")
    public String getUpdated(@RequestParam("id")String id,
                           @RequestParam("status")String status){
        String message="Updated";
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("status", status);
        mongoTemplate.updateMulti(query, update, Carrier.class);

        return message;
    }

    @PostMapping("getCheckInUpdated")
    public String getCheckinUpdated(@RequestParam("id")String id,
                                  @RequestParam("status")String status){
        String message="Updated";
        Date date= new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("status", status);
        update.set("check_in", sdf.format(date));
        mongoTemplate.updateMulti(query, update, Carrier.class);
        return message;
    }

    @PostMapping("insertCheckOutUpdated")
    public String getCheckOutUpdated(@RequestParam("id")String id,
                                   @RequestParam("status")String status){
        String  message="Updated";
        Date date= new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("status", status);
        update.set("check_out", sdf.format(date));
        mongoTemplate.updateMulti(query, update, Carrier.class);
        return  message;

    }

    @GetMapping("uploadCarrierExcel")
    public void createOrderSheet(HttpServletResponse response1, @RequestParam("date")String date,
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

        List<Carrier> carriersPassList = carrierRepository.getExcel(date,to);

        try {
            Sheet sheet = workbook.createSheet("Carrier Pass");
            Row row0 = sheet.createRow(0);

            row0.setHeight((short) 600);
            sheet.setColumnWidth(0, 5000);
            sheet.setColumnWidth(3, 5000);
            sheet.setColumnWidth(2, 5000);
            sheet.setColumnWidth(1, 5000);
            sheet.setColumnWidth(4, 5000);
            sheet.setColumnWidth(5, 5000);
            sheet.setColumnWidth(6, 5000);




            Cell cell0 = row0.createCell(0);
            Cell cell1 = row0.createCell(1);
            Cell cell2 = row0.createCell(2);
            Cell cell3 = row0.createCell(3);
            Cell cell4 = row0.createCell(4);
            Cell cell5 = row0.createCell(5);
            Cell cell6 = row0.createCell(6);



            cell0.setCellStyle(style0);
            cell1.setCellStyle(style0);
            cell2.setCellStyle(style0);
            cell3.setCellStyle(style0);
            cell4.setCellStyle(style0);
            cell5.setCellStyle(style0);
            cell6.setCellStyle(style0);




            cell0.setCellValue("driver_name");
            cell1.setCellValue("mobile_no");
            cell2.setCellValue("vehicle");
            cell3.setCellValue("date");
            cell4.setCellValue("status");
            cell5.setCellValue("check_in");
            cell6.setCellValue("check_out");



            int j = 1;
            for (Carrier carrier : carriersPassList) {

                Row row1 = sheet.createRow(j++);
                Cell cell11 = row1.createCell(0);
                Cell cell12 = row1.createCell(1);
                Cell cell13 = row1.createCell(2);

                Cell cell14 = row1.createCell(3);
                Cell cell15 = row1.createCell(4);
                Cell cell16 = row1.createCell(5);
                Cell cell17 = row1.createCell(6);




                cell11.setCellStyle(style1);
                cell12.setCellStyle(style1);
                cell13.setCellStyle(style1);
                cell14.setCellStyle(style1);
                cell15.setCellStyle(style1);
                cell16.setCellStyle(style1);
                cell17.setCellStyle(style1);



                cell11.setCellValue(carrier.getDriver_name());
                cell12.setCellValue(carrier.getMobile_no());
                cell13.setCellValue(carrier.getVehicle());

                cell14.setCellValue(carrier.getDate());
                cell15.setCellValue(carrier.getStatus());
                cell16.setCellValue(carrier.getCheck_in());
                cell17.setCellValue(carrier.getCheck_out());


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Carrier> carriers =carrierRepository.findAll();
        try {
            Sheet sheet = workbook.createSheet("All Carrier List");
            Row row0 = sheet.createRow(0);

            row0.setHeight((short) 600);
            sheet.setColumnWidth(0, 5000);
            sheet.setColumnWidth(3, 5000);
            sheet.setColumnWidth(2, 5000);
            sheet.setColumnWidth(1, 5000);
            sheet.setColumnWidth(4, 5000);
            sheet.setColumnWidth(5, 5000);
            sheet.setColumnWidth(6, 5000);



            Cell cell0 = row0.createCell(0);
            Cell cell1 = row0.createCell(1);
            Cell cell2 = row0.createCell(2);
            Cell cell3 = row0.createCell(3);
            Cell cell4 = row0.createCell(4);
            Cell cell5 = row0.createCell(5);
            Cell cell6 = row0.createCell(6);


            cell0.setCellStyle(style0);
            cell1.setCellStyle(style0);
            cell2.setCellStyle(style0);
            cell3.setCellStyle(style0);
            cell4.setCellStyle(style0);
            cell5.setCellStyle(style0);
            cell6.setCellStyle(style0);



            cell0.setCellValue("driver_name");
            cell1.setCellValue("mobile_no");
            cell2.setCellValue("vehicle");
            cell3.setCellValue("date");
            cell4.setCellValue("status");
            cell5.setCellValue("check_in");
            cell6.setCellValue("check_out");



            int j = 1;
            for (Carrier carrier : carriers) {

                Row row1 = sheet.createRow(j++);
                Cell cell11 = row1.createCell(0);
                Cell cell12 = row1.createCell(1);
                Cell cell13 = row1.createCell(2);
                Cell cell14 = row1.createCell(3);
                Cell cell15 = row1.createCell(4);
                Cell cell16 = row1.createCell(5);
                Cell cell17 = row1.createCell(6);




                cell11.setCellStyle(style1);
                cell12.setCellStyle(style1);
                cell13.setCellStyle(style1);
                cell14.setCellStyle(style1);
                cell15.setCellStyle(style1);
                cell16.setCellStyle(style1);
                cell17.setCellStyle(style1);


                cell11.setCellValue(carrier.getDriver_name());
                cell12.setCellValue(carrier.getMobile_no());
                cell13.setCellValue(carrier.getVehicle());
                cell14.setCellValue(carrier.getDate());
                cell15.setCellValue(carrier.getStatus());

                cell16.setCellValue(carrier.getCheck_in());
                cell17.setCellValue(carrier.getCheck_out());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Date date1 = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        response1.setHeader("content-disposition", "attachment;filename=Carrier_Pass" + sdf2.format(date1) + ".xls");
        workbook.write(response1.getOutputStream());

    }

    @GetMapping("getCarrierTodayData")
    public Map<String,List<Carrier>> getTodayData(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<Carrier>list=carrierRepository.getTodayData(sdf.format(date));
        HashMap<String,List<Carrier>>hMap=new HashMap<>();
        hMap.put("todayData",list);
        return hMap;
    }

    @GetMapping("getCheckInData")
    public Map<String,List<Carrier>>getCheckInData(){
        Date date= new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<Carrier>list=carrierRepository.getActiveStatus("active", sdf.format(date));

        HashMap<String,List<Carrier>>hMap=new HashMap<>();
        hMap.put("checkIn",list);
        return hMap;
    }

    @GetMapping("getAllCarrier")
    public Map<String,List<Carrier>>getALlData() {
        List<Carrier> list = carrierRepository.findAll();
        HashMap<String, List<Carrier>> hMap = new HashMap<>();
        hMap.put("AllData", list);
        return hMap;
    }


    @GetMapping("getCarrierCloseStatusList")
    public Map<String,List<Carrier>>getCloseStatus(){
        List<Carrier>list=carrierRepository.getCloseCarrierStatus("close");
        HashMap<String,List<Carrier>>hMap=new HashMap<>();
        hMap.put("closeData",list);
        return hMap;
    }


}
