package inchhiriazaOMotocicleta.service;

import inchhiriazaOMotocicleta.entity.Customer;
import inchhiriazaOMotocicleta.mapper.CustomerMapper;
import inchhiriazaOMotocicleta.model.customer.*;
import inchhiriazaOMotocicleta.repository.CustomerRepository;
import inchhiriazaOMotocicleta.repository.MyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    private final MyRepository myRepository;

    public CustomerDetails createCustomer(CustomerRequest customerRequest){
        checkDuplicate(customerRequest);
        Customer customer = customerMapper.map(customerRequest);
        return customerMapper.map(customerRepository.save(customer));
    }

    public List<CustomerDetails> getAllCustomers() {
        return customerMapper.map(customerRepository.findAll());
    }

    public CustomerDetails findCustomerById(Integer id)  {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Clientul cu id-ul: %s nu a fost găsit!", id)));
        return customerMapper.map(customer);
    }

    public List<CustomerDetailResponse> findByFirstName(String firstName){
        if(firstName.isBlank()) {
            throw new IllegalArgumentException("Nume invalid");
        }
        List<Customer> customerListFromDB = customerRepository.findByFirstName(firstName);
        List<CustomerDetailResponse> customerDetailResponseList = new ArrayList<>();
        for(Customer customer : customerListFromDB){
            CustomerDetailResponse customerDetailResponse = createCustomerDetailsResponse(customer);
            customerDetailResponseList.add(customerDetailResponse);
        }
        if(customerDetailResponseList.isEmpty()) {
            throw new RuntimeException("Clientul nu a fost găsit");
        }
        return customerDetailResponseList;
    }

    private CustomerDetailResponse createCustomerDetailsResponse(Customer customer) {
        CustomerDetailResponse customerDetailResponse = new CustomerDetailResponse();
        customerDetailResponse.setFirstName(customer.getFirstName());
        customerDetailResponse.setLastName(customer.getLastName());
        customerDetailResponse.setRents(new ArrayList<>());
        return customerDetailResponse;
    }

    public void updateCustomer(CustomerRequest customerRequest) {
        Customer customerToUpdate = customerRepository.findById(customerRequest.getId()).orElseThrow(() -> new RuntimeException(String.format("Clientul cu id-ul: %s nu există!", customerRequest.getId())));
        customerToUpdate.setFirstName(customerRequest.getFirstName());
        customerToUpdate.setLastName(customerRequest.getLastName());
        customerToUpdate.setEmail(customerRequest.getEmail());
        customerToUpdate.setAddress(customerRequest.getAddress());
    }

    public void updateFirstName(Integer id, RequestUpdateFirstNameCustomer request) {
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Clientul cu id-ul: %s nu a fost găsit", id)));
        customerToUpdate.setFirstName(request.getFirstName());
    }


    public void updateLastName(Integer id, RequestUpdateLastNameCustomer request) {
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Clientul cu id-ul: %s nu a fost găsit", id)));
        customerToUpdate.setLastName(request.getLastName());
    }

    public void updateAddress(Integer id, RequestUpdateAddressCustomer request) {
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Clientul cu id-ul: %s nu a fost găsit", id)));
        customerToUpdate.setAddress(request.getAddress());
    }

    public void updateEmail(Integer id, RequestUpdateEmailCustomer request) {
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Clientul cu id-ul: %s nu a fost găsit", id)));
        customerToUpdate.setEmail(request.getEmail());
    }


    public void deleteById(Integer id) {
        Customer customerToDelete = customerRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Clientul cu id-ul: %s nu a fost găsit", id)));
        customerRepository.deleteById(customerToDelete.getId());
    }

    public void checkDuplicate(CustomerRequest customerRequest) {
        for (Customer customer : customerRepository.findAll()) {
            if (customer.getFirstName().equals(customerRequest.getFirstName()) &&
                    customer.getLastName().equals(customerRequest.getLastName())) {
                throw new RuntimeException("Acest client există deja!");
            }
        }
    }

}
