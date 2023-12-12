package br.com.danilocarreiro.taskapp.http.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danilocarreiro.taskapp.business.domain.entities.Organization;
import br.com.danilocarreiro.taskapp.business.infra.services.OrganizationService;
import br.com.danilocarreiro.taskapp.http.request.organization.RequestBodyCreate;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService service;

    @PostMapping
    public ResponseEntity<Organization> create(@Valid @RequestBody RequestBodyCreate body) {
        var organization = this.service.create(body.convertToOrganization());

        return ResponseEntity.ok(organization);
    }
    
}
