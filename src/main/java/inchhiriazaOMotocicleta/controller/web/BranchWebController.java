package inchhiriazaOMotocicleta.controller.web;

import inchhiriazaOMotocicleta.model.IdRequest;
import inchhiriazaOMotocicleta.model.branch.BranchRequest;
import inchhiriazaOMotocicleta.model.branch.CreateBranchRequest;
import inchhiriazaOMotocicleta.model.branch.UpdateBranchRequest;
import inchhiriazaOMotocicleta.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class BranchWebController {
    private final BranchService branchService;

    @GetMapping("/branch")
    public String goToBranchPage() {
        return "branchPage";
    }

    @GetMapping("branch/allBranches")
    public String goToAllBranchesList(Model model) {
        model.addAttribute("branches", branchService.getAllBranches());
        return "allBranchesPage";
    }

    @PostMapping("branch/delete")
    public String deleteBranch(@ModelAttribute(value = "deleteRequest") IdRequest request, Model model) {
        branchService.deleteBranch(request.getId());
        model.addAttribute("branches", branchService.getAllBranches());
        return "allBranchesPage";
    }

    @GetMapping("branch/goToUpdateBranchPage")
    public String goToUpdateBranchPage(@ModelAttribute(value = "deleteRequest") IdRequest request, Model model){
        model.addAttribute("branchId", request.getId());
        return "updateBranchesPage";
    }

    @PostMapping("branch/update-branch")
    public String updateBranch(@ModelAttribute(value = "updateBranchRequest") UpdateBranchRequest request,
                                 Model model) {
        BranchRequest branchRequest = BranchRequest.builder()
                .id(request.getId())
                .name(request.getName())
                .address(request.getAddress())
                .build();
        branchService.updateBranch(branchRequest);

        model.addAttribute("branches", branchService.getAllBranches());
        return "allBranchesPage";
    }

    @GetMapping("branch/goToCreateBranchPage")
    public String goToCreateBranchPage() {
        return "branchCreatePage";
    }



    @PostMapping("/branch/createNewBranch")
    public String createBranch(@ModelAttribute(value = "createBranchRequest")
                                   CreateBranchRequest request,
                                 Model model) {
        BranchRequest branchRequest = BranchRequest.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
        branchService.createBranch(branchRequest);

        model.addAttribute("branches", branchService.getAllBranches());
        return "allBranchesPage";
    }


}
