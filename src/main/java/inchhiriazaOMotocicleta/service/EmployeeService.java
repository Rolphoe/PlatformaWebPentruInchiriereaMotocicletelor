package inchhiriazaOMotocicleta.service;

import inchhiriazaOMotocicleta.entity.Employee;
import inchhiriazaOMotocicleta.mapper.EmployeeMapper;
import inchhiriazaOMotocicleta.model.employee.EmployeeRequest;
import inchhiriazaOMotocicleta.model.employee.EmployeeResponse;
import inchhiriazaOMotocicleta.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        checkDuplicate(employeeRequest);
        Employee employee = employeeMapper.map(employeeRequest);
        return employeeMapper.map(employeeRepository.save(employee));
    }

    public List<EmployeeResponse> allEmployees() {
        return employeeMapper.map(employeeRepository.findAll());
    }

    public EmployeeResponse findEmployeeById(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Angajatul cu id-ul: %s nu există!", id)));
        return employeeMapper.map(employee);
    }

    public void updateEmployee(EmployeeRequest employeeRequest) {
        checkDuplicate(employeeRequest);
        Employee employeeToUpdate = employeeRepository.findById(employeeRequest.getId()).orElseThrow(() -> new RuntimeException(String.format("Angajatul cu id-ul: %s nu există!", employeeRequest.getId())));
        employeeToUpdate.setFirstName(employeeRequest.getFirstName());
        employeeToUpdate.setLastName(employeeRequest.getLastName());
        employeeToUpdate.setPosition(employeeRequest.getPosition());
        employeeToUpdate.setBranch(employeeRequest.getBranch());
    }

    public void deleteEmployee(Integer id) {
        Employee employeeToDelete = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Angajatul cu id-ul: %s nu există", id)));
        employeeRepository.delete(employeeToDelete);
    }

    public void checkDuplicate(EmployeeRequest employeeRequest) {
        for (Employee employee : employeeRepository.findAll()) {
            if (employee.getFirstName().equals(employeeRequest.getFirstName())
                    && employee.getLastName().equals(employeeRequest.getLastName())) {
                throw new RuntimeException("Acest angajat există deja!");
            }
        }
    }
}