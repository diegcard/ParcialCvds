package com.cvds.parcial.services;

import com.cvds.parcial.models.Agent;
import com.cvds.parcial.models.Product;

/**
 * Este agente debe escribir en stdout cada vez que el stock de un producto es menor a 5.
 */
public class AgentDanger extends Agent {
    /**
     * notify de message error
     * @param product to notifycate
     */
    @Override
    public void notifyAgent(Product product) {
        System.out.println("ALERTA!!! El stock del Prodcto: " + product.getName() + " es muy bajo, solo quedan " + product.getStock() + " unidades");
    }
}
