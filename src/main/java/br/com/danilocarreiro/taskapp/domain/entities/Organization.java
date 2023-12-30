package br.com.danilocarreiro.taskapp.domain.entities;

import java.util.UUID;

import br.com.danilocarreiro.taskapp.domain.OVs.ActiveStatus;
import br.com.danilocarreiro.taskapp.domain.exceptions.OrganizationException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 1, name = "active")
    @Enumerated(EnumType.STRING)
    private ActiveStatus activeStatus;

    public Organization() {

    }

    public void update(String name) {
        this.setName(name);
    }

    public ActiveStatus getActiveStatus() {
        return this.activeStatus;
    }

    public void active() {

        if (this.activeStatus != null) {
            if (this.activeStatus.isActive()) {
                throw new OrganizationException("Organization already active");
            }
        }

        this.setActiveStatus(ActiveStatus.Y);
    }

    public void deactive() {

        if (this.activeStatus != null) {
            if (this.activeStatus.isDeactive()) {
                throw new OrganizationException("Organization already deactive");
            }
        }

        this.setActiveStatus(ActiveStatus.N);
    }

}
