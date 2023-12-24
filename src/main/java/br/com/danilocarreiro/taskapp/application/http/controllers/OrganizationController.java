package br.com.danilocarreiro.taskapp.application.http.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danilocarreiro.taskapp.application.http.requests.organization.RequestBodyCreate;
import br.com.danilocarreiro.taskapp.application.http.requests.organization.RequestBodyUpdate;
import br.com.danilocarreiro.taskapp.application.http.resources.OrganizationResource;
import br.com.danilocarreiro.taskapp.domain.services.OrganizationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(OrganizationController.PATH)
public class OrganizationController {

    public static final String PATH = "/organization";

    @Autowired
    private OrganizationService service;

    @PostMapping
    public ResponseEntity<OrganizationResource> create(@Valid @RequestBody RequestBodyCreate body) {
        var organization = this.service.create(body.convertToOrganization());

        return ResponseEntity.ok(OrganizationResource.from(organization));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationResource> getMethodName(@PathVariable UUID id) {
        var organization = this.service.getById(id);

        return ResponseEntity.ok(OrganizationResource.from(organization));
    }

    @PutMapping
    public ResponseEntity<OrganizationResource> update(@Valid @RequestBody RequestBodyUpdate body) {
        var organization = this.service.update(body.convertToOrganization());

        return ResponseEntity.ok(OrganizationResource.from(organization));
    }

}
