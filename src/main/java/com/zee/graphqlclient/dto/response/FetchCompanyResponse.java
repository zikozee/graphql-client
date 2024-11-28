package com.zee.graphqlclient.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.zee.graphqlclient.dto.Error;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 28 Nov, 2024
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Data
public class FetchCompanyResponse extends Error {

    private DataDTO data;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @NoArgsConstructor
    @Data
    public static class DataDTO {
        private FetchAllCompanyDTO fetchAllCompany;

        @JsonIgnoreProperties(ignoreUnknown = true)
        @NoArgsConstructor
        @Data
        public static class FetchAllCompanyDTO {
            private Boolean success;
            private String message;
            private List<CompaniesDTO> companies;

            @JsonIgnoreProperties(ignoreUnknown = true)
            @NoArgsConstructor
            @Data
            public static class CompaniesDTO {
                private String name;
                private String rcNumber;
                private String headOffice;
                private String country;
            }
        }
    }
}
