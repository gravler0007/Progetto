//  CREATE TABLE Product (
//     product_id INT AUTO_INCREMENT PRIMARY KEY,
//     user_id INT NOT NULL,
//     name VARCHAR(100) NOT NULL,
//     description TEXT,
//     price DECIMAL(10, 2) NOT NULL,
//     stock INT NOT NULL,
//     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//     FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE
// ); 

package com.test.dbservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.test.model.Prodotto;

public class ProdottoDAO {
    
    public void createProdotto(Prodotto prodotto){
        System.out.println("CE SO ARRIVATO");
        String sql = "INSERT INTO product (user_id, name, description, price, stock) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, prodotto.getUser_id());
            pstmt.setString(2, prodotto.getName());
            pstmt.setString(3, prodotto.getDescription());
            pstmt.setDouble(4, prodotto.getPrice());
            pstmt.setInt(5, prodotto.getStock());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // public void createProduct(Product product) throws SQLException {
    //     String sql = "INSERT INTO Product (user_id, name, description, price, stock) VALUES (?, ?, ?, ?, ?)";
    //     try (Connection conn = Database.getConnection();
    //             PreparedStatement stmt = conn.prepareStatement(sql)) {
    //         stmt.setInt(1, product.userId);
    //         stmt.setString(2, product.name);
    //         stmt.setString(3, product.description);
    //         stmt.setDouble(4, product.price);
    //         stmt.setInt(5, product.stock);
    //         stmt.executeUpdate();
    //     }
    // }


}