import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

@WebListener
public class MyRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent paramServletRequestEvent) {

        HttpServletRequest request = (HttpServletRequest) paramServletRequestEvent.getServletRequest();
        System.out.println(request.getRequestURL());
    }
}
