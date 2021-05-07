package com.gyf.curriculum_arrangement_system_springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.gyf") //看这个包下的类有没有bean注解    描到有@Component、@Controller、@Service等这些注解的类，并注册为Bean，
@MapperScan("com.gyf.mapper") //使com.gyf.mapper生成代理
public class CurriculumArrangementSystemSpringbootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CurriculumArrangementSystemSpringbootApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CurriculumArrangementSystemSpringbootApplication.class);
    }
}
