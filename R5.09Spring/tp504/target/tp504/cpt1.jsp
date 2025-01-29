<%@ page import=" java.util.*,java.util.concurrent.atomic.AtomicInteger"; %>
<html>
    <body>
        <% Atomic AtomicInteger global=(AtomicInteger)application.getAttribute("global");
        if(global==null)
        {global = new AtomicInteger()
        application.setAttribute("global",global);
        }
        Atomic AtomicInteger local=(AtomicInteger)session.getAttribute("local");
                if(local==null)
                {global = new AtomicInteger()
                application.setAttribute("local",local);
                }
        cpt = new AtomicInteger(); %>

        <H1>Revoilà notre compteur</H1>
        <% global.incrementAndGet(); %>
        <% local.incrementAndGet(); %>
        Cette page a été accédée <%= global %> fois et <%= local %>
    </body>
</html>