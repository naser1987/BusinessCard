/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;

import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BusinessCard;
import service.BCService;

/**
 *
 * @author Naser
 */
public class Cont extends HttpServlet {

    public static String path = null;

    @Override
    public void init() throws ServletException {
        super.init();
        path = this.getServletContext().getRealPath("");
        BCService.loadFile();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String cmd = request.getParameter("cmd");
        if (cmd == null) {
            cmd = "BCRA";
        }
        if (cmd.equals("BCRA")) {
            ArrayList<BusinessCard> arr = BCService.read();
            request.setAttribute("BCListArray", arr);
            this.getServletContext().getRequestDispatcher("/jsp/BCList.jsp").forward(request, response);
        }
        if (cmd.equals("BCR")) {
            String id = request.getParameter("id");
            BusinessCard bc = BCService.read(Integer.parseInt(id));
            request.setAttribute("BCR", bc);
            this.getServletContext().getRequestDispatcher("/jsp/BCR.jsp").forward(request, response);
        }
        if (cmd.equals("BCC")) {

            String name = request.getParameter("name");
            String tel = request.getParameter("tel");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            BusinessCard bc = new BusinessCard(0, name, tel,email,address);
            boolean isCreated = BCService.create(bc);
            if(isCreated){
                 request.setAttribute("msg", "The Business Card of " + bc.getName() + "  is created");
            }

            request.setAttribute("BCListArray", BCService.read());
            this.getServletContext().getRequestDispatcher("/jsp/BCList.jsp").forward(request, response);

        }
        if (cmd.equals("BCD")) {

            int id = Integer.parseInt(request.getParameter("id"));

            BusinessCard bc = BCService.read(id);
            boolean isDeleted = BCService.delete(bc);
            if (isDeleted) {
                request.setAttribute("msg", "The Business card of " + bc.getName() + " is deleted");
                BCService.save();
            }
            request.setAttribute("BCListArray", BCService.read());
            this.getServletContext().getRequestDispatcher("/jsp/BCList.jsp").forward(request, response);
        }
        if (cmd.equals("BCU")) {

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            BusinessCard bc = new BusinessCard(id, name, tel, email, address);
            boolean isUpdated = BCService.update(bc);
            if (isUpdated) {
                request.setAttribute("msg", "The Business card of " + bc.getName() + "  is Updated");
                BCService.save();
            }

            request.setAttribute("BCListArray", BCService.read());
            this.getServletContext().getRequestDispatcher("/jsp/BCList.jsp").forward(request, response);

        }
        if (cmd.equals("BCS")) {

            BCService.save();
            request.setAttribute("msg", "the Data has been saved");
            request.setAttribute("BCListArray", BCService.read());
            this.getServletContext().getRequestDispatcher("/jsp/BCList.jsp").forward(request, response);

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
