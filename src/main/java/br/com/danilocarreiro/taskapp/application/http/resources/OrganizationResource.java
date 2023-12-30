package br.com.danilocarreiro.taskapp.application.http.resources;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import br.com.danilocarreiro.taskapp.application.http.controllers.OrganizationController;
import br.com.danilocarreiro.taskapp.domain.entities.Organization;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationResource extends RepresentationModel<OrganizationResource> {

    private UUID id;
    private String name;

    private HashMap<String, Object> meta = new HashMap<String, Object>();

    public static OrganizationResource from(Organization organization) {
        var resource = new OrganizationResource();
        resource.setId(organization.getId());
        resource.setName(organization.getName());
        resource.setLinks();
        return resource;
    }

    private void setLinks() {
        this.add(Link.of(OrganizationController.PATH + '/' + this.id).withSelfRel());
    }

    public void addMeta(String key, Object value) {
        this.meta.put(key, value);
    }

}
