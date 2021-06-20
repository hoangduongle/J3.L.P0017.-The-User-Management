/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duonglhh.DTO;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class HistoryDTO implements Serializable{
    String Adddate;
    int UserID;
    PromotionDTO pro;

    public HistoryDTO() {
    }

    public HistoryDTO(String Adddate, int UserID, PromotionDTO pro) {
        this.Adddate = Adddate;
        this.UserID = UserID;
        this.pro = pro;
    }

    public String getAdddate() {
        return Adddate;
    }

    public void setAdddate(String Adddate) {
        this.Adddate = Adddate;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public PromotionDTO getPro() {
        return pro;
    }

    public void setPro(PromotionDTO pro) {
        this.pro = pro;
    }
    
    
}
