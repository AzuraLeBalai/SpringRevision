<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="fr.but3.Cpt" %>
<html>
<head>
    <title>Compteur avec useBean</title>
</head>
<body>
    <jsp:useBean id="global" class="Cpt" scope="application" />
    <jsp:useBean id="local" class="Cpt" scope="session" />

    <%
        Cpt global=(Cpt)application.getAttribute("global");
            if (global==null)
            { global=new Cpt();
            application.setAttribute("global",global);
            }
            global.incr();
            // initialisation du compteur local
            Cpt local=(Cpt)session.getAttribute("local");
            if (local==null)
            { local=new Cpt();
            session.setAttribute("local",local);
            }
            local.incr();
    %>

    <h1>Revoilà notre compteur</h1>
    Cette page a été accédée <%= global.getVal() %> fois globalement et <%= local.getVal() %> fois localement.
</body>
</html>