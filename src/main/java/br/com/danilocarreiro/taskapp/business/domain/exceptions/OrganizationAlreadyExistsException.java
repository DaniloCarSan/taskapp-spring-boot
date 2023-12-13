package br.com.danilocarreiro.taskapp.business.domain.exceptions;

public class OrganizationAlreadyExistsException  extends RuntimeException {
    public OrganizationAlreadyExistsException(String message) {
        super(message);
    }
}
