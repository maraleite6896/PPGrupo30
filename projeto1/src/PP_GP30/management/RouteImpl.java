/*
* Nome: Mara Beatriz da Silva Leite
* Número: 8210403
* Turma: T3
*
* Nome: Sérgio Daniel Andrade Dias
* Número: 8200535
* Turma: T2
 */
package PP_GP30.management;

import com.estg.core.Ambulance;
import com.estg.core.Pathology;
import com.estg.core.Service;
import com.estg.dailyManagement.Route;
import com.estg.dailyManagement.exceptions.RouteException;
import java.time.LocalDateTime;

/**
 * The RouteImpl class implements the Route interface and represents a route for
 * an ambulance.
 */
public class RouteImpl implements Route {

    //The code of the route.
    private String code;

    //The ambulance assigned to the route.
    private Ambulance ambulance;

    //The start date and time of the route.
    private LocalDateTime startDate;

    //The end date and time of the route.
    private LocalDateTime endDate;

    //The services assigned to the route.
    private Service services[];

    //A flag indicating whether the route contains services.
    private boolean containsService;

    //The total duration of the route.
    private double totalDuration;

    private static int serviceCount = 0;

    /**
     * Constructs a RouteImpl object with the given code, ambulance, and start
     * date.
     *
     * @param code the code of the route
     * @param ambulance the ambulance assigned to the route
     * @param startDate the start date and time of the route
     */
    public RouteImpl(String code, Ambulance ambulance, LocalDateTime startDate) {
        this.code = code;
        this.ambulance = ambulance;
        this.startDate = startDate;
        this.services = new Service[0];
        this.containsService = false;
        this.totalDuration = 0;
    }

    /**
     * Returns the code of the route.
     *
     * @return the code of the route
     */
    @Override
    public String getCode() {
        return this.code;
    }

    /**
     * Returns the ambulance assigned to the route.
     *
     * @return the ambulance assigned to the route
     */
    @Override
    public Ambulance getAmbulance() {
        return this.ambulance;
    }

    /**
     * Returns the start date and time of the route.
     *
     * @return the start date and time of the route
     */
    @Override
    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    /**
     * Returns the end date and time of the route.
     *
     * @return the end date and time of the route
     */
    @Override
    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    /**
     * Returns the services assigned to the route.
     *
     * @return the services assigned to the route
     */
    @Override
    public Service[] getServices() {
        return this.services;
    }

    /**
     * Adds a service to the route.
     *
     * @param srvc the service to be added
     * @throws RouteException if the service is null, already exists in the
     * route, or is not compatible with the ambulance
     */
    @Override
    public void addService(Service srvc) throws RouteException {

        if (srvc == null) {
            throw new RouteException("O serviço é nulo.");
        }

        for (Service existingService : services) {
            if (existingService.equals(srvc)) {
                throw new RouteException("O serviço já está na rota.");
            }
        }

        if (!isServiceCompatible(srvc)) {
            throw new RouteException("O serviço não é compatível com a ambulância da rota.");
        }

        if (serviceCount == this.services.length) {
            increaseArraySizeByFive(this.services);

        } else {
            this.services[serviceCount] = srvc;
            serviceCount++;
        }

        containsService = true;
    }

    /**
     * Checks if a service is compatible with the ambulance.
     *
     * @param service the service to be checked
     * @return true if the service is compatible, false otherwise
     */
    private boolean isServiceCompatible(Service service) {

        Pathology[] patology = service.getPathologies();
        for (int i = 0; i < service.getPathologies().length; i++) {
            if (this.getAmbulance().getAmbulanceType() != patology[i].getEmergenceType()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a service exists in the route.
     *
     * @param srvc the service to be checked
     * @return true if the service exists, false otherwise
     */
    @Override
    public boolean containsService(Service srvc) {

        for (Service existingService : services) {
            if (existingService.equals(srvc)) {
                return true; // O serviço está na rota
            }
        }
        return false; // o serviço nao esta na rota
    }

    /**
     * Removes a service from the route.
     *
     * @param srvc the service to be removed
     * @return the removed service
     * @throws RouteException if the service is null or does not exist in the
     * route
     */
    @Override
    public Service removeService(Service srvc) throws RouteException {
        if (srvc == null) {
            throw new RouteException("O serviço é nulo.");
        }

        if (services == null || services.length == 0) {
            throw new RouteException("Não há serviços na rota.");
        }

        boolean found = false;
        int index = -1;
        for (int i = 0; i < services.length; i++) {
            if (services[i].equals(srvc)) {
                found = true;
                index = i;
                break;
            }
        }

        if (!found) {
            throw new RouteException("O serviço não está na rota.");
        }

        Service removedService = services[index];

        // Remover o serviço da lista de serviços da rota
        if (index == services.length) {
            this.services[index] = null;
        } else {
            for (int i = index; i < services.length - (index - 1); i++) {
                services[i] = services[i + 1];

            }
            this.services[services.length] = null;

        }
        serviceCount--;

        return removedService;
    }

    /**
     * Replaces a service in the route with a new one.
     *
     * @param oldService the service to be replaced
     * @param newService the new service
     * @throws RouteException if the services are null, the old service does not
     * exist, or the new service is not compatible with the ambulance
     */
    @Override
    public void replaceService(Service oldService, Service newService) throws RouteException {

        if (oldService == null || newService == null) {
            throw new RouteException("O serviço é nulo.");
        }

        boolean found = false;
        int index = -1;
        for (int i = 0; i < services.length; i++) {
            if (services[i].equals(oldService)) {
                found = true;
                index = i;
                break;
            }
        }

        if (!found) {
            throw new RouteException("O serviço antigo não está na rota.");
        }

        for (Service existingService : services) {
            if (existingService.equals(newService)) {
                throw new RouteException("O serviço novo já está na rota.");
            }
        }

        if (!isServiceCompatible(newService)) {
            throw new RouteException("O serviço novo não é compatível com a ambulância da rota.");
        }

        services[index] = newService;
    }

    /**
     * Inserts a new service after an existing service in the route.
     *
     * @param oldService the existing service
     * @param newService the new service
     * @throws RouteException if the services are null, the old service does not
     * exist, or the new service is not compatible with the ambulance
     */
    @Override
    public void insertAfter(Service oldService, Service newService) throws RouteException {

        if (oldService == null || newService == null) {
            throw new RouteException("O serviço é nulo.");
        }

        boolean found = false;
        int index = -1;
        for (int i = 0; i < services.length; i++) {
            if (services[i].equals(oldService)) {
                found = true;
                index = i;
                break;
            }
        }

        if (!found) {
            throw new RouteException("O serviço antigo não está na rota.");
        }

        for (Service existingService : services) {
            if (existingService.equals(newService)) {
                throw new RouteException("O serviço novo já está na rota.");
            }
        }

        if (!isServiceCompatible(newService)) {
            throw new RouteException("O serviço novo não é compatível com a ambulância da rota.");
        }

        Service[] newServices = new Service[services.length + 1];
        for (int i = 0; i < this.services.length; i++) {
            newServices[i] = this.services[i];
        }
        newServices[index + 1] = newService;

        for (int i = index + 1; i < this.services.length - (index + 1); i++) {
            newServices[i + 1] = services[i];
        }
        services = newServices;
    }

    /**
     * Returns the total duration of the route.
     *
     * @return the total duration of the route
     */
    @Override
    public double getTotalDuration() {
        return this.totalDuration;
    }

    /**
     * Increases the size of the given array by 5.
     *
     * @param originalArray the array to be increased
     * @return the new array with 5 more free spaces
     */
    public static Object[] increaseArraySizeByFive(Object[] originalArray) {
        int newSize = originalArray.length + 5;
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < originalArray.length; i++) {
            newArray[i] = originalArray[i];
        }

        return newArray;
    }

}
