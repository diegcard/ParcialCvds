package com.cvds.parcial.services;

import com.cvds.parcial.models.Agent;
import com.cvds.parcial.models.Product;

public class AgentDanger extends Agent {
    @Override
    public void notifyAgent(Product product) {
        System.out.println("ALERTA!!! El stock del Prodcto: " + product.getName() + " es muy bajo, solo quedan " + product.getStock() + " unidades");
    }
}
