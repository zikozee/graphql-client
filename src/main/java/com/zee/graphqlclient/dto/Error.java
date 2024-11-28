package com.zee.graphqlclient.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 28 Nov, 2024
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
public class Error {

    private List<ErrorsDTO> errors;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @NoArgsConstructor
    @Data
    public static class ErrorsDTO {
        private String message;
        private List<LocationsDTO> locations;

        @JsonIgnoreProperties(ignoreUnknown = true)
        @NoArgsConstructor
        @Data
        public static class LocationsDTO {
            private Integer line;
            private Integer column;
        }
    }
}
