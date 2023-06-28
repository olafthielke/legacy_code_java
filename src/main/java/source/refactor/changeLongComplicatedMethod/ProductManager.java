package source.refactor.changeLongComplicatedMethod;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductManager {
    private Connection connection;

    public ProductManager(Connection connection) {
        this.connection = connection;
    }

    public SqlProduct getProduct(String cmdTxt) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(cmdTxt);

        try {
            SqlProduct prod = null;
            if (rs.next()) {
                prod = new SqlProduct();
                String sku = rs.getString("SKU");
                String name = rs.getString("Name");
                BigDecimal unitPrice = rs.getBigDecimal("UnitPrice");

                if (sku != null) {
                    prod.setSKU(sku.trim());
                }

                prod.setName(name);
                prod.setUnitPrice(unitPrice);
            }
            return prod;
        } finally {
            rs.close();
            stmt.close();
        }
    }
}
