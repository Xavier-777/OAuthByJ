本项目使用Gitee的OAuth模拟第三方跳转登陆，建议自己去申请一个Gitee的OAuth，这样理解代码会更深入，当然，你也可以不申请，直接用我的

<br>

申请详见官文文档：
<a href="https://gitee.com/api/v5/oauth_doc#/">https://gitee.com/api/v5/oauth_doc#/

<br>

申请成功后，在 OAuthGiteeConst.class 中修改自己的 Client_ID 、Client_Secret 、redirect_uri

还有index.html中，也要修改自己的 client_id 、redirect_uri

<br>

使用方法：在 Main.class 中，直接运行 main 方法，然后在浏览器中输入 <a href="http://localhost:8088">http://localhost:8088</a> 即可运行项目

<br>

博客说明：<a href="https://blog.csdn.net/lendsomething/article/details/114867366">https://blog.csdn.net/lendsomething/article/details/114867366</a>