package com.cvds.parcial.services;

import com.cvds.parcial.models.Agent;
import com.cvds.parcial.models.Product;

public class AgentLog extends Agent {
    @Override
    public void notifyAgent(Product product) {
        System.out.println("Producto " +product.getName() + " -> " + product.getStock() + " Unidades Disponibles");
    }
}
