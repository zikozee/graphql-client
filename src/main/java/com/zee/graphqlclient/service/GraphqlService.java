package com.zee.graphqlclient.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zee.graphqlclient.client.Client;
import com.zee.graphqlclient.dto.BaseRequest;
import com.zee.graphqlclient.dto.request.CompanyInput;
import com.zee.graphqlclient.dto.request.DepartmentInput;
import com.zee.graphqlclient.dto.request.PaginationInput;
import com.zee.graphqlclient.dto.response.CreateCompanyResponse;
import com.zee.graphqlclient.dto.response.DepartmentResponse;
import com.zee.graphqlclient.dto.response.FetchCompanyResponse;
import com.zee.graphqlclient.dto.response.PaginationResponse;
import com.zee.graphqlclient.query.QueryDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import java.util.Base64;
import java.util.Map;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 28 Nov, 2024
 */

@Service
public class GraphqlService {

    public FetchCompanyResponse getAlCompany(){
        BaseRequest request = new BaseRequest();
        request.setQuery(QueryDetails.FETCH_ALL_COMPANY);

        return Client.send(request, FetchCompanyResponse.class, getBaseHttpHeaders());

    }

    public CreateCompanyResponse createCompany(int companyId) {

        CompanyInput input = CompanyInput.builder()
                .name("Test-Company" + companyId)
                .rcNumber("Test5432" + companyId)
                .headOffice("Test Address 5432" + companyId)
                .country("Nigeria")
                .businessType("BANKING")
                .build();

        BaseRequest request = new BaseRequest();
        request.setQuery(QueryDetails.CREATE_COMPANY);
        request.setVariables(Map.of("newCompany", input));
        return Client.send(request, CreateCompanyResponse.class, getBaseHttpHeaders());
    }


    public DepartmentResponse createDepartment(int id) {

        DepartmentInput.AddressDTO addressDTO = DepartmentInput.AddressDTO.builder()
                .entityId("8524" + id)
                .street("saka" + id)
                .city("Lagos")
                .state("Lagos")
                .zipCode(104233)
                .build();


        DepartmentInput input = DepartmentInput.builder()
                .name("Human Resources"+ id)
                .departmentNo("8524" + id)
                .companyName("Test-Company" + id)
                .rcNumber("Test5432" + id)
                .division("HR")
                .address(addressDTO)
                .build();



        BaseRequest request = new BaseRequest();
        request.setQuery(QueryDetails.CREATE_DEPARTMENT);
        request.setVariables(Map.of("newDept", input));

        return Client.send(request, DepartmentResponse.class, getBaseHttpHeaders());

    }


    public PaginationResponse paginate(int page, int size) {

        PaginationInput input = PaginationInput.builder()
                .dobStart("1960-09-04")
                .dobEnd("1998-09-04")
                .gender("MALE")
                .salaryFrom("30000.05")
                .salaryTo("50000.52")
                .ageStart(23)
                .ageEnd(30)
                .role("INTERN")
                .build();

        BaseRequest request = new BaseRequest();
        request.setQuery(QueryDetails.EMPLOYEE_PAGINATION);
        request.setVariables(Map.of("input", input, "page", page, "size", size));
        return Client.send(request, PaginationResponse.class, getBaseHttpHeaders());

    }

    private HttpHeaders getBaseHttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        if(getAccessTokenResponse() == null){
            throw new RuntimeException("getAccessTokenResponse is null");
        }
        headers.set(HttpHeaders.AUTHORIZATION, getAccessTokenResponse().tokenType + " " + getAccessTokenResponse().accessToken );
        return headers;
    }

    private AccessTokenResponse getAccessTokenResponse() {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "client_credentials");
        formData.add("scope", "openid");

        RestClient restClient = RestClient.create();

        return restClient
                .post().uri("http://localhost:8099/oauth2/token")
                .body(formData)
                .header(HttpHeaders.AUTHORIZATION, "Basic " + Base64.getEncoder().encodeToString(("client" + ":" + "secret").getBytes()))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .retrieve()
                .body(AccessTokenResponse.class);

    }

    private record AccessTokenResponse(
            @JsonProperty("access_token")
            String accessToken,
            @JsonProperty("token_type")
            String tokenType
    ){}
}
