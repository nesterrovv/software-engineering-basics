package com.lab2.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    HttpServletRequest request;
    HttpServletResponse response;
    String check;
    String x;
    String y;
    String r;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        check = request.getParameter("check");
        x = request.getParameter("x");
        y = request.getParameter("y");
        r = request.getParameter("r");

        if (checkNull()) {
            if (check.equals("reload")) {
                response.sendRedirect("update.jsp");
            }else {
                request.getRequestDispatcher("/AreaCheckServlet").forward(request, response);
            }
            }else {
            response.setStatus(422);
        }
    }

    private boolean checkNull() {
        if (check != null && !check.trim().equals("") && (x != null && y != null && r != null) && (!x.trim().equals("")
                && !y.trim().equals("") && !r.trim().equals(""))) {
            return true;
        } else {
            return false;
        }
    }
}

