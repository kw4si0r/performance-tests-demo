package pl.demo.loadtests.infrastructure.adapters.out.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.demo.loadtests.infrastructure.adapters.out.persistence.entity.id.UserDetailsId;


@Entity
@Table(name = "user_details")
@Getter
@Setter
public class UserDetailsEntity {

    @EmbeddedId
    private UserDetailsId id;

    @Column(name = "d_name")
    private String name;

    @Column(name = "d_surname")
    private String surname;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "d_email", referencedColumnName = "u_email", insertable = false, updatable = false)
    })
    private UserEntity user;

}
