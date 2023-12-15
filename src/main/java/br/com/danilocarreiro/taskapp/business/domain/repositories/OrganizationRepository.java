package br.com.danilocarreiro.taskapp.business.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.danilocarreiro.taskapp.business.domain.entities.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, UUID> {
    public boolean existsByName(String name);

    public boolean existsByNameAndIdNot(String name, UUID id);
}
