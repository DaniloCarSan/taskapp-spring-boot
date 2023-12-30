package br.com.danilocarreiro.taskapp.infra.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danilocarreiro.taskapp.domain.entities.Organization;
import br.com.danilocarreiro.taskapp.domain.exceptions.OrganizationAlreadyExistsException;
import br.com.danilocarreiro.taskapp.domain.exceptions.OrganizationException;
import br.com.danilocarreiro.taskapp.domain.exceptions.OrganizationNotFoundException;
import br.com.danilocarreiro.taskapp.domain.repositories.OrganizationRepository;

@Service
public class OrganizationService implements br.com.danilocarreiro.taskapp.domain.services.OrganizationService {

    @Autowired
    private OrganizationRepository repository;

    @Override
    public Organization create(Organization organization) {

        if (this.repository.existsByName(organization.getName())) {
            throw new OrganizationAlreadyExistsException(
                    String.format("Organization with name ( %s ) already exists", organization.getName()));
        }

        organization.active();

        return repository.save(organization);
    }

    @Override
    public Organization getById(UUID id) {

        var organization = this.repository.findById(id)
                .orElseThrow(() -> new OrganizationNotFoundException("Organization not found"));

        return organization;
    }

    @Override
    public Organization update(Organization newOrganization) {

        if (this.repository.existsByNameAndIdNot(newOrganization.getName(), newOrganization.getId())) {
            throw new OrganizationAlreadyExistsException(
                    String.format("Organization with name ( %s ) already exists", newOrganization.getName()));
        }

        var organization = this.repository.findById(newOrganization.getId())
                .orElseThrow(() -> new OrganizationNotFoundException("Organization not found"));

        if (organization.getActiveStatus().isDeactive()) {
            throw new OrganizationException("Organization deactiveted");
        }

        organization.setName(newOrganization.getName());

        return this.repository.save(organization);
    }

}
