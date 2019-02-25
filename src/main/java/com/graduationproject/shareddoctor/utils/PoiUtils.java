package com.graduationproject.shareddoctor.utils;

import com.graduationproject.shareddoctor.Entity.Depart;
import com.graduationproject.shareddoctor.Entity.Doctor;
import com.graduationproject.shareddoctor.Entity.Patient;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Create by cy on 2018/5/14
 */


public class PoiUtils {

    public static List<Patient> importPatient2List(MultipartFile file) {
        List<Patient> patients = new ArrayList<>();
        try {
            FileInputStream fi = (FileInputStream) file.getInputStream();
            XSSFWorkbook workbook = new XSSFWorkbook(fi);
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                Patient patient;
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    if (j == 0) {
                        continue;//标题行
                    }
                    XSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;//没数据
                    }
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    patient = new Patient();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        XSSFCell cell = row.getCell(k);
                        switch (cell.getCellTypeEnum()) {
                            case STRING: {
                                String cellValue = cell.getStringCellValue();
                                if (cellValue == null) {
                                    cellValue = "";
                                }
                                switch (k) {
                                    case 0:
                                        patient.setPatientName(cellValue);
                                        break;
//                                    case 3:
//                                        patient.setEmail(cellValue);
//                                        break;
                                }
                            }
                            break;
                            case NUMERIC: {
//                                DecimalFormat df = new DecimalFormat("0");
//                                String phone = df.format(cell.getNumericCellValue());
                                switch (k) {
                                    case 1:
                                        patient.setGender((int)cell.getNumericCellValue());

                                    case 2:
                                        patient.setAge((int)cell.getNumericCellValue());
                                        break;
                                }
                            }
                            break;
                        }
                    }
                    patients.add(patient);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patients;
    }

    public static List<Doctor> importDoctor2List(MultipartFile file) {
        List<Doctor> doctors = new ArrayList<>();
        try {
            FileInputStream fi = (FileInputStream) file.getInputStream();
            XSSFWorkbook workbook = new XSSFWorkbook(fi);
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                Doctor doctor;
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    if (j == 0) {
                        continue;//标题行
                    }
                    XSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;//没数据
                    }
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    doctor = new Doctor();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        XSSFCell cell = row.getCell(k);
                        switch (cell.getCellTypeEnum()) {
                            case STRING: {
                                String cellValue = cell.getStringCellValue();
                                if (cellValue == null) {
                                    cellValue = "";
                                }
                                switch (k) {
                                    case 0:
                                        doctor.setDoctorName(cellValue);
                                        break;
                                }
                            }
                            break;
                            case NUMERIC: {
                                DecimalFormat df = new DecimalFormat("0");
                                String phone = df.format(cell.getNumericCellValue());
                                switch (k) {
                                    case 1:
                                        doctor.setGender((int)cell.getNumericCellValue());

                                    case 2:
                                        doctor.setAge((int)cell.getNumericCellValue());
                                        break;
//                                    case 2:
//                                        doctor.setPhone(phone);
//                                        break;
                                }
                            }
                            break;
                        }
                    }
                    doctors.add(doctor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public static List<Depart> importDepart2List(MultipartFile file){
        List<Depart> departs = new ArrayList<>();
        try {
            FileInputStream fi = (FileInputStream) file.getInputStream();
            XSSFWorkbook workbook = new XSSFWorkbook(fi);
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                Depart depart;
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    if (j == 0) {
                        continue;//标题行
                    }
                    XSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;//没数据
                    }
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    depart=new Depart();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        XSSFCell cell = row.getCell(k);
                        switch (cell.getCellTypeEnum()) {
                            case STRING: {
                                String cellValue = cell.getStringCellValue();
                                if (cellValue == null) {
                                    cellValue = "";
                                }
                                switch (k) {
                                    case 0:
                                        depart.setDepartName(cellValue);
                                        break;
                                }
                            }
                            break;
                        }
                    }
                    departs.add(depart);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return departs;
    }
}
