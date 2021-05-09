package com.example.lab13;

import java.io.*;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = {"/hello-servlet","/"})
public class HelloServlet extends HttpServlet {

    List<Question> ques;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ques=Question.creatQuestions();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        session.setAttribute("count", 0);
        session.setAttribute("score", 0);
        request.setAttribute("question", ques.get(0).element);
        request.setAttribute("answer", ques.get(0).answer);

        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);

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
        req.setAttribute("question", ques.get(count).element);
        req.setAttribute("answer", ques.get().answer);
        if(count<ques.size()-1)
            req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
        else//Last question
            req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);

    }

    public void destroy() {
    }
}