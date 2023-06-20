package inchhiriazaOMotocicleta.entity;

import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.time.LocalDateTime;

@Entity
@Audited
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Future
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime rentStartDateTime;
    @Future
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime rentEndDateTime;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private User user;
    @ManyToOne
    @JoinColumn(name="vehicle_id", nullable=false)
    private Vehicle vehicle;
    @ManyToOne(fetch = FetchType.EAGER)
    private Branch branchTake;
    @ManyToOne(fetch = FetchType.EAGER)
    private Branch branchLeave;
    private float amount;
}
