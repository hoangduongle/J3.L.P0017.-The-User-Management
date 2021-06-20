/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duonglhh.UserController;

import duonglhh.DAO.UserDAO;
import duonglhh.DTO.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "ManageController";

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
        String url = ERROR;
        String userid = request.getParameter("userid");
        try {

            UserDAO dao = new UserDAO();
            UserDTO dto = dao.getUserByID(Integer.parseInt(userid));

            String userName = request.getParameter("username").equals("") ? dto.getUserName() : request.getParameter("username");
            String email = request.getParameter("email").equals("") ? dto.getEmail() : request.getParameter("email");
            String phone = request.getParameter("phone").equals("") ? dto.getPhone() : request.getParameter("phone");
            String photo = request.getParameter("photo").equals("") ? dto.getPhoto() : request.getParameter("photo");
            int roleID = request.getParameter("roleid").equals("Member") ? 2 : 1;
            boolean status = request.getParameter("status").equals("Active");

            String password = request.getParameter("password");
            boolean bool = true;
            if (password.length() > 0) {
                bool = password.equals(request.getParameter("repassword"));
                if (!bool) {
                    request.setAttribute("MESS", "Password not match!");
                    url = "userinfo.jsp";
                    bool = false;
                }
            } else {
                password = dto.getPassword();
            }
            if (bool) {
                dto = new UserDTO(Integer.parseInt(userid), userName, password, email, phone, photo, status,roleID);
                if (dao.updateAccount(dto) > 0) {
                    request.setAttribute("MESSOK", "Update Success!");
                    url = SUCCESS;
                } else {
                    url = "sairoi.jsp";
                }

            }

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
