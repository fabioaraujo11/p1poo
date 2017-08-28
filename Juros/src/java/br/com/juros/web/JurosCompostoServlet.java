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
        
        double C = 0;
        double TJ = 0;
        int T = 0;
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JurosCompostoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<form>");
            out.println("");
            out.println("");
            
            out.println("<p>Capital inicial</p>");
            out.println("<input type=text name=\"CapitalInicial\" >");
            out.println("<p>Taxa de juros</p>");
            out.println("<input type=text name=\"TaxadeJuros\" >");
            out.println("<p>Tempo de aplicação</p>");
            out.println("<input type=text name=\"TempodeAplicacao\" >");
            out.println("<input type=\"submit\" name=\"Botao\" value=\"Submit\" onclick=\"jurosComposto();\"></br></br>");
            out.println("<input type=\"text\" id=\"txtResultado\" value=\"Resultado\" readonly=\"readonly\">");
            out.println("Contato " + jurosComposto(C,TJ,T)); 
            out.println("</form>");
            out.println("<p>Valor C:"+C+" Valor TJ:"+TJ+" Valor T:"+T+"</p>");
            out.println("</body>");
            out.println("</html>");
            
            int Botao;
            
            try{
                
            }
            catch(Exception ex){
               
            }
            
            C = Double.parseDouble(request.getParameter("CapitalInicial"));
            TJ = Double.parseDouble(request.getParameter("TaxadeJuros"));
            T = Integer.parseInt(request.getParameter("TempodeAplicacao"));
            
            
            
            if (request.getParameter("Botao") != null) {
                out.println("<input type=\"text\" id=\"txtResultado\" readonly value="+ jurosComposto(C,TJ,T)+ ">");
            } else {
                // Form is not submitted.
            }
            
        }
        
        
    }
    
    //Ira retornar o montante final
    public double jurosComposto(double C, double TJ, int T) {
        double Montante;//Montante Final
        
        
        //C= Capital
        //TJ= Taxa de juros
        //T = Tempo de aplicação
        Montante = C*Math.pow((1+TJ),T);

        //Retorna o juros compostos da aplicação
        return Montante;
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
