/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import domain.Note;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Phillip Obiora
 */
public class NoteServlet extends HttpServlet {
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
       String path = getServletContext().getRealPath("/WEB-INF/note.txt");
       String edit = request.getParameter("edit");
       String title = null;
       String content = null;
       
       // read Lines
       BufferedReader br = new BufferedReader(new FileReader(new File(path)));
       for(int i = 0; i < 2; i++){
            if(i == 0){
                title = br.readLine();
            }else if(i == 1){
                content = br.readLine();
            }
       }
       
       br.close();
       
       Note n = new Note(title, content);
       request.setAttribute("Note", n);
       
       
       if(edit != null && edit.equals("true")){
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response);
       }else{
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
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
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        String title = request.getParameter("ntitle");
        String content = request.getParameter("tarea");
        String save = title + "\n" + content;
        
        // to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        pw.write(save);
        pw.close();
 
        // read Lines
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        for(int i = 0; i < 2; i++){
            if(i == 0){
                title = br.readLine();
            }else if(i == 1){
                content = br.readLine();
            }
        }
        br.close();
        
        Note n = new Note(title, content);
        request.setAttribute("Note", n);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }
}
