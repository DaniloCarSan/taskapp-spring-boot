package br.com.danilocarreiro.taskapp.domain.OVs;

import java.util.HashMap;

import lombok.Getter;

@Getter
public enum ActiveStatus {
    Y,
    N;

    public static final HashMap<ActiveStatus, String> labels = new HashMap<ActiveStatus, String>() {
        private static final long serialVersionUID = 1L;
        {
            put(ActiveStatus.Y, "Ativado");
            put(ActiveStatus.N, "Desativado");
        }
    };

    public String getLabel() {
        return labels.get(this);
    }
}
