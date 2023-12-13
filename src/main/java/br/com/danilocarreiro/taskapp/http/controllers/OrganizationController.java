package br.com.danilocarreiro.taskapp.http.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danilocarreiro.taskapp.business.domain.services.OrganizationService;
import br.com.danilocarreiro.taskapp.http.requests.organization.RequestBodyCreate;
import br.com.danilocarreiro.taskapp.http.resources.OrganizationResource;
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

}
