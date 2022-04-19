 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nv.category;

import com.nv.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


/**
 *
 * @author DangNgocHoaiNam
 */
public class CategoryTest {
   
    private static Connection conn; 
   
    @BeforeAll
    public static void beforeAll() throws SQLException{
        conn = JdbcUtils.getConn();
    }
   
    @AfterAll
    public static void afterAll() throws SQLException{
    
        if (conn != null)
            conn.close();
    }
    
    @Test
    public void abc() throws SQLException{
    
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM product");
        
        while(rs.next()){
            
            String name = rs.getString("name");
            System.out.println(name);
        }
    }
     
   
}
