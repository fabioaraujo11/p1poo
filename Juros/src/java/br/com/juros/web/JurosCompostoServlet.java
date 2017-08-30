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
import java.text.DecimalFormat; 

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebServlet(name = "JurosCompostoServlet", urlPatterns = {"/juroscomposto.html"})
public class JurosCompostoServlet extends HttpServlet {

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
        
        //C= Capital
        //TJ= Taxa de juros
        //T = Tempo de aplicação
        
        double C = 0;
        double CapitalAnterior = 0;
        double TJ = 0;
        int T = 0;
        int controle = 0;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JurosCompostoServlet</title>");            
            out.println("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<a style='float: left' href=\"homeservlet.html\"><button type=\"button\" class=\"btn btn-default navbar-btn\">Voltar</button></a>");
            out.println("<h1 style='text-align: center '>Cálculo de Juros Simples</h1>");
            out.println("<hr>");
            out.println("</div>");
            
            out.println("<form>");
            out.println("");
            
            out.println("<div style='text-align: center'>");
            out.println("<p><strong>Capital inicial: </strong></p>");
            out.println("<input type=text name=\"CapitalInicial\" >");
            out.println("<p><strong>Taxa de juros: </strong></p>");
            out.println("<input type=text name=\"TaxadeJuros\" >");
            out.println("<p><strong>Tempo de aplicação: </strong></p>");
            out.println("<input type=text name=\"TempodeAplicacao\" ><br><br>");
            out.println("<input type=\"submit\" name=\"botao\" value=\"Calcular\" class=\"btn btn-default navbar-btn\"></br></br>");
            
            try{
                if (request.getParameter("CapitalInicial") != null){
                    C = Double.parseDouble(request.getParameter("CapitalInicial"));
                    controle++;
                }
                if (request.getParameter("TaxadeJuros") != null){
                    TJ = Double.parseDouble(request.getParameter("TaxadeJuros"));
                    controle++;
                }
                if (request.getParameter("TempodeAplicacao") != null){
                    T = Integer.parseInt(request.getParameter("TempodeAplicacao"));
                    controle++;
                }
                
            }catch (Exception ex){
                //Mensagem caso algum dado esteja inválido
                out.println("<h2 style='color: red'>Preencha os campos de maneira correta</h2>");
                
            }
            
            if (request.getParameter("botao") != null) 
            {
                
                if(controle==3){
                    if (TJ>1){
                        TJ = TJ/100;
                    }
                    out.println("Capital Inicial "+C+"<br><br>");
                    out.println("Resultado de " + T + " meses de aplicação: " + Math.round(((C*Math.pow((1+TJ),T)))*100)/100.00 + " com taxa de juros igual a: "+TJ*100+"%");
                    out.println("<br><br>");
                    
                    out.println("<table width='200' align='center' border= '1'>");
                    out.println("<tr ><th style='text-align: center' >Indice</th><th style='text-align: center'>Capital</th><th style='text-align: center'>Juros</th></tr>");
                    for(int i=1;i<=T;i++){
                        CapitalAnterior = C;
                        C = (C*Math.pow((1+TJ),1));
                        
                        out.println("<tr><td>"+i+"</td><td>"+Math.round((C)*100)/100.00+"</td><td>"+Math.round((C-CapitalAnterior)*100)/100.00+"</td></tr>");
                        
                    }
                    out.println("</table>");
        
                    
                }
                
            }
            
            out.println("</form>");
            out.println("</div>");
            
            
            
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>");
            out.println("<script src=\"js/bootstrap.min.js\"></script>");
            out.println("</body>");
            out.println("</html>");
            
            int Botao;
            
            
            
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