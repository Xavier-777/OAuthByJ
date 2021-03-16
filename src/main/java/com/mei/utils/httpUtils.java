package com.mei.utils;


import com.google.gson.Gson;
import com.mei.constant.OAuthGiteeConst;
import com.mei.entity.token;
import com.mei.entity.user;
import org.apache.hc.client5.http.fluent.Request;

import java.io.IOException;


public class httpUtils {

    /**
     * 使用授权码获取令牌
     * token:
     * {
     * "access_token":"0321262a1de5aa21c895a7be1b5dc655",
     * "token_type":"bearer",
     * "expires_in":86400,
     * "refresh_token":"2aefd773609d9ed7479d8ae289ea36f2beebb7bb78e3352d8e9ca4efad41dec9",
     * "scope":"user_info",
     * "created_at":1615882982
     * }
     *
     * @param code 授权码
     * @return 返回token令牌
     * @throws IOException
     */
    public static token tokenResponse(String code) throws IOException {
        String content = Request.post(OAuthGiteeConst.GiteeURL(code))
                .execute().returnContent().toString();
        token token = new Gson().fromJson(content, token.class);
        return token;
    }

    /**
     * 查询用户信息
     *
     * @param access_token
     * @return
     * @throws IOException
     */
    public static user Gitee_info(String access_token) throws IOException {
        String content = Request.get(OAuthGiteeConst.user_info(access_token))
                .execute().returnContent().asString();
        user user = new Gson().fromJson(content, user.class);
        return user;
    }
}
