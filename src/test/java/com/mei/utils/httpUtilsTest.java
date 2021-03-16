package com.mei.utils;

import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;
import org.junit.Test;

import java.io.IOException;

public class httpUtilsTest {

    @Test
    public void test() throws IOException {
        Content content = Request.get("http://www.baidu.com")
                .execute().returnContent();

        System.out.println(content);
    }
}
