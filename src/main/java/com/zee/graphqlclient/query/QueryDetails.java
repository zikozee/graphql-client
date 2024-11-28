package com.zee.graphqlclient.query;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 28 Nov, 2024
 */

public interface QueryDetails {

    String FETCH_ALL_COMPANY = """
            query fetchAllCompany {
              fetchAllCompany {
                success
                message
                companies {
                  name
                  rcNumber
                  headOffice
                  country
                }
              }
            }
            """;

    String CREATE_COMPANY = """
            mutation createCompany($newCompany: CompanyInput!) {
              createCompany(companyInput: $newCompany) {
                success
                message
                uuid
              }
            }
            """;


    String CREATE_DEPARTMENT = """
            mutation createDepartment($newDept: DepartmentInput!) {
              createDepartment(departmentInput: $newDept) {
                success
                message
                uuid
              }
            }
            """;

    String EMPLOYEE_PAGINATION = """
            query employeePagination(
              $input: EmployeeSearchInput
              $page: Int
              $size: Int
            ) {
              employeePagination(
                search: $input
                page: $page
                size: $size
              ) {
                page
                size
                totalPage
                totalElement
                employeeConnection {
                  edges {
                    node {
                      uuid
                      name
                      dateOfBirth
                      gender
                      salary
                      role
                      age
                      active
                      employeeId
                    }
                  }
                }
              }
            }
            """;
}
