package com.zee.graphqlclient.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PaginationResponse {

    private DataDTO data;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @NoArgsConstructor
    @Data
    public static class DataDTO {
        private EmployeePaginationDTO employeePagination;

        @JsonIgnoreProperties(ignoreUnknown = true)
        @NoArgsConstructor
        @Data
        public static class EmployeePaginationDTO {
            @JsonProperty("page")
            private Integer page;
            @JsonProperty("size")
            private Integer size;
            @JsonProperty("totalPage")
            private Integer totalPage;
            @JsonProperty("totalElement")
            private Integer totalElement;
            @JsonProperty("employeeConnection")
            private EmployeeConnectionDTO employeeConnection;

            @JsonIgnoreProperties(ignoreUnknown = true)
            @NoArgsConstructor
            @Data
            public static class EmployeeConnectionDTO {
                @JsonProperty("edges")
                private List<EdgesDTO> edges;

                @JsonIgnoreProperties(ignoreUnknown = true)
                @NoArgsConstructor
                @Data
                public static class EdgesDTO {
                    @JsonProperty("node")
                    private NodeDTO node;

                    @JsonIgnoreProperties(ignoreUnknown = true)
                    @NoArgsConstructor
                    @Data
                    public static class NodeDTO {
                        @JsonProperty("uuid")
                        private String uuid;
                        @JsonProperty("name")
                        private String name;
                        @JsonProperty("dateOfBirth")
                        private String dateOfBirth;
                        @JsonProperty("gender")
                        private String gender;
                        @JsonProperty("salary")
                        private Double salary;
                        @JsonProperty("role")
                        private String role;
                        @JsonProperty("age")
                        private Integer age;
                        @JsonProperty("active")
                        private Boolean active;
                        @JsonProperty("employeeId")
                        private String employeeId;
                    }
                }
            }
        }
    }
}
