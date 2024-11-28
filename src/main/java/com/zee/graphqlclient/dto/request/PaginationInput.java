package com.zee.graphqlclient.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 28 Nov, 2024
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PaginationInput {

    @JsonProperty("dobStart")
    private String dobStart;
    @JsonProperty("dobEnd")
    private String dobEnd;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("salaryFrom")
    private String salaryFrom;
    @JsonProperty("salaryTo")
    private String salaryTo;
    @JsonProperty("ageStart")
    private Integer ageStart;
    @JsonProperty("ageEnd")
    private Integer ageEnd;
    @JsonProperty("role")
    private String role;
}
