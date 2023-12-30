package br.com.danilocarreiro.taskapp.business.infra.services;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.danilocarreiro.taskapp.domain.entities.Organization;
import br.com.danilocarreiro.taskapp.domain.repositories.OrganizationRepository;
import br.com.danilocarreiro.taskapp.infra.services.OrganizationService;

@SpringBootTest
public class OrganizationServiceTest {

    @Autowired
    private OrganizationService organizationService;

    @MockBean
    private OrganizationRepository organizationRepository;

    @Test
    public void testCreateOrganization() {
        Organization organization = new Organization();
        organization.setName("Organization Name");

        Organization created = this.organizationService.create(organization);

        verify(organizationRepository).save(organization);
    }
}