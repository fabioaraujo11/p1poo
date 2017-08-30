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
@WebServlet(name = "jurosSimplesServlet", urlPatterns = {"/jurossimples.html"})
public class JurosSimplesServlet extends HttpServlet {

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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet jurosSimplesServlet</title>");            
            out.println("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<a style='float: left' href=\"homeservlet.html\"><button type=\"button\" class=\"btn btn-default navbar-btn\">Voltar</button></a>");
            out.println("<h1 style='text-align: center '>Cálculo de Juros Simples</h1>");
            out.println("<hr>");
            out.println("</div>");
            //Váriaveis
            double P = 0; //P = Valor Principal; 
            double M = 0; //M = Montante
            double J = 0; //J = Valor do Juros
            double t=0; //t = Taxa de Juros
            int n=0; // n = Numero de Periodos
            int c=0; //c = Variavel de Controle
            
            out.println("<div style='text-align: center'>");
            
            
            
            //Formulário a ser exibido
            out.println("<form>");
            out.println("<label>Valor Principal: </label><br>");
            out.println("<input type='text' name='principal'><br>");
            out.println("<label>Taxa de juros: </label><br>");
            out.println("<input type='text' name='taxa'><br>");
            out.println("<label>Número de períodos: </label><br>");
            out.println("<input type='text' name='periodo'><br>");
            out.println("<input type='submit' value='Calcular' class=\"btn btn-default navbar-btn\"><br>");
            out.println("</form>");
            
            //Tratamento de Exceção (Caso seja inserida informação errada)
            try{
                if (request.getParameter("principal") != null){
                    P = Double.parseDouble(request.getParameter("principal"));
                    c++;
                }
                if (request.getParameter("taxa") != null){
                    t = Double.parseDouble(request.getParameter("taxa"));
                    c++;
                }
                if (request.getParameter("periodo") != null){
                    n = Integer.parseInt(request.getParameter("periodo"));
                    c++;
                }
            }catch (Exception ex){
                //Mensagem caso algum dado esteja inválido
                out.println("<h2 style='color: red'>Preencha os campos de maneira correta</h2>");
            }
            
            //Recurso para saber se a taxa foi inserida em porcentagem ou numero decimal
            if(t > 1){
                t = t/100;
            }
            
            //Calculo do Juros Simples
            J = (P * t * n);//será tranformado a porcentagem em numero real, para realização o calculo
            M = P + J ;
            
            
            //Exibição do juros e do montante se tudo tiver ocorrido normalmente
            if(c == 3){
                out.println("<h2>Valor do Juros: R$" + J + "</h2>");
                out.println("<h2>Montante: R$" + M + "</h2>");
            }  
            out.println("</div>");
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
