package br.com.danilocarreiro.taskapp.domain.services;

import br.com.danilocarreiro.taskapp.domain.entities.Organization;

public interface OrganizationService {
    public Organization create(Organization organization);

    public Organization update(Organization organization);
}
