/*
* Nome: Mara Beatriz da Silva Leite
* Número: 8210403
* Turma: T3
*
* Nome: Sérgio Daniel Andrade Dias
* Número: 8200535
* Turma: T2
 */
package PP_GP30.project;

import com.estg.core.Client;
import com.estg.core.Destination;
import com.estg.core.Pathology;
import com.estg.core.Service;
import java.util.Objects;

/**
 * The ServiceImpl class implements the Service interface and represents a
 * service. It has four private fields: numberOfService, client, pathologies,
 * and destination.
 */
public class ServiceImpl implements Service {
    /**
     * The number of services.
     */
    private int numberOfService;
    /**
     * The client associated with the service.
     */
    private Client client;
    /**
     * An array of pathologies associated with the service.
     */
    private Pathology pathologies[];
    /**
     * The destination of the service.
     */
    private Destination destination;

    /**
     * Constructs a ServiceImpl object with the given number of services,
     * client, pathologies, and destination.
     *
     * @param numberOfService the number of services
     * @param client the client associated with the service
     * @param pathologies an array of pathologies associated with the service
     * @param destination the destination of the service
     */
    public ServiceImpl(int numberOfService, Client client, Pathology[] pathologies, Destination destination) {
        this.numberOfService = numberOfService;
        this.client = client;
        this.pathologies = pathologies;
        this.destination = destination;
    }

    /**
     * Returns the number of services.
     *
     * @return the number of services
     */
    @Override
    public int getNumberOfService() {
        return this.numberOfService;
    }

    /**
     * Returns the client associated with the service.
     *
     * @return the client associated with the service
     */
    @Override
    public Client getClient() {
        return this.client;
    }

    /**
     * Returns an array of pathologies associated with the service.
     *
     * @return an array of pathologies associated with the service
     */
    @Override
    public Pathology[] getPathologies() {
        return this.pathologies;
    }

    /**
     * Returns the destination of the service.
     *
     * @return the destination of the service
     */
    @Override
    public Destination getDestination() {
        return this.destination;
    }

    @Override
    public boolean equals(Object obj) {
        int count = 0;

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ServiceImpl other = (ServiceImpl) obj;

        if (!Objects.equals(this.client, other.client)) {
            return false;
        }

        for (int i = 0; i < this.pathologies.length; i++) {
            if (Objects.equals(this.pathologies[i], other.pathologies[i])) {
                count++;
            }
        }
        if (count != this.pathologies.length) {
            return false;
        }
        return true;

    }
}
