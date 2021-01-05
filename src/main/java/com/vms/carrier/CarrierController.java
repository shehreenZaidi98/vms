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
            sheet.setColumnWidth(7, 5000);
            sheet.setColumnWidth(8, 5000);
            sheet.setColumnWidth(9, 5000);
            sheet.setColumnWidth(10, 5000);
            sheet.setColumnWidth(11, 5000);
            sheet.setColumnWidth(12, 5000);
            sheet.setColumnWidth(13, 5000);
            sheet.setColumnWidth(14, 5000);
            sheet.setColumnWidth(15, 5000);
            sheet.setColumnWidth(16, 5000);
            sheet.setColumnWidth(17, 5000);
            sheet.setColumnWidth(18, 5000);
            sheet.setColumnWidth(19, 5000);
            sheet.setColumnWidth(20, 5000);
            sheet.setColumnWidth(21, 5000);
            sheet.setColumnWidth(22, 5000);





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
            Cell cell10 = row0.createCell(10);
            Cell cell11= row0.createCell(11);
            Cell cell12 = row0.createCell(12);
            Cell cell13= row0.createCell(13);
            Cell cell14= row0.createCell(14);
            Cell cell15= row0.createCell(15);
            Cell cell16= row0.createCell(16);
            Cell cell17 = row0.createCell(17);
            Cell cell18 = row0.createCell(18);
            Cell cell19= row0.createCell(19);
            Cell cell20 = row0.createCell(20);
            Cell cell21 = row0.createCell(21);
            Cell cell22= row0.createCell(22);



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
            cell10.setCellStyle(style0);
            cell11.setCellStyle(style0);
            cell12.setCellStyle(style0);
            cell13.setCellStyle(style0);
            cell14.setCellStyle(style0);
            cell15.setCellStyle(style0);
            cell16.setCellStyle(style0);
            cell17.setCellStyle(style0);
            cell18.setCellStyle(style0);
            cell19.setCellStyle(style0);
            cell20.setCellStyle(style0);
            cell21.setCellStyle(style0);
            cell22.setCellStyle(style0);




            cell0.setCellValue("driver_name");
            cell1.setCellValue("mobile_no");
            cell2.setCellValue("vehicle");
            cell3.setCellValue("date");
            cell4.setCellValue("status");
            cell5.setCellValue("check_in");
            cell6.setCellValue("check_out");
            cell7.setCellValue("vehicle_no");
            cell8.setCellValue("lic_no");
            cell9.setCellValue("email");
            cell10.setCellValue("location");
            cell11.setCellValue("purpose_of_visit");
            cell12.setCellValue("whom_to_meet");
            cell13.setCellValue("gender");
            cell14.setCellValue("department");
            cell15.setCellValue("nationality");
            cell16.setCellValue("pass_no");
            cell17.setCellValue("id_type");
            cell18.setCellValue("id_no");
            cell19.setCellValue("no_of_visitors");
            cell20.setCellValue("address");
            cell21.setCellValue("item_carried");
            cell22.setCellValue("serial_no");



            int j = 1;
            for (Carrier carrier : carriersPassList) {

                Row row1 = sheet.createRow(j++);
                Cell cell111= row1.createCell(0);
                Cell cell121 = row1.createCell(1);
                Cell cell131 = row1.createCell(2);
                Cell cell141 = row1.createCell(3);
                Cell cell151 = row1.createCell(4);
                Cell cell161 = row1.createCell(5);
                Cell cell171 = row1.createCell(6);
                Cell cell181 = row1.createCell(7);
                Cell cell191 = row1.createCell(8);
                Cell cell120 = row1.createCell(9);
                Cell cell122 = row1.createCell(10);
                Cell cell123= row1.createCell(11);
                Cell cell124 = row1.createCell(12);
                Cell cell125= row1.createCell(13);
                Cell cell126 = row1.createCell(14);
                Cell cell127= row1.createCell(15);
                Cell cell128 = row1.createCell(16);
                Cell cell129 = row1.createCell(17);
                Cell cell130 = row1.createCell(18);
                Cell cell132 = row1.createCell(19);
                Cell cell133 = row1.createCell(20);
                Cell cell134= row1.createCell(21);
                Cell cell135 = row1.createCell(22);




                cell111.setCellStyle(style1);
                cell121.setCellStyle(style1);
                cell131.setCellStyle(style1);
                cell141.setCellStyle(style1);
                cell151.setCellStyle(style1);
                cell161.setCellStyle(style1);
                cell171.setCellStyle(style1);
                cell181.setCellStyle(style1);
                cell191.setCellStyle(style1);
                cell120.setCellStyle(style1);
                cell122.setCellStyle(style1);
                cell123.setCellStyle(style1);
                cell124.setCellStyle(style1);
                cell125.setCellStyle(style1);
                cell126.setCellStyle(style1);
                cell127.setCellStyle(style1);
                cell128.setCellStyle(style1);
                cell129.setCellStyle(style1);
                cell130.setCellStyle(style1);
                cell132.setCellStyle(style1);
                cell133.setCellStyle(style1);
                cell134.setCellStyle(style1);
                cell135.setCellStyle(style1);



                cell111.setCellValue(carrier.getDriver_name());
                cell121.setCellValue(carrier.getMobile_no());
                cell131.setCellValue(carrier.getVehicle());
                cell141.setCellValue(carrier.getDate());
                cell151.setCellValue(carrier.getStatus());
                cell161.setCellValue(carrier.getCheck_in());
                cell171.setCellValue(carrier.getCheck_out());
                cell181.setCellValue(carrier.getVehicle_no());
                cell191.setCellValue(carrier.getLic_no());
                cell120.setCellValue(carrier.getEmail());
                cell122.setCellValue(carrier.getLocation());
                cell123.setCellValue(carrier.getPurpose_of_visit());
                cell124.setCellValue(carrier.getWhom_to_meet());
                cell125.setCellValue(carrier.getGender());
                cell126.setCellValue(carrier.getDepartment());
                cell127.setCellValue(carrier.getNationality());
                cell128.setCellValue(carrier.getPass_no());
                cell129.setCellValue(carrier.getId_type());
                cell130.setCellValue(carrier.getId_no());
                cell132.setCellValue(carrier.getNo_of_visitors());
                cell133.setCellValue(carrier.getAddress());
                cell134.setCellValue(carrier.getItem_carried());
                cell135.setCellValue(carrier.getSerial_no());


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
            sheet.setColumnWidth(7, 5000);
            sheet.setColumnWidth(8, 5000);
            sheet.setColumnWidth(9, 5000);
            sheet.setColumnWidth(10, 5000);
            sheet.setColumnWidth(11, 5000);
            sheet.setColumnWidth(12, 5000);
            sheet.setColumnWidth(13, 5000);
            sheet.setColumnWidth(14, 5000);
            sheet.setColumnWidth(15, 5000);
            sheet.setColumnWidth(16, 5000);
            sheet.setColumnWidth(17, 5000);
            sheet.setColumnWidth(18, 5000);
            sheet.setColumnWidth(19, 5000);
            sheet.setColumnWidth(20, 5000);
            sheet.setColumnWidth(21, 5000);
            sheet.setColumnWidth(22, 5000);




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
            Cell cell10 = row0.createCell(10);
            Cell cell11= row0.createCell(11);
            Cell cell12 = row0.createCell(12);
            Cell cell13= row0.createCell(13);
            Cell cell14= row0.createCell(14);
            Cell cell15= row0.createCell(15);
            Cell cell16= row0.createCell(16);
            Cell cell17 = row0.createCell(17);
            Cell cell18 = row0.createCell(18);
            Cell cell19= row0.createCell(19);
            Cell cell20 = row0.createCell(20);
            Cell cell21 = row0.createCell(21);
            Cell cell22= row0.createCell(22);




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
            cell10.setCellStyle(style0);
            cell11.setCellStyle(style0);
            cell12.setCellStyle(style0);
            cell13.setCellStyle(style0);
            cell14.setCellStyle(style0);
            cell15.setCellStyle(style0);
            cell16.setCellStyle(style0);
            cell17.setCellStyle(style0);
            cell18.setCellStyle(style0);
            cell19.setCellStyle(style0);
            cell20.setCellStyle(style0);
            cell21.setCellStyle(style0);
            cell22.setCellStyle(style0);



            cell0.setCellValue("driver_name");
            cell1.setCellValue("mobile_no");
            cell2.setCellValue("vehicle");
            cell3.setCellValue("date");
            cell4.setCellValue("status");
            cell5.setCellValue("check_in");
            cell6.setCellValue("check_out");
            cell7.setCellValue("vehicle_no");
            cell8.setCellValue("lic_no");
            cell9.setCellValue("email");
            cell10.setCellValue("location");
            cell11.setCellValue("purpose_of_visit");
            cell12.setCellValue("whom_to_meet");
            cell13.setCellValue("gender");
            cell14.setCellValue("department");
            cell15.setCellValue("nationality");
            cell16.setCellValue("pass_no");
            cell17.setCellValue("id_type");
            cell18.setCellValue("id_no");
            cell19.setCellValue("no_of_visitors");
            cell20.setCellValue("address");
            cell21.setCellValue("item_carried");
            cell22.setCellValue("serial_no");



            int j = 1;
            for (Carrier carrier : carriers) {

                Row row1 = sheet.createRow(j++);
                Cell cell111= row1.createCell(0);
                Cell cell121 = row1.createCell(1);
                Cell cell131 = row1.createCell(2);
                Cell cell141 = row1.createCell(3);
                Cell cell151 = row1.createCell(4);
                Cell cell161 = row1.createCell(5);
                Cell cell171 = row1.createCell(6);
                Cell cell181 = row1.createCell(7);
                Cell cell191 = row1.createCell(8);
                Cell cell120 = row1.createCell(9);
                Cell cell122 = row1.createCell(10);
                Cell cell123= row1.createCell(11);
                Cell cell124 = row1.createCell(12);
                Cell cell125= row1.createCell(13);
                Cell cell126 = row1.createCell(14);
                Cell cell127= row1.createCell(15);
                Cell cell128 = row1.createCell(16);
                Cell cell129 = row1.createCell(17);
                Cell cell130 = row1.createCell(18);
                Cell cell132 = row1.createCell(19);
                Cell cell133 = row1.createCell(20);
                Cell cell134= row1.createCell(21);
                Cell cell135 = row1.createCell(22);



                cell111.setCellStyle(style1);
                cell121.setCellStyle(style1);
                cell131.setCellStyle(style1);
                cell141.setCellStyle(style1);
                cell151.setCellStyle(style1);
                cell161.setCellStyle(style1);
                cell171.setCellStyle(style1);
                cell181.setCellStyle(style1);
                cell191.setCellStyle(style1);
                cell120.setCellStyle(style1);
                cell122.setCellStyle(style1);
                cell123.setCellStyle(style1);
                cell124.setCellStyle(style1);
                cell125.setCellStyle(style1);
                cell126.setCellStyle(style1);
                cell127.setCellStyle(style1);
                cell128.setCellStyle(style1);
                cell129.setCellStyle(style1);
                cell130.setCellStyle(style1);
                cell132.setCellStyle(style1);
                cell133.setCellStyle(style1);
                cell134.setCellStyle(style1);
                cell135.setCellStyle(style1);



                cell111.setCellValue(carrier.getDriver_name());
                cell121.setCellValue(carrier.getMobile_no());
                cell131.setCellValue(carrier.getVehicle());
                cell141.setCellValue(carrier.getDate());
                cell151.setCellValue(carrier.getStatus());
                cell161.setCellValue(carrier.getCheck_in());
                cell171.setCellValue(carrier.getCheck_out());
                cell181.setCellValue(carrier.getVehicle_no());
                cell191.setCellValue(carrier.getLic_no());
                cell120.setCellValue(carrier.getEmail());
                cell122.setCellValue(carrier.getLocation());
                cell123.setCellValue(carrier.getPurpose_of_visit());
                cell124.setCellValue(carrier.getWhom_to_meet());
                cell125.setCellValue(carrier.getGender());
                cell126.setCellValue(carrier.getDepartment());
                cell127.setCellValue(carrier.getNationality());
                cell128.setCellValue(carrier.getPass_no());
                cell129.setCellValue(carrier.getId_type());
                cell130.setCellValue(carrier.getId_no());
                cell132.setCellValue(carrier.getNo_of_visitors());
                cell133.setCellValue(carrier.getAddress());
                cell134.setCellValue(carrier.getItem_carried());
                cell135.setCellValue(carrier.getSerial_no());

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
