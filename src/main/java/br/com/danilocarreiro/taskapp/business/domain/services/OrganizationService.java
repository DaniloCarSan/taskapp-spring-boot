package br.com.danilocarreiro.taskapp.business.domain.services;

import br.com.danilocarreiro.taskapp.business.domain.entities.Organization;

public interface OrganizationService {
    public Organization create(Organization organization);

    public Organization update(Organization organization);
}
