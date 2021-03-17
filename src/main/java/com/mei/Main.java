package com.mei;

import com.mei.controller.OAuthController;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8088);
        staticFiles.location("/public");
        after((request, response) -> {
            if (request.cookie("passkey") == null) {
                halt(401, "You are not welcome here");
            }
            response.header("Content-Type", "text/html;charset=UTF-8");
        });
        OAuthController.init();
        System.out.println("success,please click http://localhost:8088 to start!");
    }
}
