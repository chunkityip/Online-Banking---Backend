package online_banking.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.C;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "passwordresettoken")
@Data
@NoArgsConstructor
public class PasswordResetToken implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "passwordresettoken_sequence")
    @SequenceGenerator(name = "passwordresettoken_sequence", sequenceName = "passwordresettoken_sequence", allocationSize = 100)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime expiryDateTime;

    public PasswordResetToken(String token , User user, LocalDateTime expiryDateTime) {
        this.token = token;
        this.user = user;
        this.expiryDateTime = expiryDateTime;
    }

    public boolean isTokenValid() {
        return getExpiryDateTime().isAfter(LocalDateTime.now());
    }
}
