package inchhiriazaOMotocicleta.service;

import inchhiriazaOMotocicleta.entity.Vehicle;
import inchhiriazaOMotocicleta.mapper.VehicleMapper;
import inchhiriazaOMotocicleta.model.vehicle.*;
import inchhiriazaOMotocicleta.repository.MyRepository;
import inchhiriazaOMotocicleta.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    private final VehicleMapper vehicleMapper;

    private final StorageService storageService;

    public VehicleDetails createVehicle(VehicleRequest vehicleRequest, MultipartFile file) {
        checkDuplicate(vehicleRequest);
        Vehicle vehicle = vehicleMapper.map(vehicleRequest);

        String imagePath = storageService.storeFile(file);
        vehicle.setImagePath(imagePath);

        return vehicleMapper.map(vehicleRepository.save(vehicle));
    }

    public List<VehicleDetails> getAllVehicles() {
        return vehicleMapper.map(vehicleRepository.findAll());
    }

    public VehicleDetails findVehicleById(Integer id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Motocicleta cu id-ul: %s nu a fost gasită!", id)));
        return vehicleMapper.map(vehicle);
    }

    public List<VehicleDetailResponse> findByVehicleModel(String vehicleModel) {
        if (vehicleModel.isBlank()) {
            throw new IllegalArgumentException("Nume invalid");
        }
        List<Vehicle> vehicleListFromDB = vehicleRepository.findByVehicleModel(vehicleModel);
        List<VehicleDetailResponse> vehicleDetailResponseList = new ArrayList<>();
        for (Vehicle vehicle : vehicleListFromDB) {
            VehicleDetailResponse vehicleDetailResponse = createVehicleDetailsResponse(vehicle);
            vehicleDetailResponseList.add(vehicleDetailResponse);
        }
        if (vehicleDetailResponseList.isEmpty()) {
            throw new RuntimeException("Motocicleta nu a putut fi găsită");
        }
        return vehicleDetailResponseList;
    }

    private VehicleDetailResponse createVehicleDetailsResponse(Vehicle vehicle) {
        VehicleDetailResponse vehicleDetailResponse = new VehicleDetailResponse();
        vehicleDetailResponse.setVehicleModel(vehicle.getVehicleModel());
        vehicleDetailResponse.setYear(vehicle.getYear());
        vehicleDetailResponse.setColour(vehicle.getColour());
        vehicleDetailResponse.setMileage(vehicle.getMileage());
        vehicleDetailResponse.setStatus(vehicle.getStatus());
        vehicleDetailResponse.setPrice(vehicle.getPrice());
        return vehicleDetailResponse;
    }

    public void updateColour(Integer id, RequestUpdateColorVehicle request) {
        Vehicle vehicleToUpdate = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Motocicleta cu id-ul: %s nu a fost gasită!", id)));
        vehicleToUpdate.setColour(request.getColour());
    }


    public void updateMileage(Integer id, RequestUpdateMileageVehicle request) {
        Vehicle vehicleToUpdate = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Motocicleta cu id-ul: %s nu a fost gasită!", id)));
        vehicleToUpdate.setMileage(request.getMileage());
    }

    public void updatePrice(Integer id, RequestUpdatePriceVehicle request) {
        Vehicle vehicleToUpdate = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Motocicleta cu id-ul: %s nu a fost gasită!", id)));
        vehicleToUpdate.setPrice(request.getPrice());
    }

    public void deleteById(Integer id) {
        Vehicle vehicleToDelete = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Motocicleta cu id-ul: %s nu a fost gasită!", id)));
        vehicleRepository.deleteById(vehicleToDelete.getId());
    }

    public Vehicle getById(int id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Motocicleta cu id-ul: %s nu a fost gasită!", id)));
    }

    public void checkDuplicate(VehicleRequest vehicleRequest) {
        for (Vehicle vehicle : vehicleRepository.findAll()) {
            if (vehicle.getVehicleModel().equals(vehicleRequest.getVehicleModel()) &&
                    vehicle.getYear() == vehicleRequest.getYear()) {
                throw new RuntimeException("Această motocicletă există deja!");
            }
        }
    }

}
