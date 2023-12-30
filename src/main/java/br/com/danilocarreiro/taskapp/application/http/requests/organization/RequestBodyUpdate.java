package br.com.danilocarreiro.taskapp.application.http.requests.organization;

import java.util.UUID;

import org.springframework.beans.BeanUtils;

import br.com.danilocarreiro.taskapp.domain.entities.Organization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestBodyUpdate(@NotNull UUID id, @NotBlank String name) {

    public Organization convertToOrganization() {
        Organization organization = new Organization();
        BeanUtils.copyProperties(this, organization);
        return organization;
    }

}
