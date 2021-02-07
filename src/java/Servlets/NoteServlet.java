/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

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
import models.Note;

/**
 *
 * @author WCour
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        Note curNote = new Note();
        curNote.setText(br.readLine());
        curNote.setContent(br.readLine());

        String page = request.getParameter("edit");
        br.close();
        if (page != null) {
            request.setAttribute("eTitle", curNote.getTitle());
            request.setAttribute("eContent", curNote.getContent());
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        } else {

            request.setAttribute("title", curNote.getTitle());
            request.setAttribute("content", curNote.getContent());
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)))) {
            Note wowee = new Note();

            String title = request.getParameter("eTitle");
            String content = request.getParameter("eContent");

            wowee.setText(title);
            wowee.setContent(content);
            pw.println(wowee.getTitle());
            pw.println(wowee.getContent());

            request.setAttribute("title", wowee.getTitle());
            request.setAttribute("content", wowee.getContent());
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            pw.close();
        }

    }

}
