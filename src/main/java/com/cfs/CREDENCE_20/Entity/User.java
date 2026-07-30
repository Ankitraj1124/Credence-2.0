package com.cfs.CREDENCE_20.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, unique = true, nullable = false)
    private String uid; // internal unique identifier, generated at registration (no longer a Firebase UID)

    @Column(unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @Column(nullable = false)
    private String password; // BCrypt-hashed password, never returned in API responses

    private String fullName;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    //  One user can have many clinical reports
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("user")
    private List<Report> reports;

    //automatically saves the current timestamp when the data is inserted into the database for the first time.
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // ---------------------------------------------------------------------
    // Spring Security's UserDetails contract. Implementing it directly on
    // the entity lets @AuthenticationPrincipal User keep working exactly
    // as it did with the old Firebase filter - no controller changes needed.
    // ---------------------------------------------------------------------

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return email; // we authenticate with email, so "username" IS the email
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
