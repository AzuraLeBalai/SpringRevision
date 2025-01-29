<html>
    <body>
    <%! // déclaration de l'objet compteur
    public class Cpt
    { private int val=0;
    public String getVal()
    {
    return "" + val; }
    public void incr() {val++;}
    }
    %>

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