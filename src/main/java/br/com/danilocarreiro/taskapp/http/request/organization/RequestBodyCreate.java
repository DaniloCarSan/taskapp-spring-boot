package br.com.danilocarreiro.taskapp.http.request.organization;

import org.springframework.beans.BeanUtils;

import br.com.danilocarreiro.taskapp.business.domain.OVs.ActiveStatus;
import br.com.danilocarreiro.taskapp.business.domain.entities.Organization;
import jakarta.validation.constraints.NotBlank;

public record RequestBodyCreate(
   @NotBlank String name,
   ActiveStatus active
) {
    
    public Organization convertToOrganization() {
        Organization organization = new Organization();
        BeanUtils.copyProperties(this, organization);
        return organization;
    }

}
