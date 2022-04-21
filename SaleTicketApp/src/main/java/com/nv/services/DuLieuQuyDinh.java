/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.services;

import com.nv.pojo.QuyDinh;
import com.nv.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author inmac
 */
public class DuLieuQuyDinh {
    public List<QuyDinh> getQuyDinh() throws SQLException{
        List<QuyDinh> results = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()){
            Statement  stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from quydinh");
            
            while(rs.next()){
                QuyDinh qd = new QuyDinh(rs.getInt("maQuyDinh"), rs.getInt("thoiGianChamNhatDatVe"), 
                        rs.getInt("thoiGianChamNhatMuaVe"), rs.getInt("thoiGianChamNhatNhanVe"), rs.getInt("thoiGianChamDoiHuyVe"), rs.getInt("thoiGianVeThuHoi") );
                results.add(qd);
        }
    }
        return results;
    }
}
