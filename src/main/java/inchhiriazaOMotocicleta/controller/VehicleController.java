package inchhiriazaOMotocicleta.controller;

import inchhiriazaOMotocicleta.model.vehicle.VehicleDetailResponse;
import inchhiriazaOMotocicleta.model.vehicle.VehicleDetails;
import inchhiriazaOMotocicleta.model.vehicle.VehicleRequest;
import inchhiriazaOMotocicleta.service.StorageService;
import inchhiriazaOMotocicleta.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("vehicle")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@Validated
public class VehicleController {
    private final VehicleService vehicleService;
    private final StorageService storageService;

    @PostMapping("/create")
    public VehicleDetails createVehicle(@RequestPart("vehicle") @Valid VehicleRequest vehicleRequest,
                                        @RequestPart("image") MultipartFile imageFile) throws IOException {
        String imagePath = storageService.storeFile(imageFile);
        vehicleRequest.setImagePath(imagePath);
        return vehicleService.createVehicle(vehicleRequest, imageFile);
    }

    @GetMapping("list")
    public List<VehicleDetails> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("find/{id}")
    public VehicleDetails findVehicleById(@PathVariable Integer id) {
        return vehicleService.findVehicleById(id);
    }

    @GetMapping("find/model/{model}")
    public List<VehicleDetailResponse> findByName(@PathVariable String vehicleModel) {
        return vehicleService.findByVehicleModel(vehicleModel);
    }

    @DeleteMapping("{id}")
    public void deleteVehicleById(@PathVariable Integer id){
        vehicleService.deleteById(id);
    }
}