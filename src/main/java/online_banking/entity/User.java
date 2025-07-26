package online_banking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;

    @NotEmpty
    public String firstName;

    public String middleName;

    @NotEmpty
    public String lastName;

    @Email
    @Column(unique = true)
    @NotEmpty
    public String email;

    @Column(unique = true)
    @NotEmpty
    public String phoneNumber;

    @Column(unique = true)
    @NotEmpty
    public String address;

    // Establishing a one-to-one relationship with the account
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;
}
