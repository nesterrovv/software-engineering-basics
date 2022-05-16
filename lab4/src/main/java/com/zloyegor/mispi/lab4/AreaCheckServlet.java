package com.zloyegor.mispi.lab4;

import com.google.gson.Gson;
import com.zloyegor.mispi.lab4.management.DotChecker;
import com.zloyegor.mispi.lab4.management.TimeSpanQualifier;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/calculate")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String x = request.getParameter("x_value").replace(",", ".");
        String y = request.getParameter("y_value").replace(",", ".");
        String r = request.getParameter("r_value").replace(",", ".");

        String type = request.getParameter("type");

        long time = System.nanoTime();
        boolean valid = validate(x, y, r);
        if (valid) {
            double xValue = Double.parseDouble(x);
            double yValue = Double.parseDouble(y);
            double rValue = Double.parseDouble(r);
            boolean result = checkArea(xValue, yValue, rValue);

            long deltaTime = System.nanoTime() - time;
            Dot dot = new Dot(xValue, yValue, rValue, String.valueOf(deltaTime / 1000000000.), new Timestamp(System.currentTimeMillis()).toString(), result);

            DotChecker.getInstance().process(dot.isResult());
            if (type.equals("svg"))
                TimeSpanQualifier.getInstance().process();

            HttpSession session = request.getSession();
            ArrayList<Dot> dots = (ArrayList<Dot>) session.getAttribute("dots");


            if (dots == null) {
                dots = new ArrayList<>();
            }

            dots.add(dot);
            session.setAttribute("dots", dots);

            Gson gson = new Gson();
            String JSONResponse = gson.toJson(dot);
            response.getWriter().print(JSONResponse);
            request.getSession().setAttribute("serverInfo", true);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            ServletContext context = getServletContext();
            context.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    public boolean validate(String x, String y, String r) {
        return !(!checkX(x) || !checkY(y) || !checkR(r));
    }

    public boolean checkX(String x) {
        try {
            double doubleY = Double.parseDouble(x);
            return ((doubleY >= -5.) && (doubleY <= 3.));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkY(String y) {
        try {
            double doubleY = Double.parseDouble(y);
            return ((doubleY > -5.) && (doubleY < 3.));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkR(String r) {
        try {
            Double[] possibleValues = {1.0, 1.5, 2., 2.5, 3.};
            double doubleR = Double.parseDouble(r);
            return Arrays.asList(possibleValues).contains(doubleR);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkArea(double x, double y, double r) {
        //2 квадрант
        if (x <= 0 && y >= 0) {
            return Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r / 2, 2);
        }
        //3 квадрант
        if (x <= 0 && y <= 0) {
            return (y >= -2 * x - r);
        }
        //4 квадрант
        if (x >= 0 && y <= 0) {
            return (x <= r / 2 && y >= -r);
        }
        //1 квадрант
        return false;
    }

}

