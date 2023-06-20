package inchhiriazaOMotocicleta.mapper;

import inchhiriazaOMotocicleta.entity.Branch;
import inchhiriazaOMotocicleta.entity.Vehicle;
import inchhiriazaOMotocicleta.model.branch.BranchDetails;
import inchhiriazaOMotocicleta.model.branch.BranchRequest;
import inchhiriazaOMotocicleta.model.branch.BranchResponse;
import inchhiriazaOMotocicleta.model.vehicle.VehicleDetails;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@Mapper(componentModel = "spring")
public interface BranchMapper {

    Branch map(BranchRequest branchRequest);

    BranchResponse map(Branch branch);

    List<BranchDetails> map(List<Branch> allBranches);
}
