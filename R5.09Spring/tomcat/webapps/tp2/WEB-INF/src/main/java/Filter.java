import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@WebFilter("/*")
public class Filter extends HttpFilter {
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException
    {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(LocalDateTime.now());
        chain.doFilter(req, res);
        System.out.println(LocalDateTime.now().getNano() - time.getNano() );
        System.out.println("bite");
    }
}
