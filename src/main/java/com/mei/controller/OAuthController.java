package com.mei.controller;

import com.google.gson.Gson;
import com.mei.constant.OAuthGiteeConst;
import com.mei.entity.user;
import com.mei.utils.httpUtils;
import spark.Route;

import static spark.Spark.get;
import static spark.Spark.post;


public class OAuthController {

    /**
     * web初始化，可以将路由放在这里
     */
    public static void init() {
        get("/", toIndex);
        get("/oauth/redirect", oauth);
        post("/user/getInfo", getInfo);
    }

    /**
     * 转跳到index页面
     */
    public static Route toIndex = (request, response) -> {
        response.cookie("passkey", "yes");    //过滤，防止用户恶意访问资源
        response.redirect("/views/index.html");
        return null;
    };

    /**
     * 完成OAuth认证，获取授权码,并用授权码获取令牌
     */
    public static Route oauth = (request, response) -> {
        OAuthGiteeConst.user_code = request.queryParams("code");                      //从URL中获取授权码
        OAuthGiteeConst.token = httpUtils.tokenResponse(OAuthGiteeConst.user_code);   //使用授权码获取到token令牌
        response.redirect("/views/welcome.html");
        return null;
    };

    /**
     * 获取Gitee的用户信息
     */
    public static Route getInfo = (request, response) -> {
        user user = httpUtils.Gitee_info(OAuthGiteeConst.token.getAccess_token());    //使用token获取Gitee的用户信息
        return new Gson().toJson(user);
    };
}
