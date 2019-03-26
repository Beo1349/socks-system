package org.courses.simpleweb;


import org.courses.data.DAO.DAO;
import org.courses.domain.hbm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Scanner;

@Configuration
@Import(org.courses.data.SpringConfig.class)
public class SpringConfig {

    @Autowired
    DAO<Type, Integer> typeDao;


    @Bean(name = "getTypeDao")
    public DAO<Type, Integer> getTypeDao() {
        return typeDao;
    }
}
