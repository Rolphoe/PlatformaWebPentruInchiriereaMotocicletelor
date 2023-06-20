package inchhiriazaOMotocicleta.controller.web;

import inchhiriazaOMotocicleta.entity.Vehicle;
import inchhiriazaOMotocicleta.model.IdRequest;
import inchhiriazaOMotocicleta.model.vehicle.*;
import inchhiriazaOMotocicleta.service.StorageService;
import inchhiriazaOMotocicleta.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
@Controller
@RequestMapping("vehicle")
public class VehicleWebController {

    private final VehicleService vehicleService;

    private final StorageService storageService;

    @GetMapping("vehicle")
    public String goToVehiclePage(){
        return "vehiclePage";
    }

    @GetMapping("allVehicles")
    public String goToAllVehicles(Model model){
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "allVehiclesPage";
    }

    @GetMapping("/admin/details")
    public String viewDetails(@ModelAttribute(value = "id") IdRequest request, Model model) {
        VehicleDetails vehicleResponse = vehicleService.findVehicleById(request.getId());
        model.addAttribute("vehicle", vehicleResponse);
        return "vehicleDetailsPage";
    }

    @GetMapping("/admin/goToCreateVehiclePage")
    public String goToCreateVehiclePage() {
        return "vehicleCreatePage";
    }

    @PostMapping("/create-new-vehicle")
    public String createVehicle(@ModelAttribute(value = "createVehicleRequest") CreateVehicleRequest request,
                                @RequestPart("image") MultipartFile imageFile,
                                Model modelo) throws IOException {
        String imagePath = storageService.storeFile(imageFile);
        VehicleRequest vehicleRequest = VehicleRequest.builder()
                .vehicleModel(request.getVehicleModel())
                .year(request.getYear())
                .colour(request.getColour())
                .mileage(request.getMileage())
                .status(request.getStatus())
                .imagePath(imagePath)
                .price(request.getPrice())
                .build();
        vehicleService.createVehicle(vehicleRequest, imageFile);
        modelo.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "allVehiclesPage";
    }


    @PostMapping("/admin/updateColour/{id}")
    public String updateColour(@ModelAttribute(value = "updateColour") RequestUpdateColorVehicle request,
                               Model model) {
        vehicleService.updateColour(request.getId(), request);
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "allVehiclesPage";
    }

    @PostMapping("/admin/update-mileage/{id}")
    public String updateMileage(@ModelAttribute(value = "updateMileage") RequestUpdateMileageVehicle request,
                                Model model) {
        vehicleService.updateMileage(request.getId(), request);
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "allVehiclesPage";
    }

    @PostMapping("/admin/update-price/{id}")
    public String updatePrice(@ModelAttribute(value = "updatePrice") RequestUpdatePriceVehicle request,
                               Model model) {
        vehicleService.updatePrice(request.getId(), request);
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "allVehiclesPage";
    }

    @PostMapping("/deleteById")
    public String deleteById(@ModelAttribute(value = "deleteRequest") IdRequest request, Model model) {
        Vehicle vehicle = vehicleService.getById(request.getId());
        String imagePath = vehicle.getImagePath();
        File imageFile = new File(imagePath);
        if(imageFile.exists() && !imageFile.isDirectory()) {
            imageFile.delete();
        }
        vehicleService.deleteById(request.getId());
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "allVehiclesPage";
    }

}
