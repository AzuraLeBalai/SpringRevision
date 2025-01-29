import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.servlet.http.HttpSessionEvent;

@WebListener
public class SessionCounterListener implements HttpSessionListener {

    private int activeSessions;

    public SessionCounterListener() {
        super();

        activeSessions = 0;
    }

    public int getTotalActiveSession() {
        return activeSessions ;
    }

    public void sessionCreated(final HttpSessionEvent event) {
        this.activeSessions += 1;
        System.out.println(this.activeSessions + " session active");
    }
    public void sessionDestroyed(final HttpSessionEvent event) {
        this.activeSessions -= 1;
        System.out.println(this.activeSessions + " session active");
    }
}