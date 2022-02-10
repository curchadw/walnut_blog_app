package com.example.blog;

import com.example.blog.post.PostController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackageClasses = PostController.class)
public class WalnutBlogApplication {



    public static void main(String[] args) {
        SpringApplication.run(WalnutBlogApplication.class, args);
    }

}
