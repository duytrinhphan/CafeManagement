package com.viettridao.cafe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.viettridao.cafe.dto.request.employee.EmployeeCreateRequest;
import com.viettridao.cafe.dto.request.employee.EmployeeUpdateRequest;
import com.viettridao.cafe.service.employee.IEmployeeService;
import com.viettridao.cafe.service.position.IPositionService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final IEmployeeService employeeService;
    private final IPositionService positionService;

    @GetMapping
    public String listEmployee(Model model) {
        model.addAttribute("employees", employeeService.getEmployeeAll());
        return "employee/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model){
        model.addAttribute("employee", new EmployeeCreateRequest());
        model.addAttribute("positions", positionService.getPositionAll());
        return "employee/form-create";
    }

    @PostMapping
    public String createEmployee(@ModelAttribute("employee") EmployeeCreateRequest request) {
        employeeService.createEmployee(request);
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm (@PathVariable Integer id, Model model) {
        EmployeeUpdateRequest updateRequest = employeeService.getUpdateForm(id);
        updateRequest.setPositionId(updateRequest.getPositionId());
        model.addAttribute("employee", updateRequest);
        model.addAttribute("employeeId", id);
        model.addAttribute("positions", positionService.getPositionAll());
        return "employee/form-edit";
    }

    @PostMapping("/{id}")
    public String updateEmployee(@PathVariable Integer id, @ModelAttribute("employee") EmployeeUpdateRequest request) {
        employeeService.updateEmployee(id, request);
        return "redirect:/employee";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }
}
