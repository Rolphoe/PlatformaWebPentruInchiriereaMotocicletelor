package inchhiriazaOMotocicleta.service;

import inchhiriazaOMotocicleta.entity.Branch;
import inchhiriazaOMotocicleta.mapper.BranchMapper;
import inchhiriazaOMotocicleta.model.branch.BranchDetails;
import inchhiriazaOMotocicleta.model.branch.BranchRequest;
import inchhiriazaOMotocicleta.model.branch.BranchResponse;
import inchhiriazaOMotocicleta.model.vehicle.VehicleDetails;
import inchhiriazaOMotocicleta.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BranchService {
    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;

    public BranchResponse createBranch(BranchRequest branchRequest) {
        checkDuplicate(branchRequest);
        Branch branch = branchMapper.map(branchRequest);
        return branchMapper.map(branchRepository.save(branch));
    }

    public List<BranchDetails> getAllBranches() {
        return branchMapper.map(branchRepository.findAll());
    }

    public BranchResponse findBranchById(Integer id) {
        Branch branch = branchRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Magazinul cu id-ul: %s nu există!", id)));
        return branchMapper.map(branch);
    }

    public void updateBranch(BranchRequest branchRequest) {
        checkDuplicate(branchRequest);
        Branch branchToUpdate = branchRepository.findById(branchRequest.getId()).orElseThrow(() -> new RuntimeException(String.format("Magazinul cu id-ul: %s nu există!", branchRequest.getId())));
        branchToUpdate.setName(branchRequest.getName());
        branchToUpdate.setAddress(branchRequest.getAddress());
    }

    public void deleteBranch(Integer id) {
        Branch branchToDelete = branchRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Magazinul cu id-ul: %s nu există", id)));
        branchRepository.delete(branchToDelete);
    }

    public void checkDuplicate(BranchRequest branchRequest) {
        for (Branch branch : branchRepository.findAll()) {
            if (branch.getAddress().equals(branchRequest.getAddress())) {
                throw new RuntimeException("Magazinul exista deja!");
            }
        }
    }
}
