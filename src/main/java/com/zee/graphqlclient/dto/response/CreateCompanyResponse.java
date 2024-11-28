package com.zee.graphqlclient.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.zee.graphqlclient.dto.Error;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 28 Nov, 2024
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
public class CreateCompanyResponse extends Error {

    private DataDTO data;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @NoArgsConstructor
    @Data
    public static class DataDTO {
        private CreateCompanyDTO createCompany;

        @JsonIgnoreProperties(ignoreUnknown = true)
        @NoArgsConstructor
        @Data
        public static class CreateCompanyDTO {
            private Boolean success;
            private String message;
            private String uuid;
        }
    }
}
