package inchhiriazaOMotocicleta.entity;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Audited
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imagePath;

    @NotBlank
    private String vehicleModel;

    @NotBlank
    private String colour;

    @NotNull
    private int year;

    @NotNull
    private int mileage;

    @NotBlank
    private String status;

    @NotNull
    private int price;

}