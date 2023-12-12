package br.com.danilocarreiro.taskapp.business.infra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danilocarreiro.taskapp.business.domain.entities.Organization;
import br.com.danilocarreiro.taskapp.business.domain.exceptions.OrganizationException;
import br.com.danilocarreiro.taskapp.business.domain.repositories.OrganizationRepository;

@Service
public class OrganizationService implements br.com.danilocarreiro.taskapp.business.domain.services.OrganizationService {

    @Autowired
    private OrganizationRepository repository;

    @Override
    public Organization create(Organization organization) {

        if(this.repository.existsByName(organization.getName())) {
            throw new OrganizationException("Organization already exists with this name");
        }
        
        return repository.save(organization);
    }
    
}
