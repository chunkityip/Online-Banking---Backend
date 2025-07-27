package online_banking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true)
    @NotEmpty
    public String accountNumber;

    public String accountType = "Savings";

    private String branch;

    private String state;

    /**
     * Chase California: 322271627
     * Chase New York: 021000021
     * Chase Texas: 111000614
     *
     * So Routing numbers are based on STATE
     */
    private String routingNumber;

    private BigDecimal balance = BigDecimal.ZERO;

    private String accountStatus = "ACTIVE";

    private String pin;

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id")
    public User user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Token> tokens = new ArrayList<>();
}
