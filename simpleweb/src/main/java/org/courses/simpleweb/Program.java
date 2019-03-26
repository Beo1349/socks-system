package org.courses.simpleweb;

import org.courses.data.DAO.DAO;
import org.courses.domain.hbm.Type;
import org.courses.simpleweb.endpoint.TestWebService;
import org.courses.simpleweb.endpoint.TypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.ws.Endpoint;
import java.util.Collection;

public class Program  {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DAO<Type, Integer> dao = (DAO<Type, Integer>) context.getBean("getTypeDao");
      /*  Endpoint.publish(
                "http://localhost:8080/testservice",
                new TestWebService());*/
        Endpoint.publish(
                "http://localhost:8080/typeservice",
                new TypeService(dao));
    }


}