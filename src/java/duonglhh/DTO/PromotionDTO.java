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
public class PromotionDTO implements Serializable {

    int proID;
    String proName;

    public PromotionDTO() {
    }

    public PromotionDTO(int proID, String proName) {
        this.proID = proID;
        this.proName = proName;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

}
