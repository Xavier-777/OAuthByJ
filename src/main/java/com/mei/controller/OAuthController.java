package com.mei.controller;

import com.google.gson.Gson;
import com.mei.constant.OAuthGiteeConst;
import com.mei.entity.token;
import com.mei.entity.user;
import com.mei.utils.httpUtils;
import spark.Route;

import static spark.Spark.get;


public class OAuthController {

    /**
     * web初始化，可以将路由放在这里
     */
    public static void init() {
        get("/", toIndex);
        get("/oauth/redirect", oauth);
    }

    public static Route toIndex = (request, response) -> {
        response.redirect("/views/index.html");
        return null;
    };

    /**
     * 完成OAuth认证，获取授权码
     */
    public static Route oauth = (request, response) -> {
        OAuthGiteeConst.user_code = request.queryParams("code");            //从URL中获取授权码
        token token = httpUtils.tokenResponse(OAuthGiteeConst.user_code);   //获取到token令牌
        user user = httpUtils.Gitee_info(token.getAccess_token());        //使用Access_token获取用户信息
        response.redirect("/views/welcome.html?id=" + user.getId() + "&login=" + user.getLogin() + "&Html_url=" + user.getHtml_url());
        return null;
    };
}
