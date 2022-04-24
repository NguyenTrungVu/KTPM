/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.utils;

import com.nv.pojo.ChiTietVeXe;
import com.nv.pojo.ChuyenXe;
import com.nv.pojo.ThongTinCacChuyenXe;
import com.nv.pojo.ThongTinVeXe;
import com.nv.pojo.VeXe;
import com.nv.saleticketapp.FXMLTraCuuChuyenDiController;
import com.nv.services.DuLieuChiTietVeXe;
import com.nv.services.DuLieuChuyenXe;
import com.nv.services.DuLieuTuyenXe;
import com.nv.services.DuLieuVeXe;
import com.nv.services.DuLieuXe;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    
    public static int soSanhGio(String gioHienTai, String gioKhoiHanh){
    
        
        String[] a = gioHienTai.split(":");
        String[] b = gioKhoiHanh.split(":");
        int soPhutHienTai = 0;
        int soPhutKhoiHanh = 0;
        
        for(int i = 0; i < a.length - 1; i++){
        
            if(i == 0)
            {
                soPhutHienTai += Integer.parseInt(a[i]) * 60;
                soPhutKhoiHanh += Integer.parseInt(b[i]) * 60;
            }
                
            else{
            
                  soPhutHienTai += Integer.parseInt(a[i]);
                soPhutKhoiHanh += Integer.parseInt(b[i]);
            }
              
        }
        return soPhutKhoiHanh - soPhutHienTai;
    }
    
    public static void traCuuChuyenDi(ComboBox<String> cbNoiDi, ComboBox<String> cbNoiDen, DatePicker dpNgayDi, TableView<ThongTinCacChuyenXe> tbThongTin) throws SQLException{


        DuLieuTuyenXe d = new DuLieuTuyenXe();
        DuLieuVeXe v = new DuLieuVeXe();
        DuLieuChuyenXe c = new DuLieuChuyenXe();
        DuLieuChiTietVeXe chitiet = new DuLieuChiTietVeXe();
        DuLieuXe x = new DuLieuXe();
        
        String ngay;
        
        if (cbNoiDi.getValue() == null || cbNoiDen.getValue() == null){
            Utils.getBox("Noi di va noi den khong duoc bo trong", Alert.AlertType.INFORMATION).show();
            
        }
        
        if(dpNgayDi.getValue() == null){
        
            ngay = java.time.LocalDate.now().toString(); 
        }
        else{
        
            ngay = dpNgayDi.getValue().toString();
        }

        
        int maTuyen = d.getMaTuyen(cbNoiDi.getValue().toString(), cbNoiDen.getValue().toString());
        
        List<ChuyenXe> cacChuyenXe = c.timKiemChuyenXe(maTuyen, ngay);
        
        if(maTuyen == 0 || cacChuyenXe.size() == 0){
        
            for ( int i = 0; i<tbThongTin.getItems().size(); i++) {
                tbThongTin.getItems().clear();
            }
            Utils.getBox("Hien tai chua co chuyen di cua ban", Alert.AlertType.INFORMATION).show();
            
        }
        else{
        
        List<ThongTinCacChuyenXe> list = new ArrayList<>();
        
        
        for (ChuyenXe a : cacChuyenXe){

            int soGheTrong = x.getSoLuongGhe(a.getMaXe()) - v.getMaVeXe(a.getMaChuyenXe()).size();

            ThongTinCacChuyenXe info = new ThongTinCacChuyenXe(a.getMaChuyenXe(), cbNoiDi.getValue().toString(), cbNoiDen.getValue().toString(), ngay, a.getGioKhoiHanh(), a.getGia(), soGheTrong);
            list.add(info);
        }
        
        loadTableData(list, tbThongTin);
        }
        
    }
    
    public static void loadTableViewChuyenDi(TableView tableview){
    
        TableColumn colMaChuyenXe = new TableColumn("Ma Chuyen Xe");
        colMaChuyenXe.setCellValueFactory(new PropertyValueFactory("maChuyenXe"));
        colMaChuyenXe.setPrefWidth(170);

        TableColumn colNoiDi = new TableColumn("Noi di");
        colNoiDi.setCellValueFactory(new PropertyValueFactory("noiDi"));
        colNoiDi.setPrefWidth(100);

        TableColumn colNoiDen = new TableColumn("Noi den");
        colNoiDen.setCellValueFactory(new PropertyValueFactory("noiDen"));
        colNoiDen.setPrefWidth(100);

        TableColumn colNgayDi = new TableColumn("Ngay Di");
        colNgayDi.setCellValueFactory(new PropertyValueFactory("ngayDi"));
        colNgayDi.setPrefWidth(150);

        
        TableColumn colGioKhoiHanh = new TableColumn("Gio di");
        colGioKhoiHanh.setCellValueFactory(new PropertyValueFactory("gioKhoiHanh"));
        colGioKhoiHanh.setPrefWidth(100);

        TableColumn colGia = new TableColumn("Gia tien");
        colGia.setCellValueFactory(new PropertyValueFactory("gia"));
        colGia.setPrefWidth(110);

        
        TableColumn colGheTrong = new TableColumn("Con trong");
        colGheTrong.setCellValueFactory(new PropertyValueFactory("gheConTrong"));
        colGheTrong.setPrefWidth(100);

        
        tableview.getColumns().addAll(colMaChuyenXe, colNoiDi, colNoiDen, colNgayDi, colGioKhoiHanh, colGia, colGheTrong);
        
    }
    
    public static void loadTableData(List<ThongTinCacChuyenXe> list, TableView tableview){
        
        tableview.setItems(FXCollections.observableList(list));
    }
    
    public static void xuLiComboBoxNoiDi(ComboBox<String> cbNoiDi){
    
        DuLieuTuyenXe d = new DuLieuTuyenXe();
        
        List<String> name = new ArrayList<>();
        
        try {
            for(int i = 0; i < d.getTuyenXe().size(); i++){
                
                name.add(d.getTuyenXe().get(i).getNoiDi());
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLTraCuuChuyenDiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<String> list = new ArrayList<>();
        
        list = xoaPhanTuTrung(name);
                
        cbNoiDi.setItems(FXCollections.observableList(list));
        
    }
    
     public static void xuLiComboBoxNoiDen(ComboBox<String> cbNoiDen){
    
        DuLieuTuyenXe d = new DuLieuTuyenXe();
        
        List<String> name = new ArrayList<>();
        
        try {
            for(int i = 0; i < d.getTuyenXe().size(); i++){
                
                name.add(d.getTuyenXe().get(i).getNoiDen());
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLTraCuuChuyenDiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<String> list = new ArrayList<>();
        
        list = xoaPhanTuTrung(name);
                
        cbNoiDen.setItems(FXCollections.observableList(list));
        
    }
     
     public static void loadViTriGhe(ComboBox<Integer> viTriGhe, List<Integer> viTriDaDat, int soLuongGhe){

         
         List<Integer> viTri = new ArrayList<>();
         for(int i =1; i <= soLuongGhe; i++){
             if(viTriDaDat.contains(i) == false)
                viTri.add(i);
         }
         
         viTriGhe.setItems(FXCollections.observableList(viTri));
     }
     
     public static void loadViTriGhe2(ComboBox<Integer> viTriGhe, int soLuongGhe, ThongTinCacChuyenXe t){
        DuLieuVeXe v = new DuLieuVeXe();
        DuLieuChiTietVeXe chiTietVeXe = new DuLieuChiTietVeXe();
        DuLieuXe x = new DuLieuXe();
        DuLieuChuyenXe chuyenXe = new DuLieuChuyenXe();
        List<Integer> viTriGheDaDat = new ArrayList<>();
        List<Integer> maVeDaDat = new ArrayList<>();

        try {
            for(VeXe ve: v.getVeXe()){
                if(ve.getMaChuyenXe() == t.getMaChuyenXe())
                    maVeDaDat.add(ve.getMaVe());

            }
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }



        try {
            for(ChiTietVeXe c: chiTietVeXe.getChiTietVeXe()){

                if(maVeDaDat.contains(c.getMaVe()))
                    viTriGheDaDat.add(c.getViTriGhe());

            }
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

        int maXe = 0;

        try {
            maXe = chuyenXe.getMaXeByMa(t.getMaChuyenXe());
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
        List<Integer> viTri = new ArrayList<>();
        for(int i =1; i <= soLuongGhe; i++){
         if(viTriGheDaDat.contains(i) == false)
            viTri.add(i);
        }

         viTriGhe.setItems(FXCollections.observableList(viTri));

     }
     
     
    public static void loadViTriGhe3(ComboBox<Integer> viTriGhe, int soLuongGhe, int maChuyen){
        DuLieuVeXe v = new DuLieuVeXe();
        DuLieuChiTietVeXe chiTietVeXe = new DuLieuChiTietVeXe();
        DuLieuXe x = new DuLieuXe();
        DuLieuChuyenXe chuyenXe = new DuLieuChuyenXe();
        List<Integer> viTriGheDaDat = new ArrayList<>();
        List<Integer> maVeDaDat = new ArrayList<>();

        try {
            for(VeXe ve: v.getVeXe()){
                if(ve.getMaChuyenXe() == maChuyen)
                    maVeDaDat.add(ve.getMaVe());

            }
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }



        try {
            for(ChiTietVeXe c: chiTietVeXe.getChiTietVeXe()){

                if(maVeDaDat.contains(c.getMaVe()))
                    viTriGheDaDat.add(c.getViTriGhe());

            }
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }

        int maXe = 0;

        try {
            maXe = chuyenXe.getMaXeByMa(maChuyen);
        } catch (SQLException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
        List<Integer> viTri = new ArrayList<>();
        for(int i =1; i <= soLuongGhe; i++){
         if(viTriGheDaDat.contains(i) == false)
            viTri.add(i);
        }

         viTriGhe.setItems(FXCollections.observableList(viTri));

     }
     
     public static List<String> xoaPhanTuTrung(List<String> list){
    
         // tạo 1 ArrayList arrTemp
        ArrayList<String> arrTemp = new ArrayList<>();

        // thêm các phần tử của arrListNumber vào arrTemp
        // nếu trong arrTemp đã tồn tại phần tử giống trong arrListNumber
        // thì không thêm vào, ngược lại thêm bình thường
        for (int i = 0; i < list.size(); i++) {
            if (!arrTemp.contains(list.get(i))) {
                arrTemp.add(list.get(i));
            }
        }

        list.clear();

        list.addAll(arrTemp);
        
        return list;
    }
     
     
     
      public static void loadTableViewVeXe(TableView<ThongTinVeXe> tbView) {
        TableColumn colMaVe = new TableColumn("Ma Ve");
        colMaVe.setCellValueFactory(new PropertyValueFactory("maVe"));
        colMaVe.setPrefWidth(100);
        
        TableColumn colBanSo = new TableColumn("Ban So");
        colBanSo.setCellValueFactory(new PropertyValueFactory("banSo"));
        colBanSo.setPrefWidth(100);
        
        TableColumn colNoiDi = new TableColumn("Noi Di");
        colNoiDi.setCellValueFactory(new PropertyValueFactory("noiDi"));
        colNoiDi.setPrefWidth(100);
        
        TableColumn colNoiDen  = new TableColumn("Noi Den");
        colNoiDen.setCellValueFactory(new PropertyValueFactory("noiDen"));
        colNoiDen.setPrefWidth(100);
        
        TableColumn colNgay = new TableColumn("Ngay Di");
        colNgay.setCellValueFactory(new PropertyValueFactory("ngayDi"));
        colNgay.setPrefWidth(100);
        
        TableColumn colGio = new TableColumn("Gio khoi hanh");
        colGio.setCellValueFactory(new PropertyValueFactory("gioKhoiHanh"));
        colGio.setPrefWidth(130);
        
        TableColumn colHoTen  = new TableColumn("Ho Ten");
        colHoTen.setCellValueFactory(new PropertyValueFactory("hoTen"));
        colHoTen.setPrefWidth(100);
        
        TableColumn colSoDienThoai  = new TableColumn("So Dien Thoai");
        colSoDienThoai.setCellValueFactory(new PropertyValueFactory("soDienThoai"));
        colSoDienThoai.setPrefWidth(120);
        
        TableColumn colViTriGhe = new TableColumn("Vi Tri Ghe");
        colViTriGhe.setCellValueFactory(new PropertyValueFactory("viTriGhe"));
        colViTriGhe.setPrefWidth(100);
        
        TableColumn colGia = new TableColumn("Gia");
        colGia.setCellValueFactory(new PropertyValueFactory("gia"));
        colGia.setPrefWidth(100);
        
        
        
        

        
        
        
        
        
        
        
        tbView.getColumns().addAll(colMaVe, colBanSo, colNoiDi, colNoiDen, colNgay, colGio, colHoTen, colSoDienThoai, colViTriGhe, colGia);
    }
    
    public static void loadTableDataVeXe(List<ThongTinVeXe> list, TableView<ThongTinVeXe> tbView){
        tbView.setItems(FXCollections.observableList(list));
    }
}
