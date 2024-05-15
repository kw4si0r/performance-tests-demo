package pl.demo.loadtests.infrastructure.adapters.out.persistence.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class UserDetailsId {

    @Column(name = "d_email")
    private String email;
}
