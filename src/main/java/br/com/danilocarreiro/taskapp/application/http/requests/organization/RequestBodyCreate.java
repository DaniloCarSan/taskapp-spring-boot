package br.com.danilocarreiro.taskapp.application.http.requests.organization;

import org.springframework.beans.BeanUtils;

import br.com.danilocarreiro.taskapp.domain.entities.Organization;
import jakarta.validation.constraints.NotBlank;

public record RequestBodyCreate(@NotBlank String name) {

    public Organization convertToOrganization() {
        Organization organization = new Organization();
        BeanUtils.copyProperties(this, organization);

        return organization;
    }

}
