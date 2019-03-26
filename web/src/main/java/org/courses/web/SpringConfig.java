package org.courses.web;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.courses.data.DAO.DAO;
import org.courses.domain.hbm.Material;
import org.courses.web.rest.TestService;
import org.courses.web.soap.DbTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.xml.ws.Endpoint;

/**
 * Created by dleb on 03/21/2019.
 */
@Configuration
@EnableWebMvc
@Import(org.courses.data.SpringConfig.class)
public class SpringConfig {
    @Autowired
    DAO<Material, Integer> materialDao;

    @Bean
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new DbTestService(materialDao));
        endpoint.publish("/services/testservice");
        return endpoint;
    }

    @Bean
    public TestService restTestService() {
        return new TestService();
    }
}
