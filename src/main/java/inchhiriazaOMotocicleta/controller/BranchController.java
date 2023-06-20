package inchhiriazaOMotocicleta.controller;

import inchhiriazaOMotocicleta.entity.Branch;
import inchhiriazaOMotocicleta.model.branch.BranchDetails;
import inchhiriazaOMotocicleta.model.branch.BranchRequest;
import inchhiriazaOMotocicleta.model.branch.BranchResponse;
import inchhiriazaOMotocicleta.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("branch")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Validated
public class BranchController {
    private final BranchService branchService;

    @GetMapping("/branchses")
    public String myMethod(Model model) {
        // Get your branches from database (or wherever they come from)
        List<BranchDetails> branches = branchService.getAllBranches();

        // Add branches to model
        model.addAttribute("branches", branches);

        // Return view
        return "branches";
    }

    @PostMapping("/create")
    public BranchResponse createBranch(@RequestBody @Valid BranchRequest branchRequest) {
        return branchService.createBranch(branchRequest);
    }

    @GetMapping("/list")
    public List<BranchDetails> showAllBranches() {
        return branchService.getAllBranches();
    }

    @GetMapping("/find/{id}")
    public BranchResponse findBranchById(@PathVariable Integer id) {
        return branchService.findBranchById(id);
    }

    @PatchMapping("/update")
    public void updateBranch(@RequestBody @Valid BranchRequest branchRequest) {
        branchService.updateBranch(branchRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBranch(@PathVariable Integer id) {
        branchService.deleteBranch(id);
    }


}
