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
import java.util.ArrayList;
import java.util.List;
import model.ProductDTO;
import utils.DbUtils;
import static utils.DbUtils.getConnection;

/**
 *
 * @author trant
 */
public class ProductDAO extends DbUtils {

    public List<ProductDTO> searchProduct(String txtSearch) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM products WHERE productName LIKE ?";
        try {
            conn = getConnection();
            if (conn != null) {
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + txtSearch + "%");
                rs = ps.executeQuery();
                if (rs.next()) {
                    String productId = rs.getString("productId");
                    String productName = rs.getString("productName");
                    String productImage = rs.getString("productImage");
                    String brief = rs.getString("brief");
                    String account = rs.getString("account");
                    String unit = rs.getString("unit");
                    
                    Date postedDate = rs.getDate("postedDate");
                    
                    int typeId = rs.getInt("typeId");
                    int price = rs.getInt("price");
                    int discount = rs.getInt("discount");
                    ProductDTO product = new ProductDTO(productId, productName, productImage, brief, account, unit, postedDate, typeId, price, discount);
                }
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
        return list;
    }

}
