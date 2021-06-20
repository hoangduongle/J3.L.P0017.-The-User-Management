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
public class DetailDTO implements Serializable{
    int Rank;
    int userID;
    String userName;
    PromotionDTO pro;

    
    public DetailDTO() {
    }

    public DetailDTO(int Rank, int userID, PromotionDTO pro) {
        this.Rank = Rank;
        this.userID = userID;
        this.pro = pro;
    }

    public DetailDTO(int Rank, int userID, String userName, PromotionDTO pro) {
        this.Rank = Rank;
        this.userID = userID;
        this.userName = userName;
        this.pro = pro;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int Rank) {
        this.Rank = Rank;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

   

    public PromotionDTO getPro() {
        return pro;
    }

    public void setPro(PromotionDTO pro) {
        this.pro = pro;
    }

    

    
    
    
}
