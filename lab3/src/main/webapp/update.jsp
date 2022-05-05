<%@ page import="java.util.LinkedList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    ServletContext context = request.getServletContext();
    if(context.getAttribute("answer") != null) {
        LinkedList<String> answer = (LinkedList<String>) context.getAttribute("answer");
        for (String s : answer) {
            out.println(s);
        }
    }
%>