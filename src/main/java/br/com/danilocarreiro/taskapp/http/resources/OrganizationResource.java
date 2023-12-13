package br.com.danilocarreiro.taskapp.http.resources;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import br.com.danilocarreiro.taskapp.business.domain.OVs.ActiveStatus;
import br.com.danilocarreiro.taskapp.business.domain.entities.Organization;
import br.com.danilocarreiro.taskapp.http.controllers.OrganizationController;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationResource extends RepresentationModel<OrganizationResource> {

    private UUID id;
    private String name;
    private ActiveStatus active;
    private HashMap<String, Object> meta = new HashMap<String, Object>();

    public static OrganizationResource from(Organization organization) {
        var resource = new OrganizationResource();
        resource.setId(organization.getId());
        resource.setName(organization.getName());
        resource.setActive(organization.getActive());
        resource.setLinks();
        return resource;
    }

    private void setLinks() {
        this.add(Link.of(OrganizationController.PATH + this.id).withSelfRel());
        this.add(Link.of(OrganizationController.PATH + this.id + "/activate").withRel("activate"));
        this.add(Link.of(OrganizationController.PATH + this.id + "/deactivate").withRel("deactivate"));
    }

    public void addMeta(String key, Object value) {
        this.meta.put(key, value);
    }

    public void setActive(ActiveStatus active) {
        this.active = active;
        this.addMeta("active", new HashMap<>() {
            private static final long serialVersionUID = 1L;
            {
                put("value", active);
                put("label", active.getLabel());
            }
        });
    }

}
