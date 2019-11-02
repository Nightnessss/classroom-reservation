package com.fehead;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.fehead.dao")
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "这是第一个java程序" );
        SpringApplication.run(App.class, args);
    }
}
