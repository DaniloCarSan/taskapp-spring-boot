package br.com.danilocarreiro.taskapp.http.requests.organization;

import java.util.UUID;

import org.springframework.beans.BeanUtils;

import br.com.danilocarreiro.taskapp.business.domain.OVs.ActiveStatus;
import br.com.danilocarreiro.taskapp.business.domain.entities.Organization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestBodyUpdate(@NotNull UUID id, @NotBlank String name, ActiveStatus active) {

    public Organization convertToOrganization() {
        Organization organization = new Organization();
        BeanUtils.copyProperties(this, organization);
        return organization;
    }

}
