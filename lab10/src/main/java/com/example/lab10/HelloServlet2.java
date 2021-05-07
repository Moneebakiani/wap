package com.example.lab10;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet2", value = {"/hello2"})
public class HelloServlet2 extends HelloServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a=request.getParameter("input1");
        String b=request.getParameter("input2");
        String c=request.getParameter("input3");
        String d=request.getParameter("input4");

        String add=sum(a,b);
        String sub=product(c,d);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>calculator</title></head>");
        out.println("<body><h2>Simple Calculator</h2>" +
                "<form action=\"/lab10_war_exploded/index.html\">\n" +
                "<input type=\"text\" name=\"input1\" value=\""+a+"\"><span>+</span> \n" +
                "<input type=\"text\" name=\"input2\" value=\""+b+"\">\n" +
                " = <input type=\"text\" name=\"add\" value=\""+add+"\">\n" +
                "<br><br>\n" +
                "<input type=\"text\" name=\"input3\" value=\""+c+"\">*\n" +
                "<input type=\"text\" name=\"input4\" value=\""+d+"\">\n" +
                " = <input type=\"text\" name=\"product\" value=\""+sub+"\">\n" +
                "<br><br>\n" +
                "<input type=\"submit\">\n" +
                "</form>" +
                "</body></html>");

    }

    private static String sum(String num1,String num2){
        int s=0;
        try {
            s=Integer.parseInt(num1)+Integer.parseInt(num2);
        } catch (NumberFormatException e) {

        }
        return Integer.toString(s);
    }
    private static String product(String num1,String num2){
        int p=0;
        try {
            p=Integer.parseInt(num1)*Integer.parseInt(num2);
        } catch (NumberFormatException e) {

        }
        return Integer.toString(p);
    }
}
