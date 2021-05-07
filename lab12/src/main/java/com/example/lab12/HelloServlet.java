package com.example.lab12;

import java.io.*;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "indexServlet", value = {"/","/index"})
public class HelloServlet extends HttpServlet {
    List<Question> ques;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ques=Question.creatQuestions();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session=request.getSession();
        session.setAttribute("count",0);
        session.setAttribute("score",0);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>The Number Quiz</h1>\n" +
                "<p>Your Current Score is\n" +
                0 +
                "</p>\n" +
                "<p>Guess the next number in sequence</p>\n" +
                 ques.get(0).element+
                "<form action=\"index\" method=\"post\">\n" +
                "    <label>Your answer:</label>\n" +
                "    <input type=\"text\" name=\"answer\"><br/><br/>\n" +
                "    <button>Submit</button>\n" +
                "</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session=req.getSession();
        int count=(int)session.getAttribute("count");
        int score=(int)session.getAttribute("score");
        session.setAttribute("count",count+1);
        int prevanswer=Integer.parseInt("0"+req.getParameter("answer"));
        if(prevanswer==ques.get(count).answer)
        {
            session.setAttribute("score",score+1);
        }
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>The Number Quiz</h1>\n" +
                "<p>Your Current Score is\n" +
                session.getAttribute("score") +
                "</p>\n");
        if(count<ques.size()-1) {
        out.println("<p>Guess the next number in sequence</p>\n" +
                ques.get((int)session.getAttribute("count")).element+
                "<form action=\"index\" method=\"Post\">\n" +
                "    <label>Your answer:</label>\n" +
                "    <input type=\"text\" name=\"answer\"><br/><br/>\n" +
                "    <button>Submit</button>\n" +
                "</form>");
        }
        else{
               out.println("<p>You have completed the Number Quiz, with score of "+(int)session.getAttribute("score")+" out of "+ques.size()+"</p>");
    }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}