package com.viettridao.cafe.service.employee;

import java.util.List;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.viettridao.cafe.dto.request.employee.EmployeeCreateRequest;
import com.viettridao.cafe.dto.request.employee.EmployeeUpdateRequest;
import com.viettridao.cafe.dto.response.employee.EmployeeResponse;
import com.viettridao.cafe.mapper.EmployeeMapper;
import com.viettridao.cafe.model.EmployeeEntity;
import com.viettridao.cafe.model.PositionEntity;
import com.viettridao.cafe.repository.EmployeeRepository;
import com.viettridao.cafe.service.position.IPositionService;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService{

    private final EmployeeRepository employeeRepository;
    private final IPositionService positionService;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeResponse> getEmployeeAll() {
        return employeeRepository.findEmployeeByDeletedFalse()
                .stream()
                .map(employeeMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public void createEmployee(EmployeeCreateRequest request) {

        EmployeeEntity entity = employeeMapper.toEntity(request, positionService);

        employeeRepository.save(entity);

    }

    @Override
    public EmployeeUpdateRequest getUpdateForm(Integer id) {
        EmployeeEntity entity = findEmployeeOrThrow(id);
        EmployeeUpdateRequest dto = employeeMapper.toUpdateRequest(entity);
        dto.setPositionId(entity.getPosition().getId());
        dto.setSalary(entity.getPosition().getSalary());
        return dto;
    }

    @Override
    @Transactional
    public void updateEmployee(Integer id, EmployeeUpdateRequest request) {

        EmployeeEntity existing = findEmployeeOrThrow(id);

        // Gán PositionEntity từ ID
        PositionEntity position = positionService.getPositionById(request.getPositionId());
        existing.setPosition(position);

        employeeMapper.updateEntityFromRequest(request, existing);

        employeeRepository.save(existing);

    }

    @Override
    @Transactional
    public void deleteEmployee(Integer id) {

        EmployeeEntity entity = findEmployeeOrThrow(id);

        entity.setDeleted(true);

        employeeRepository.save(entity);
    }

    private EmployeeEntity findEmployeeOrThrow(Integer id){
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên với id = " + id));
    }
}
