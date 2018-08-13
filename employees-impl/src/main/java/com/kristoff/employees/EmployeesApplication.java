package com.kristoff.employees;

import com.kristoff.common.filter.LangFilter;
import com.kristoff.employees.filter.CorsFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.kristoff.employees.dao")
@EnableSwagger2
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 5) session失效时间
public class EmployeesApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeesApplication.class, args);
    }

    @Bean
    public LangFilter langFilter() {
        return new LangFilter();
    }

    /*@Bean
    public CorsFilter corsFilter() {
        return new CorsFilter();
    }*/

}
