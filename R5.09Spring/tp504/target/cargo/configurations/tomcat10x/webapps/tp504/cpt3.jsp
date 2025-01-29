<%@ page import="fr.but3.Cpt" %>
<html>
    <body>

    <% // initialisation du compteur global
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

    Cette page a été accédée <%= global.getVal() %> fois et <%= local.getVal() %> fois.
    </body
</html