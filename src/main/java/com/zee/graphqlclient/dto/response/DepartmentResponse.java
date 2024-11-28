package com.zee.graphqlclient.dto.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class DepartmentResponse {


    private DataDTO data;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @NoArgsConstructor
    @Data
    public static class DataDTO {
        private CreateDepartmentDTO createDepartment;

        @JsonIgnoreProperties(ignoreUnknown = true)
        @NoArgsConstructor
        @Data
        public static class CreateDepartmentDTO {
            private Boolean success;
            private String message;
            private String uuid;
        }
    }
}
