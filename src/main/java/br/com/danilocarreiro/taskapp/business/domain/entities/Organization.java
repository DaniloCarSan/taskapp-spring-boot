package br.com.danilocarreiro.taskapp.business.domain.entities;

import java.util.UUID;

import br.com.danilocarreiro.taskapp.business.domain.OVs.ActiveStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @Column(nullable = false)
    private ActiveStatus active;

    public Organization() {

    }

}
