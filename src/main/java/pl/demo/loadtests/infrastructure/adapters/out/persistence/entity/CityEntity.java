package pl.demo.loadtests.infrastructure.adapters.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "city")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityEntity implements Serializable {

    @Id
    @Column(name = "c_id")
    private Long cid;

    @Column(name = "c_other")
    private Long otherId;

    @Column(name = "c_status")
    private Integer status;

    @Column(name = "c_name")
    private String name;

}
