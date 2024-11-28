package com.zee.graphqlclient.dto.request;


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
public class DepartmentInput {

    private String name;
    private String departmentNo;
    private String companyName;
    private String rcNumber;
    private String division;
    private AddressDTO address;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class AddressDTO {
        private String uuid;
        private String entityId;
        private String street;
        private String city;
        private String state;
        private Integer zipCode;
    }
}
