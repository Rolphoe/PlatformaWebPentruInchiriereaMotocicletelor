package inchhiriazaOMotocicleta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import inchhiriazaOMotocicleta.model.rent.RentRequest;
import inchhiriazaOMotocicleta.model.rent.RentResponse;
import inchhiriazaOMotocicleta.service.RentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("rent")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Validated
public class RentController {

    private final RentService rentService;

    @PostMapping("create")
    public RentResponse createRent(@RequestBody @Valid RentRequest rentRequest) {
        return rentService.createRent(rentRequest);
    }

    @GetMapping("find/{id}")
    public RentResponse findById(@PathVariable Integer id) {
        return rentService.findById(id);
    }

    @GetMapping("/list")
    public List<RentResponse> findAll() {
        return rentService.findAll();
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        rentService.delete(id);
    }

}
