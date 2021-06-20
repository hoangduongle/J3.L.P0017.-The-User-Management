/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duonglhh.DAO;

import duonglhh.DTO.UserDTO;
import duonglhh.Ulities.DBHelper;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ASUS
 */
public class UserDAO {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void closeAllConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (pst != null) {
            pst.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public UserDTO checkAccount(String userName, String password) throws SQLException, ClassNotFoundException, NamingException {
        UserDTO user = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select UserID,UserName,PassWord,Email,Phone,Photo,Status,roleID\n"
                        + "from tblUsers\n"
                        + "where UserName = ? and PassWord = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, userName);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    user = new UserDTO(rs.getInt("UserID"),
                            rs.getString("UserName"),
                            "***",
                            rs.getString("Email"),
                            rs.getString("Phone"),
                            rs.getString("Photo"),
                            rs.getBoolean("Status"),
                            rs.getInt("roleID"));
                    return user;
                }
            }
        } finally {
            closeAllConnection();
        }
        return user;
    }

    public ArrayList<UserDTO> getListAccount() throws NamingException, SQLException {
        ArrayList<UserDTO> list = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select UserID,UserName,PassWord,Email,Phone,Photo,Status,roleID\n"
                        + "from tblUsers";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new UserDTO(rs.getInt("UserID"),
                            rs.getString("UserName"),
                            "***",
                            rs.getString("Email"),
                            rs.getString("Phone"),
                            rs.getString("Photo"),
                            rs.getBoolean("Status"),
                            rs.getInt("roleID")));
                }
            }
        } finally {
            closeAllConnection();
        }
        return list;
    }

    public ArrayList<UserDTO> getListByRoleID(int roleid) throws NamingException, SQLException {
        ArrayList<UserDTO> list = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select UserID,UserName,PassWord,Email,Phone,Photo,Status,roleID\n"
                        + "from tblUsers\n"
                        + "where RoleID = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, roleid);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new UserDTO(rs.getInt("UserID"),
                            rs.getString("UserName"),
                            "***",
                            rs.getString("Email"),
                            rs.getString("Phone"),
                            rs.getString("Photo"),
                            rs.getBoolean("Status"),
                            rs.getInt("roleID")));
                }
            }
        } finally {
            closeAllConnection();
        }
        return list;
    }

    public ArrayList<UserDTO> searchByName(String name) throws NamingException, SQLException {
        ArrayList<UserDTO> list = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select UserID,UserName,PassWord,Email,Phone,Photo,Status,roleID\n"
                        + "from tblUsers\n"
                        + "where UserName like ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, "%" + name + "%");
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new UserDTO(rs.getInt("UserID"),
                            rs.getString("UserName"),
                            "***",
                            rs.getString("Email"),
                            rs.getString("Phone"),
                            rs.getString("Photo"),
                            rs.getBoolean("Status"),
                            rs.getInt("roleID")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAllConnection();
        }
        return list;
    }

    public boolean checkUserName(String username) throws NamingException, SQLException {
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select UserName\n"
                        + "from tblUsers\n"
                        + "where UserName = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, username);
                rs = pst.executeQuery();
                if (rs.next()) {
                    return true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAllConnection();
        }
        return false;
    }

    public int insertAccount(UserDTO dto) throws NamingException, SQLException {
        int result = -1;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "insert into tblUsers(UserName,PassWord,Email,Phone,Photo,Status,RoleID) \n"
                        + "values(?,?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, dto.getUserName());
                pst.setString(2, dto.getPassword());
                pst.setString(3, dto.getEmail());
                pst.setString(4, dto.getPhone());
                pst.setString(5, dto.getPhoto());
                pst.setBoolean(6, true);
                pst.setInt(7, dto.getRoleID());
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAllConnection();
        }
        return result;
    }

    public int deleteAccount(int userid) throws NamingException, SQLException {
        int result = -1;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "update tblUsers\n"
                        + "set Status = 0\n"
                        + "where UserID = " + userid;
                pst = con.prepareStatement(sql);
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAllConnection();
        }
        return result;
    }

    public int updateAccount(UserDTO dto) throws NamingException, SQLException {
        int result = -1;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "update tblUsers\n"
                        + "set UserName = ?, PassWord = ? , Email = ?, Phone = ?, Photo = ?, Status = ? ,RoleID = ? \n"
                        + "where UserID = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, dto.getUserName());
                pst.setString(2, dto.getPassword());
                pst.setString(3, dto.getEmail());
                pst.setString(4, dto.getPhone());
                pst.setString(5, dto.getPhoto());
                pst.setInt(6, 1);
                pst.setInt(7, dto.getRoleID());
                pst.setInt(8, dto.getUserID());
                result = pst.executeUpdate();
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public UserDTO getUserByID(int userID) throws NamingException, SQLException {
        UserDTO dto = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select UserID,UserName,PassWord,Email,Phone,Photo,Status,roleID\n"
                        + "from tblUsers\n"
                        + "where UserID = " + userID;
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    dto = new UserDTO(rs.getInt("UserID"),
                            rs.getString("UserName"),
                            rs.getString("PassWord"),
                            rs.getString("Email"),
                            rs.getString("Phone"),
                            rs.getString("Photo"),
                            rs.getBoolean("Status"),
                            rs.getInt("roleID"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAllConnection();
        }
        return dto;
    }
    
    public String Sha256(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(pass.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        String hex = String.format("%064x", new BigInteger(1, digest));
        return hex;
    }

}
