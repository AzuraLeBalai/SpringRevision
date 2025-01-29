<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page errorPage="erreur.jsp" %>
<%@ page isELIgnored = "false" %>

<html>
<head>
<link rel=stylesheet href=../style.css>
<title>Page1 protégée</title>
</head>

<h1>Page1<h1>
<h2>Bonjour Mr/Mme <%=session.getAttribute("token")%>, bienvenu sur ce site<h2>
    
<h2>Bonjour Mr/Mme ${token}, bienvenu sur ce site<h2>

<body>
