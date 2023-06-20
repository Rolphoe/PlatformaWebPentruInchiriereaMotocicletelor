package inchhiriazaOMotocicleta.mapper;

import inchhiriazaOMotocicleta.entity.Employee;
import inchhiriazaOMotocicleta.model.employee.EmployeeRequest;
import inchhiriazaOMotocicleta.model.employee.EmployeeResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee map(EmployeeRequest employeeRequest);

    EmployeeResponse map(Employee employee);

    List<EmployeeResponse> map(List<Employee> all);
}
