package com.vms.walkin;

import com.vms.visitorPass.VisitorPass;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController

public class WalkinController {
@Autowired
    WalkinRepository walkinRepository;
    @PostMapping("insertWalkin")
    public String insertVisitor(@RequestBody Walkin walkin) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        String message = "UnSuccessful";
        walkin.setMeeting_date(sdf.format(date));
        walkin.setMeeting_time(sdf2.format(date));
        Walkin walkin1 = walkinRepository.save(walkin);
        if (!walkin1.getId().isEmpty()) {
            message = "Successful";
        }
        return message;
    }
    @GetMapping("getTodayWalkin")
    public Map<String, Integer> getWalkin() {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<Walkin> list = walkinRepository.getWalkin(sdf.format(date));
        HashMap<String, Integer> hMap = new HashMap<>();
        hMap.put("data", list.size());
        return hMap;

    }
    @GetMapping("getAllWalkin")
    public Map<String, Integer> getAllVisitor() {
        List<Walkin> list = walkinRepository.findAll();
        HashMap<String, Integer> hMap = new HashMap<>();
        hMap.put("walkin", list.size());
        return hMap;
    }

    @GetMapping("getExcel")
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

        List<Walkin> walkins = walkinRepository.getExcel(date,to);

        try {
            Sheet sheet = workbook.createSheet("Walkin Pass");
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


            Cell cell0 = row0.createCell(0);
            Cell cell1 = row0.createCell(1);
            Cell cell2 = row0.createCell(2);
            Cell cell3 = row0.createCell(3);
            Cell cell4 = row0.createCell(4);
            Cell cell5 = row0.createCell(5);
            Cell cell6 = row0.createCell(6);
            Cell cell7 = row0.createCell(7);
            Cell cell8 = row0.createCell(8);


            cell0.setCellStyle(style0);
            cell1.setCellStyle(style0);
            cell2.setCellStyle(style0);
            cell3.setCellStyle(style0);
            cell4.setCellStyle(style0);
            cell5.setCellStyle(style0);
            cell6.setCellStyle(style0);
            cell7.setCellStyle(style0);
            cell8.setCellStyle(style0);


            cell0.setCellValue("phone_no");
            cell1.setCellValue("meeting_date");
            cell2.setCellValue("meeting_time");
            cell3.setCellValue("designation");
            cell4.setCellValue("gender");
            cell5.setCellValue("purpose");
            cell6.setCellValue("expected_check_out");
            cell7.setCellValue("business_name");
            cell8.setCellValue("no_of_person");


            int j = 1;
            for (Walkin walkin : walkins) {

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


                cell11.setCellStyle(style1);
                cell12.setCellStyle(style1);
                cell13.setCellStyle(style1);
                cell14.setCellStyle(style1);
                cell15.setCellStyle(style1);
                cell16.setCellStyle(style1);
                cell17.setCellStyle(style1);
                cell18.setCellStyle(style1);
                cell19.setCellStyle(style1);


                cell11.setCellValue(walkin.getPhone_no());
                cell12.setCellValue(walkin.getMeeting_date());
                cell13.setCellValue(walkin.getMeeting_time());
                cell14.setCellValue(walkin.getDesignation());
                cell15.setCellValue(walkin.getGender());
                cell16.setCellValue(walkin.getPurpose());
                cell17.setCellValue(walkin.getExpected_check_out());
                cell18.setCellValue(walkin.getBusiness_name());
                cell19.setCellValue(walkin.getNo_of_person());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Walkin> getWalkin =walkinRepository.findAll();
        try {
            Sheet sheet = workbook.createSheet("All Walkin List");
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


            Cell cell0 = row0.createCell(0);
            Cell cell1 = row0.createCell(1);
            Cell cell2 = row0.createCell(2);
            Cell cell3 = row0.createCell(3);
            Cell cell4 = row0.createCell(4);
            Cell cell5 = row0.createCell(5);
            Cell cell6 = row0.createCell(6);
            Cell cell7 = row0.createCell(7);
            Cell cell8 = row0.createCell(8);


            cell0.setCellStyle(style0);
            cell1.setCellStyle(style0);
            cell2.setCellStyle(style0);
            cell3.setCellStyle(style0);
            cell4.setCellStyle(style0);
            cell5.setCellStyle(style0);
            cell6.setCellStyle(style0);
            cell7.setCellStyle(style0);
            cell8.setCellStyle(style0);


            cell0.setCellValue("phone_no");
            cell1.setCellValue("meeting_date");
            cell2.setCellValue("meeting_time");
            cell3.setCellValue("designation");
            cell4.setCellValue("gender");
            cell5.setCellValue("purpose");
            cell6.setCellValue("expected_check_out");
            cell7.setCellValue("business_name");
            cell8.setCellValue("no_of_person");


            int j = 1;
            for (Walkin walkin : getWalkin) {

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



                cell11.setCellStyle(style1);
                cell12.setCellStyle(style1);
                cell13.setCellStyle(style1);
                cell14.setCellStyle(style1);
                cell15.setCellStyle(style1);
                cell16.setCellStyle(style1);
                cell17.setCellStyle(style1);
                cell18.setCellStyle(style1);
                cell19.setCellStyle(style1);


                cell11.setCellValue(walkin.getPhone_no());
                cell12.setCellValue(walkin.getMeeting_date());
                cell13.setCellValue(walkin.getMeeting_time());
                cell14.setCellValue(walkin.getDesignation());
                cell15.setCellValue(walkin.getGender());
                cell16.setCellValue(walkin.getPurpose());
                cell17.setCellValue(walkin.getExpected_check_out());
                cell18.setCellValue(walkin.getBusiness_name());
                cell19.setCellValue(walkin.getNo_of_person());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Date date1 = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        response1.setHeader("content-disposition", "attachment;filename=Walkin_Pass" + sdf2.format(date1) + ".xls");
        workbook.write(response1.getOutputStream());

    }

   @GetMapping("getWalkinData")
   public Map<String,List<Walkin>>getWeekData(){
       Date date1=new Date(System.currentTimeMillis());
       Date date2=new Date(System.currentTimeMillis()-10080*60000);
       SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");
       System.out.println(sdf.format(date2));

       List<Walkin>getWalkin=walkinRepository.getExcel(sdf.format(date2), sdf.format(date1));
       HashMap<String,List<Walkin>>hMap=new HashMap<>();
       hMap.put("weekData",getWalkin);
       return hMap;

   }
    @GetMapping("getThisMonthWalkinData")
    public Map<String,List<Walkin>>getMonthWalkinData() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM");
        List<Walkin> list = walkinRepository.getExcel(sdf1.format(date) + "-01", sdf.format(date));
        HashMap<String, List<Walkin>> hMap = new HashMap<>();
        hMap.put("monthData", list);
        return hMap;

    }
    @GetMapping("getLastMonthWalkinData")
    public Map<String,List<Walkin>>getLastMonthData(){
        Date date1=new Date(System.currentTimeMillis());
        // Date date2=new Date(System.currentTimeMillis()-43200*60000);
        SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -30);
        System.out.println(sdf.format(cal.getTime()));

        List<Walkin>getMonth=walkinRepository.getExcel(sdf.format(cal.getTime()), sdf.format(date1));
        HashMap<String,List<Walkin>>hMap=new HashMap<>();
        hMap.put("lastMonthData",getMonth);
        return hMap;

    }


}
