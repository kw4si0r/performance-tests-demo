package pl.demo.loadtests.infrastructure.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.demo.loadtests.infrastructure.adapters.out.persistence.entity.id.UserId;

import java.io.Serializable;


@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity implements Serializable {

    @EmbeddedId
    private UserId id;

    @Column(name = "u_type")
    private Integer type;

    @OneToOne
    @JoinColumn(name = "u_email", referencedColumnName = "d_email", insertable = false, updatable = false)
    private UserDetailsEntity details;


}
