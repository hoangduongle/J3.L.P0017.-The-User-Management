/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duonglhh.PromotionController;

import duonglhh.DAO.PromotionDAO;
import duonglhh.DTO.DetailDTO;
import duonglhh.DTO.HistoryDTO;
import duonglhh.DTO.PromotionDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus
 */
@WebServlet(name = "SaveController", urlPatterns = {"/SaveController"})
public class SaveController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "ManageController";
        try {
            HttpSession session = request.getSession();
            PromotionDAO dao = new PromotionDAO();

            ArrayList<DetailDTO> list1 = dao.getListDetail();//delete
            ArrayList<DetailDTO> list2 = (ArrayList<DetailDTO>) session.getAttribute("TMP");//update insert

            for (DetailDTO dtodata : list1) {
                for (DetailDTO dtonew : list2) {
                    if (!dao.checkExist(dtonew)) {
                        dao.insertDetail(dtonew);
                        HistoryDTO dto = new HistoryDTO(url, dtonew.getUserID(), new PromotionDTO(dtonew.getPro().getProID(), null));
                        dao.insertHistory(dto);
                        
                    } else if (dtodata.getUserID() != dtonew.getUserID()) {
                        //data có | new không
                        dao.deleteDetails(dtodata.getUserID());
                        
                    } else { //data có | new có 
                        dao.updateDetails(dtonew);
                    }
                }
            }
            request.setAttribute("MESSOK", "Save Success!");
        } catch (Exception e) {
            log("Error at SaveController " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
