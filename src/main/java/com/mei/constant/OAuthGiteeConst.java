package com.mei.constant;

import com.mei.entity.token;

/**
 * Gitee的相关东西
 */
public final class OAuthGiteeConst {

    public final static String Client_ID = "0cacf35545c6723f98d887432c469431032b2140ad142fd7e8bb4cc9c54dc35c";

    public final static String Client_Secret = "0711fc851316043bb7ae67bc13ad9e57d4b90e046e671021a2990de1fadb948a";

    public final static String redirect_uri = "http://localhost:8088/oauth/redirect";

    /**
     * 用户授权码
     */
    public static String user_code = null;

    /**
     * 令牌
     */
    public static token token = null;

    /**
     * @param code 用户授权授权码
     * @return 该URL地址可以获取令牌
     */
    public static String GiteeURL(String code) {
        return "https://gitee.com/oauth/token?" +
                "grant_type=authorization_code" +
                "&code=" + code +
                "&client_id=" + Client_ID +
                "&redirect_uri=" + redirect_uri +
                "&client_secret=" + Client_Secret;
    }

    /**
     * 获取用户信息
     *
     * @param access_token
     * @return
     */
    public static String user_info(String access_token) {
        return "https://gitee.com/api/v5/user?access_token=" + access_token;
    }
}
