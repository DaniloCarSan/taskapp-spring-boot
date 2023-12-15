package br.com.danilocarreiro.taskapp.business.infra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danilocarreiro.taskapp.business.domain.entities.Organization;
import br.com.danilocarreiro.taskapp.business.domain.exceptions.OrganizationAlreadyExistsException;
import br.com.danilocarreiro.taskapp.business.domain.exceptions.OrganizationNotFoundException;
import br.com.danilocarreiro.taskapp.business.domain.repositories.OrganizationRepository;

@Service
public class OrganizationService implements br.com.danilocarreiro.taskapp.business.domain.services.OrganizationService {

    @Autowired
    private OrganizationRepository repository;

    @Override
    public Organization create(Organization organization) {

        if (this.repository.existsByName(organization.getName())) {
            throw new OrganizationAlreadyExistsException(
                    String.format("Organization with name ( %s ) already exists", organization.getName()));
        }

        return repository.save(organization);
    }

    @Override
    public Organization update(Organization newOrganization) {

        if (this.repository.existsByNameAndIdNot(newOrganization.getName(), newOrganization.getId())) {
            throw new OrganizationAlreadyExistsException(
                    String.format("Organization with name ( %s ) already exists", newOrganization.getName()));
        }

        var organization = this.repository.findById(newOrganization.getId())
                .orElseThrow(() -> new OrganizationNotFoundException("Organization not found"));

        organization.update(newOrganization.getName(), newOrganization.getActive());

        return this.repository.save(organization);
    }

}
