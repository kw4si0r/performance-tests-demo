package pl.demo.loadtests.infrastructure.adapters.out.persistence.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class UserId implements Serializable {
    @Column(name = "u_email")
    private String email;
}
