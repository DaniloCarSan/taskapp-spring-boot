package br.com.danilocarreiro.taskapp.domain.OVs;

import java.util.HashMap;

public enum ActiveStatus {
    Y, N;

    public boolean isActive() {
        return this == Y;
    }

    public boolean isDeactive() {
        return this == N;
    }

    public String label() {
        return (new HashMap<ActiveStatus, String>() {
            {
                put(Y, "Active");
                put(N, "Deactive");
            }
        }).get(this);
    }
}
