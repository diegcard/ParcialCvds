package com.cvds.parcial.models;

/**
 * This class represent a observer of a agent
 */
public abstract class Agent {
    /**
     * This method notify a agnet disponible
     * @param product to notifycate
     */
    public abstract void notifyAgent(Product product);
}
