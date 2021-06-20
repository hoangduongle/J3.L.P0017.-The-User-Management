/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duonglhh.PromotionController;

import duonglhh.DAO.PromotionDAO;
import duonglhh.DTO.DetailDTO;
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
@WebServlet(name = "InsertController", urlPatterns = {"/InsertController"})
public class InsertController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "AddForm.jsp";

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
        String proid = request.getParameter("proid");
        String userID = request.getParameter("userid");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            PromotionDAO dao = new PromotionDAO();

            PromotionDTO prodto = dao.getPromotionByID(Integer.parseInt(proid));
            DetailDTO dto = new DetailDTO(5, Integer.parseInt(userID), prodto);
            
            boolean flag = true;
            ArrayList<DetailDTO> list = (ArrayList<DetailDTO>) session.getAttribute("TMP");//2
            if (list == null) {
                list = new ArrayList();
            } else {
                for (DetailDTO detailDTO : list) {
                    if (detailDTO.getUserID() == dto.getUserID()) {
                        request.setAttribute("MESS", "This user had promotion!");
                        flag = false;
                    }
                }
            }
            if(flag){
                list.add(dto);//3
                request.setAttribute("MESSOK", "Add Promotion success!");
            }
            session.setAttribute("TMP", list);//3
            url = SUCCESS;
        } catch (Exception e) {
            log("Error at Controller " + e.toString());
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
