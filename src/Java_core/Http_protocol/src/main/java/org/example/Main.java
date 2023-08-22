package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

public class Main {

    static String REMOTE_SERVICE_URL = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public static void main(String[] args) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();) {

            HttpGet request = new HttpGet(REMOTE_SERVICE_URL);
            try (CloseableHttpResponse response = httpClient.execute(request);) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                List<Cats> cats = mapper.readValue(response.getEntity().getContent(), new TypeReference<List<Cats>>() {
                });
                for (int i = 0; i < cats.size(); i++) {
                    if (cats.get(i).getUpvotes() > 0) {
                        System.out.println(cats.get(i).toString());
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}