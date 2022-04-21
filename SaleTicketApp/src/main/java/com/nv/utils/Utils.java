/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Alert;

/**
 *
 * @author DangNgocHoaiNam
 */
public class Utils {
     public static Alert getBox(String msg, Alert.AlertType type) {
        Alert a = new Alert(type);
        a.setContentText(msg);
        
        return a;
    }
     
    public static final LocalDate LOCAL_DATE (String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
    return localDate;
}
}
