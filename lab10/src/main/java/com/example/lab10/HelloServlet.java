package com.example.lab10;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = {"/hello"})
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String a= sum(request.getParameter("input1"),request.getParameter("input2"));
        String b= product(request.getParameter("input3"),request.getParameter("input4"));

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<p>"+a+"<br/>"+b+"</p>");
        out.println("</body></html>");
    }

    
    private static String sum(String num1,String num2){
        String s="";
        try {
            s=(Integer.parseInt(num1)+" + "+Integer.parseInt(num2)+" = "+(Integer.parseInt(num1)+Integer.parseInt(num2)));
        } catch (NumberFormatException e) {

        }
        return s;
    }
    private static String product(String num1,String num2){
        String p="";
        try {
            p=(Integer.parseInt(num1)+" * "+Integer.parseInt(num2)+" = "+(Integer.parseInt(num1)*Integer.parseInt(num2)));
        } catch (NumberFormatException e) {

        }
        return p;
    }
}