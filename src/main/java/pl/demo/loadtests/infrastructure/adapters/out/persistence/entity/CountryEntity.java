package pl.demo.loadtests.infrastructure.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "country")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryEntity implements Serializable {

    @Id
    @Column(name = "s_id")
    private Long id;

    @Id
    @Column(name = "s_status")
    private Integer status;

    @Id
    @Column(name = "s_created", nullable = false)
    private String creationDate; //outside id, even though it is in the PK (see ddl.sql)

    @Column(name = "s_name")
    private String name;

    /**
     * check join only on selected fields (not all from complex key)
     * <p>
     * warn: join descriptor from dependent entity
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_other", referencedColumnName = "s_id", insertable = false, updatable = false)
    @JoinColumn(name = "c_status", referencedColumnName = "s_status", insertable = false, updatable = false)
    private List<CityEntity> cities;
}
