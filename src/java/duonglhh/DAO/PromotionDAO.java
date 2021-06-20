/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duonglhh.DAO;

import duonglhh.DTO.DetailDTO;
import duonglhh.DTO.HistoryDTO;
import duonglhh.DTO.PromotionDTO;
import duonglhh.DTO.UserDTO;
import duonglhh.Ulities.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.NamingException;

/**
 *
 * @author Asus
 */
public class PromotionDAO {

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

    public ArrayList<PromotionDTO> getListPromotion() throws SQLException {
        ArrayList<PromotionDTO> list = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select ProID, ProName\n"
                        + "from tblPromotions";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new PromotionDTO(rs.getInt("ProID"), rs.getString("ProName")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAllConnection();
        }
        return list;
    }

    public PromotionDTO getPromotionByID(int ID) throws SQLException {
        PromotionDTO dto = new PromotionDTO();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select ProID, ProName\n"
                        + "from tblPromotions\n"
                        + "where ProID = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, ID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    dto = new PromotionDTO(rs.getInt("ProID"), rs.getString("ProName"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAllConnection();
        }
        return dto;
    }

    public ArrayList<UserDTO> getListAccount() throws NamingException, SQLException {
        ArrayList<UserDTO> list = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select UserID,UserName\n"
                        + "from tblUsers\n"
                        + "where RoleID = 2";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new UserDTO(rs.getInt("UserID"),
                            rs.getString("UserName")));
                }
            }
        } finally {
            closeAllConnection();
        }
        return list;
    }

    public ArrayList<DetailDTO> getListDetail() throws NamingException, SQLException {
        ArrayList<DetailDTO> list = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select intRank,UserID, d.ProID, p.ProName\n"
                        + "from tblDetails d inner join tblPromotions p on d.ProID = p.ProID";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {

                    list.add(new DetailDTO(rs.getInt("intRank"),
                            rs.getInt("UserID"),
                            new PromotionDTO(rs.getInt("ProID"), rs.getString("ProName"))));
                }
            }
        } finally {
            closeAllConnection();
        }
        return list;
    }

    public ArrayList<DetailDTO> getListDetailByProID(int ProID) throws NamingException, SQLException {
        ArrayList<DetailDTO> list = new ArrayList<>();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select intRank,UserID,d.ProID, p.ProName\n"
                        + "from tblDetails d inner join tblPromotions p on d.ProID = p.ProID\n"
                        + "where d.ProID = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, ProID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new DetailDTO(rs.getInt("intRank"),
                            rs.getInt("UserID"),
                            new PromotionDTO(rs.getInt("ProID"), rs.getString("ProName"))));
                }
            }
        } finally {
            closeAllConnection();
        }
        return list;
    }

    public int deleteDetails(int userID) throws NamingException, SQLException {
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "delete tblDetails\n"
                        + "where userID = ? ";
                pst = con.prepareStatement(sql);
                pst.setInt(1, userID);
                return pst.executeUpdate();
            }
        } finally {
            closeAllConnection();
        }
        return 0;
    }

    public int updateDetails(DetailDTO dto) throws NamingException, SQLException {
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "update tblDetails\n"
                        + "set intRank = ?, ProID = ?\n"
                        + "where UserID = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, dto.getRank());
                pst.setInt(2, dto.getPro().getProID());
                pst.setInt(3, dto.getUserID());
                return pst.executeUpdate();
            }
        } finally {
            closeAllConnection();
        }
        return 0;
    }

    /**/
    public boolean checkExist(DetailDTO dto) throws NamingException, SQLException {
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select *\n"
                        + "from tblDetails\n"
                        + "where UserID = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, dto.getUserID());
                rs = pst.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            closeAllConnection();
        }
        return false;
    }

    public int insertDetail(DetailDTO dto) throws NamingException, SQLException {
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "insert into tblDetails values(?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setInt(1, dto.getRank());
                pst.setInt(2, dto.getUserID());
                pst.setInt(3, dto.getPro().getProID());
                return pst.executeUpdate();
            }
        } finally {
            closeAllConnection();
        }
        return 0;
    }

    public int insertHistory(HistoryDTO dto) throws NamingException, SQLException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "insert into tblHistory values(?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, dateFormat.format(date));
                pst.setInt(2, dto.getUserID());
                pst.setInt(3, dto.getPro().getProID());
                return pst.executeUpdate();
            }
        } finally {
            closeAllConnection();
        }
        return 0;
    }

    public ArrayList<HistoryDTO> getListHistoryByID(int ID) throws NamingException, SQLException {
        ArrayList<HistoryDTO> list = new ArrayList<>();
        Date date = new Date();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select Adddate, UserID, ProID\n"
                        + "from tblHistory\n"
                        + "where UserID = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, ID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new HistoryDTO(rs.getString("Adddate"), rs.getInt("UserID"), new PromotionDTO(rs.getInt("ProID"), null)));
                }
            }
        } finally {
            closeAllConnection();
        }
        return list;
    }

}
