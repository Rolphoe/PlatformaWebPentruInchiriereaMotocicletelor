package inchhiriazaOMotocicleta.service;

import inchhiriazaOMotocicleta.entity.*;
import inchhiriazaOMotocicleta.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import inchhiriazaOMotocicleta.mapper.RentMapper;
import inchhiriazaOMotocicleta.model.rent.RentRequest;
import inchhiriazaOMotocicleta.model.rent.RentResponse;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RentService {
    private final RentRepository rentRepository;
    private final RentMapper rentMapper;
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;
    private final BranchRepository branchRepository;

    public RentResponse createRent(RentRequest rentRequest) {

        System.out.println("Vehicle ID: " + rentRequest.getVehicleId());
        Vehicle vehicle = vehicleRepository.findById(rentRequest.getVehicleId()).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        if (vehicle.getStatus().equals("Inchiriat")) {
            throw new RuntimeException("Această motocicletă este închiriată deja!");
        } else {
            for (Rent rent : rentRepository.findAll()) {
                if (rent.getRentStartDateTime().equals(rentRequest.getRentStartDateTime())) {
                    throw new RuntimeException("Această motocicletă este închiriată deja în această perioadă!");
                }
                if (rent.getRentEndDateTime().equals(rentRequest.getRentEndDateTime())) {
                    throw new RuntimeException("Această motocicletă este închiriată deja în această perioadă!");
                }
            }

            Rent rentToSave = rentMapper.map(rentRequest);

            System.out.println("User ID: " + rentRequest.getUserId());
            User user = userRepository.findById(rentRequest.getUserId()).orElseThrow(() -> new RuntimeException("Utilizatorul nu a putut fi găsit"));
            rentToSave.setUser(user);

            rentToSave.setVehicle(vehicle);
            vehicle.setStatus("Inchiriat");

            System.out.println("Branch Take ID: " + rentRequest.getBranchTakeId());
            Branch branchTake = branchRepository.findById(rentRequest.getBranchTakeId()).orElseThrow(() -> new RuntimeException("Magazinul nu a putut fi găsit"));
            if(branchTake != null) {
                rentToSave.setBranchTake(branchTake);
            }

            System.out.println("Branch Leave ID: " + rentRequest.getBranchLeaveId());
            Branch branchLeave = branchRepository.findById(rentRequest.getBranchLeaveId()).orElseThrow(() -> new RuntimeException("Magazinul nu a putut fi găsit"));
            if(branchLeave != null) {
                rentToSave.setBranchLeave(branchLeave);
            }

            return rentMapper.map(rentRepository.save(rentToSave));
        }

    }

    public RentResponse findById(Integer id) {
        return rentMapper.map(rentRepository.findById(id).orElseThrow(() -> new RuntimeException("Închirierea nu a putut fi găsită!")));
    }

    public List<RentResponse> findAll() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userRepository.findByUsername(username);

        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return rentMapper.map(rentRepository.findAllByOrderByRentStartDateTimeDesc());
        } else {
            return rentMapper.map(rentRepository.findByUserId(user.getId()));
        }
    }


    public void delete(Integer id) {
        Rent rentToDelete = rentRepository.findById(id).orElseThrow(() -> new RuntimeException("Închirierea nu a putut fi găsită!"));
        Vehicle vehicle = rentToDelete.getVehicle();
        vehicle.setStatus("Valabil");
        vehicleRepository.save(vehicle);
        rentRepository.delete(rentToDelete);
    }


}
