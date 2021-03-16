package com.mei;

import com.mei.controller.OAuthController;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8088);
        staticFiles.location("/public");
        before("/*",(request, response) -> {
            response.header("Content-Type", "text/html;charset=UTF-8"); //设置编码，好像没有解决
        });
        OAuthController.init();
        System.out.println("success,please click http://localhost:8088 to start!");
    }
}
