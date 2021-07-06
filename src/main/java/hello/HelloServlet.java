/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {
	
	static Cumprimento cumprimento;

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
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
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
        
        String msg = "";
        
        msg = getLingua(request, msg);
        
        msg = getNome(request, msg);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String msg = "";
        
        int idade = 0;
        LocalDateTime local = LocalDateTime.now();
        int horario = local.getHour();
        
        msg = getLingua(request, msg, horario);
        
        msg = getNome(request, msg);
        
        Cumprimento.setHorario(horario);
        
        try {
			idade = qualEMinhaIdade(request, local);
		} catch (Exception e) {
			throw new RuntimeException("Data não informada, você deve informar a data!!!");
		}
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("<p>" + Cumprimento.getCumprimento() + "</p>");
            out.println("<p>Minha idade é " + idade +" anos</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Com base na escolha do usuário seleciona uma lingua
     * @param request
     * @param msg
     * @return lingua
     */
	private String getLingua(HttpServletRequest request, String msg, int horario) {
		String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                msg = "Alô, ";
                cumprimento = new Cumprimento("Bom dia", "Boa tarde", "Boa noite");
                break;
            case "en":
                msg = "Hello, ";
                cumprimento = new Cumprimento("Good morning", "Good afternoon", "Good night");
                break;
            case "fr":
                msg = "Bonjour, ";
                cumprimento = new Cumprimento(msg, "Bon après-midi", "Bonne nuit");
                break;
            case "de":
                msg = "Hallo, ";
                cumprimento = new Cumprimento("Guten morgen", "Guten tag", "Gute nacht");
                break;
            case "es":
            	msg = "Hola, ";
            	cumprimento = new Cumprimento("Buen día", "Buenas tardes", "Buenas noches");
            	break;
            case "it":
            	msg = "Ciao, ";
            	cumprimento = new Cumprimento("Buongiorno", "Buon pomeriggio", "Buona Notte");
                break;
        }
		return msg;
	}

    /**
     * Com base no input de Texto fornecido pelo usuário retorna o nome  
     * @param request
     * @param msg
     * @return nome
     */
	private String getNome(HttpServletRequest request, String msg) {
		String nome = request.getParameter("nome");
        
        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";
		return msg;
	}

    /**
     * Com base no input Data fornecido pelo usuário retorna o aniversário 
     * @param request
     * @param local
     * @return idade
     * @throws Exception 
     */
	private int qualEMinhaIdade(HttpServletRequest request, LocalDateTime local) throws Exception {
		int ano;
		int idade;
		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        String parameter = request.getParameter("data");
            
        Date date = null;
		try {
			date = in.parse(parameter);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		ano = date.getYear() + 1900;
		idade = local.getYear() - ano;
		return idade;
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