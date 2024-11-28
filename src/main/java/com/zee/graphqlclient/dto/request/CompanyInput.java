package com.zee.graphqlclient.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 28 Nov, 2024
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyInput {
    private String name;
    private String rcNumber;
    private String headOffice;
    private String country;
    private String businessType;
}
