/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.data;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import music.business.User;
import music.util.PasswordUtil;

/**
 *
 * @author Ishita
 */
public class UserDB {
    public static boolean AdminLogin(String name, String pass)  {
   boolean status;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "select * from login where user=? and password=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            status = rs.next();
            return status;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
public static String Userlogin(String email, String pass)  {
   String status = "";
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String passwordFromDb = "";
        String salt = "";

        String query = "select username,password,salt from userlogin where email=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if(rs.next()){
                status = rs.getString("username");
                passwordFromDb = rs.getString("password");
                 salt = rs.getString("salt");
            }
            //pwd calculation
            String passwordFromUser = PasswordUtil.hashAndSaltPassword(pass, salt);
            if(!passwordFromDb.equalsIgnoreCase(passwordFromUser)){
                status = "ERROR: Incorrect password";
            }
            return status;
        } catch (SQLException | NoSuchAlgorithmException e) {
            System.out.println(e);
            return "ERROR: Unable to login";
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
public static boolean emailExists(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT email FROM userlogin "
                + "WHERE email= ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
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
    public static int UserRegistration(User user)  {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
	try{
        String preparedQuery =  "insert into userlogin (email, username, password,salt) values(?, ?, ?,?)";
	String salt = PasswordUtil.getSalt();
        String encryptedPwd = PasswordUtil.hashAndSaltPassword(user.getPassword(), salt);
        
            ps = connection.prepareStatement(preparedQuery);
	ps.setString(1, user.getEmail());
	ps.setString(2, user.getName());
	ps.setString(3,  encryptedPwd  );
        ps.setString(4,  salt  );
	ps.executeUpdate();

        } catch (SQLException | NoSuchAlgorithmException e) {
            System.out.println(e);
            return -1;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
                return 0;
    }
    
    public static void insert(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        

        String query
                = "INSERT INTO userdetails (Name, Email, "
                + "Address, State, City, Zip,Contact "
                + "VALUES (?, ?, "
                + "?, ?, ?, ?, ?)";
                
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getname());
            ps.setString(3, user.getEmail());
            ps.setString(5, user.getAddress());
            ps.setString(7, user.getCity());
            ps.setString(8, user.getState());
            ps.setString(9, user.getZip());
            
            
            ps.executeUpdate();
            
            //Get the user ID from the last INSERT statement.
            String identityQuery = "SELECT @@IDENTITY AS IDENTITY";
            Statement identityStatement = connection.createStatement();
            ResultSet identityResultSet = identityStatement.executeQuery(identityQuery);
            identityResultSet.next();
            long userID = identityResultSet.getLong("IDENTITY");
            identityResultSet.close();
            identityStatement.close();

            // Set the user ID in the User object
            user.setId(userID);
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static void update(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "UPDATE userdetails SET "
                + "Name = ?, "
                + "Address = ?, "
                + "City = ?, "
                + "State = ?, "
                + "Zip = ?, "
                + "Country = ?, "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getname());
            ps.setString(4, user.getAddress());
            ps.setString(6, user.getCity());
            ps.setString(7, user.getState());
            ps.setString(8, user.getZip());
            ps.setString(13, user.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static User selectUser(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM userdetails "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setId(rs.getLong("UserID"));
                user.setname(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setAddress(rs.getString("Address"));
                user.setCity(rs.getString("City"));
                user.setState(rs.getString("State"));
                user.setZip(rs.getString("Zip"));
                
            }
            return user;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

}
