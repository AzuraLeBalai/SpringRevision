

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextAttributeListener implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContext attribute added::{"+servletContextAttributeEvent.getName()+","+servletContextAttributeEvent.getValue()+"}");
    }

    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContext attribute replaced::{"+servletContextAttributeEvent.getName()+","+servletContextAttributeEvent.getValue()+"}");
    }

    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("ServletContext attribute removed::{"+servletContextAttributeEvent.getName()+","+servletContextAttributeEvent.getValue()+"}");
    }

}
