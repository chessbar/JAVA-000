package io.github.kimmking.gateway.outbound.myhttp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class MyHttpOutboundHandler {

    private CloseableHttpClient httpClient;
    private String backendUrl;

    public MyHttpOutboundHandler(String backendUrl) {
        this.backendUrl = backendUrl.endsWith("/") ? backendUrl.substring(0, backendUrl.length() - 1) : backendUrl;
        httpClient =  HttpClientBuilder.create().build();

    }

    public void handle(final FullHttpRequest fullHttpRequest, final ChannelHandlerContext ctx) {
        final String url = this.backendUrl + fullHttpRequest.uri();
        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpGet);
            HttpEntity responseEntity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
