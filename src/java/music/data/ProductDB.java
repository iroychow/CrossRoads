package music.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import music.business.Menu;

public class ProductDB {

    public static int insert(Menu product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
		try{
        String preparedQuery =  "INSERT INTO Product "
    			+ "(code, description, price) "
    			+ "VALUES "
    			+ "(?, ?, ?)";
	
            ps = connection.prepareStatement(preparedQuery);
	ps.setString(1, product.getCode());
	ps.setString(2, product.getDescription());
	ps.setDouble(3, product.getPrice());
	ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
                return 0;
    }

    public static int update(Menu product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

     
       try {
            String preparedSQL = "UPDATE Product SET "
                   + "   code = ?, " 
                   + "   description = ?, "
                   + "   price = ?"
                   + "WHERE code = ?";
		 ps = connection.prepareStatement(preparedSQL);
		ps.setString(1, product.getCode());
		ps.setString(2, product.getDescription());
		ps.setDouble(3, product.getPrice());
		ps.setString(4, product.getCode());
		ps.executeUpdate();


            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int delete(Menu product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM Product "
                + "WHERE code = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getCode());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean codeExists(String code) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT code FROM Product "
                + "WHERE code= ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, code);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

   
    public static Menu selectProduct(String code) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product"
                + " WHERE code = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, code);
            rs = ps.executeQuery();
            Menu product = new Menu();
            if (rs.next()) {
                
                product.setCode(rs.getString("code"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
            }
            
            return product;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    /**
     *
     * @return
     * @throws java.sql.SQLException
     */
    public static List<Menu> selectProducts() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product";

        try {
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();
            
            List<Menu> allProducts = new ArrayList<>();
            while (rs.next()) {

                Menu product = new Menu();
                product.setCode(rs.getString("code"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                allProducts.add(product);

            }

            return allProducts;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}