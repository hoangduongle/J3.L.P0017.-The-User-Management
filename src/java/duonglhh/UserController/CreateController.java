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
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {

    private static final String ERROR = "manager.jsp";
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
        String linkPhoto = "https://cdn.icon-icons.com/icons2/1378/PNG/512/avatardefault_92824.png";
        String url = ERROR;
        try {
            UserDAO dao = new UserDAO();
            int roleID = (request.getParameter("role").toLowerCase()).equals("admin") ? 1 : 2;
            String photo = request.getParameter("photo").equals("") ? linkPhoto : request.getParameter("photo");
            boolean checkpass = request.getParameter("password").equals(request.getParameter("repassword"));

            boolean checkuserName = dao.checkUserName(request.getParameter("username1"));
            if (!checkuserName) {
                if (checkpass) {
                    UserDTO dto = new UserDTO(0,
                            request.getParameter("username1"),
                            dao.Sha256(request.getParameter("password")),
                            request.getParameter("email"),
                            request.getParameter("phone"),
                            photo,
                            true,
                            roleID);
                    if (dao.insertAccount(dto) != -1) {
                        request.setAttribute("MESSOK", "Create success!");
                        url = SUCCESS;
                    }
                } else {
                    request.setAttribute("MODEL", "click model");
                    request.setAttribute("MESS", "Password not match!");
                    //pass != repass
                }
            } else {
                //duplicate username
                request.setAttribute("MODEL", "click model");
                request.setAttribute("MESS", "User Name exist!");

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
