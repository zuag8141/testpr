/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.AccountDTO;
import utils.DbUtils;

/**
 *
 * @author trant
 */
public class AccountDAO extends DbUtils {

    public AccountDTO checkLogin(String account, String password) throws SQLException {
        AccountDTO acc = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM accounts WHERE account = ? AND pass = ?";
        try {
            conn = getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(sql);
            }
            ps.setString(1, account);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                String lastName = rs.getString("lastName");
                String firstName = rs.getString("firstName");
                Date birthday = rs.getDate("birthday");
                int gender = rs.getInt("gender");
                String phone = rs.getString("phone");
                int isUse = rs.getInt("isUse");
                int roleInSystem = rs.getInt("roleInSystem");
                acc = new AccountDTO(account, password, lastName, firstName, birthday, gender, phone, isUse, roleInSystem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    return acc;
    }
}
