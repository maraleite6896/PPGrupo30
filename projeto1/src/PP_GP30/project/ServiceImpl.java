/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP_GP30.project;

import com.estg.core.Client;
import com.estg.core.Destination;
import com.estg.core.Pathology;
import com.estg.core.Service;

/**
 *
 * @author maraleite
 */
public class ServiceImpl implements Service {

    private int numberOfService;
    private Client client;
    private Pathology pathologies[];
    private Destination destination;

    public ServiceImpl(int numberOfService, Client client, Pathology[] pathologies, Destination destination) {
        this.numberOfService = numberOfService;
        this.client = client;
        this.pathologies = pathologies;
        this.destination = destination;
    }

    @Override
    public int getNumberOfService() {
        return numberOfService;
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public Pathology[] getPathologies() {
        return pathologies;
    }

    @Override
    public Destination getDestination() {
        return destination;
    }

}
