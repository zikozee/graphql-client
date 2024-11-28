package com.zee.graphqlclient.api;

import com.zee.graphqlclient.dto.response.CreateCompanyResponse;
import com.zee.graphqlclient.dto.response.DepartmentResponse;
import com.zee.graphqlclient.dto.response.FetchCompanyResponse;
import com.zee.graphqlclient.dto.response.PaginationResponse;
import com.zee.graphqlclient.service.GraphqlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 28 Nov, 2024
 */

@RequestMapping(path = "client")
@RestController
@RequiredArgsConstructor
public class GraphlController {

    private final GraphqlService service;

    @PostMapping(path = "all-company")
    public ResponseEntity<FetchCompanyResponse> getAllCompany(){
        return ResponseEntity.ok(service.getAlCompany());
    }

    @PostMapping(path = "create-company")
    public ResponseEntity<CreateCompanyResponse> createCompany(@RequestParam("companyId") int companyId){
        return ResponseEntity.ok(service.createCompany(companyId));
    }

    @PostMapping(path = "create-department")
    public ResponseEntity<DepartmentResponse> createDepartment(@RequestParam("departmentId") int departmentId){
        return ResponseEntity.ok(service.createDepartment(departmentId));
    }

    @PostMapping(path = "paginate")
    public ResponseEntity<PaginationResponse> paginate(@RequestParam("page") int page, @RequestParam("size") int size){
        return ResponseEntity.ok(service.paginate(page, size));
    }
}
