/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juros.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebServlet(name = "homeServlet", urlPatterns = {"/homeservlet.html"})
public class HomeServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html >");
            out.println("<head>");
            out.println("<title>PROJETO 1</title>");            
            out.println("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");            
            out.println("</head>");
            out.println("<body style='text-align: center'>");
            out.println("<h1>Projeto 1 - Programação Orientada a Objeto</h1>");
            out.println("<hr />");
            out.println("<h1>Integrantes:<h1/>");
            out.println("<img src=imagem/ff.jpg style=\"width:100px;height:100px;\">");
            out.println("Fabio da Silva Araujo <br/>");
            out.println("<img src=imagem/gc.JPG style=\"width:100px;height:100px;\">");
            out.println("Gustavo Henrique Callipo Cavalcanti <br/>");
            out.println("<img src=imagem/hm.jpg style=\"width:100px;height:100px;\">");
            out.println("Henrique Melo Santos <br/>");
            out.println("<img src=imagem/lm>");
            out.println("Luiz Maciel Segura dos Santos <br/>");
            out.println("<img src=imagem/RS style=\"width:100px;height:100px;\">");
            out.println("Rodrigo Soares Almeida <br/>");
            out.println("<img src=imagem/lm style=\"width:100px;height:100px;\">");
            out.println("VItor Hugo Borges Yugulis <br/>");
            out.println("<hr>");    
            out.println("<ul class=\"nav nav-tabs nav-justified\">");
            out.println("<a href=\"jurossimples.html\"><button type=\"button\" class=\"btn btn-default navbar-btn\">Juros Simples</button></a>");
            out.println("<a href=\"juroscomposto.html\"><button type=\"button\" class=\"btn btn-default navbar-btn\">Juros Composto</button></a>");
            out.println("</ul>");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");
            out.println("<script src=\"js/bootstrap.min.js\"></script>");
            out.println("</body>");
            out.println("</html>");
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
