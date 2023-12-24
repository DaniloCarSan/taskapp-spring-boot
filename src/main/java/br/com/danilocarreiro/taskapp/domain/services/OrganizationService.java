package br.com.danilocarreiro.taskapp.domain.services;

import java.util.UUID;

import br.com.danilocarreiro.taskapp.domain.entities.Organization;

public interface OrganizationService {
    public Organization create(Organization organization);

    public Organization getById(UUID id);

    public Organization update(Organization organization);
}
