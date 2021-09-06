package security.repository;

import lombok.Getter;
import lombok.Setter;
import security.common.EncryptingAlgorithm;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private EncryptingAlgorithm algorithm;

    @OneToMany(mappedBy = "user")
    private List<Authority> authorities;
}
