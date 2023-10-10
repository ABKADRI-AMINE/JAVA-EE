package com.example.demo;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "HELLO Amine!";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        request.setAttribute("name", name);
        request.setAttribute("email", email);

        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }


    public void destroy() {
    }
}