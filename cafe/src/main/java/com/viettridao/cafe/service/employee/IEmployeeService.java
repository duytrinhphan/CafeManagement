package com.viettridao.cafe.service.employee;

import java.util.List;


import com.viettridao.cafe.dto.request.employee.EmployeeCreateRequest;
import com.viettridao.cafe.dto.request.employee.EmployeeUpdateRequest;
import com.viettridao.cafe.dto.response.employee.EmployeeResponse;

public interface IEmployeeService {

    List<EmployeeResponse> getEmployeeAll();

    void createEmployee(EmployeeCreateRequest request);

    EmployeeUpdateRequest getUpdateForm(Integer id);

    void updateEmployee(Integer id, EmployeeUpdateRequest request);

    void deleteEmployee(Integer id);

}
