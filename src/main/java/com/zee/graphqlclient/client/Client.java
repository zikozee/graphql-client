package com.zee.graphqlclient.client;

import org.springframework.web.client.RestClient;
import java.util.List;
import java.util.Map;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 28 Nov, 2024
 */

public final class Client {

    private Client() {
        throw new RuntimeException("Do not instantiate");
    }

    public static <T, U> U send(T requestBody, Class<U> responseClass, Map<String, List<String>> headerMap){

        RestClient restClient = RestClient.create();

        return restClient
                .post().uri("http://localhost:8080/graphql")
                .body(requestBody)
                .headers(headers -> headers.putAll(headerMap))
                .retrieve()
                .body(responseClass);
    }
}
