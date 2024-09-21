package com.cvds.parcial.services;

import com.cvds.parcial.models.Agent;
import com.cvds.parcial.models.Product;

/**
 * Este agente debe escribir en stdout cada vez que se modifica el stock de un producto.
 */
public class AgentLog extends Agent {
    /**
     * Tofificate the agent message
     * @param product to notifycate
     */
    @Override
    public void notifyAgent(Product product) {
        System.out.println("Producto " +product.getName() + " -> " + product.getStock() + " Unidades Disponibles");
    }
}
