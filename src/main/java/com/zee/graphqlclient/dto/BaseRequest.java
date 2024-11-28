package com.zee.graphqlclient.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 28 Nov, 2024
 */


@Getter
@Setter
@ToString
public class BaseRequest {
    private String query;
    private Map<String, ?> variables;
}
