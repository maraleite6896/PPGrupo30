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

import com.estg.core.Ambulance;
import com.estg.core.Client;
import com.estg.core.FireDepartment;
import com.estg.core.Pathology;
import com.estg.core.Service;
import com.estg.core.exceptions.AmbulanceException;
import com.estg.core.exceptions.ClientException;
import com.estg.core.exceptions.ServiceException;
import com.estg.dailyManagement.DailyPlan;
import com.estg.dailyManagement.exceptions.DailyPlanException;
import java.time.LocalDateTime;

/**
 * The FireDepartmentImpl class implements the FireDepartment interface and
 * represents a fire department. It has several private fields: name, clients,
 * services, ambulances, dailyPlans, and flags for adding daily plans, clients,
 * and services.
 */
public class FireDepartmentImpl implements FireDepartment {
    /**
     * The name of the fire department.
     */
    private String name;
    /**
     * An array of clients associated with the fire department.
     */
    private Client clients[];
    /**
     * An array of services provided by the fire department.
     */
    private Service services[];
    /**
     * An array of ambulances available at the fire department.
     */
    private Ambulance ambulances[];
    /**
     * A flag indicating whether an ambulance can be added.
     */
    private boolean ambulance;
    /**
     * An array of daily plans for the fire department.
     */
    private DailyPlan dailyPlans[];
    /**
     * The most recent daily plan.
     */
    private DailyPlan dailyPan;
    /**
     * A flag indicating whether a daily plan can be added.
     */
    private boolean addDailyPlan;
    /**
     * A flag indicating whether a client can be added.
     */
    private boolean addClient;
    /**
     * A flag indicating whether a service can be added.
     */
    private boolean addService;

    /**
     * Initializes an instance of the FireDepartmentImpl class with the provided
     * parameters.
     *
     * @param name The name of the fire department.
     * @param clients An array of clients associated with the fire department.
     * @param services An array of services provided by the fire department.
     * @param ambulances An array of ambulances available at the fire
     * department.
     */
    public FireDepartmentImpl(String name, Client[] clients, Service[] services, Ambulance[] ambulances) {
        this.name = name;
        this.clients = clients;
        this.services = services;
        this.ambulances = ambulances;
    }

    /**
     * Returns the name of the fire department.
     *
     * @return The name of the fire department.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns an array of clients associated with the fire department.
     *
     * @return An array of clients associated with the fire department.
     */
    @Override
    public Client[] getClients() {
        return this.clients;
    }

    /**
     * Returns an array of services provided by the fire department.
     *
     * @return An array of services provided by the fire department.
     */
    @Override
    public Service[] getServices() {
        return this.services;
    }

    /**
     * Returns an array of ambulances available at the fire department.
     *
     * @return An array of ambulances available at the fire department.
     */
    @Override
    public Ambulance[] getAmbulances() {
        return this.ambulances;
    }

    /**
     * Adds an ambulance to the fire department.
     *
     * @param amblnc The ambulance to be added.
     * @return True if the ambulance was added successfully, false otherwise.
     * @throws AmbulanceException If the ambulance is null or already exists.
     */
    @Override
    public boolean addAmbulance(Ambulance amblnc) throws AmbulanceException {

        if (ambulances == null) {
            throw new AmbulanceException("The ambulance is null.");
        }

        for (Ambulance existingAmbulance : ambulances) {
            if (existingAmbulance.equals(amblnc)) {
                return false;
            }
        }

        Ambulance[] newAmbulances = new Ambulance[ambulances.length + 1];
        for(int i = 0; i < ambulances.length; i++) {
            newAmbulances[i] = ambulances[i];
        }
        newAmbulances[ambulances.length] = amblnc;
        ambulances = newAmbulances;

        return true;

    }

    /**
     * Returns an array of daily plans for the fire department.
     *
     * @return An array of daily plans for the fire department.
     */
    @Override
    public DailyPlan[] getDailyPlans() {
        return dailyPlans;
    }

    /**
     * Returns an array of daily plans for the fire department within a
     * specified date range.
     *
     * @param ldt The start date.
     * @param ldt1 The end date.
     * @return An array of daily plans for the fire department within the
     * specified date range.
     */
    @Override
    public DailyPlan[] getDailyPlans(LocalDateTime ldt, LocalDateTime ldt1) {

        if (ldt1.isBefore(ldt) && ldt.isAfter(ldt1)) {
            return null;
        }

        DailyPlan[] dailyPlan;
        dailyPlan = this.getDailyPlans();
        DailyPlan[] temp = new DailyPlan[5];
        int count = 0;
        for (int i = 0; i < this.getDailyPlans().length; i++) {

            if (count == temp.length) {
                temp = (DailyPlan[]) increaseArraySizeByFive(temp);
            }
            if (!dailyPlan[i].getDate().isBefore(ldt) && !dailyPlan[i].getDate().isAfter(ldt1)) {
                temp[count] = dailyPlan[i];
                count++;
            }
        }

        return temp;
    }

    /**
     * Returns the most recent daily plan.
     *
     * @return The most recent daily plan.
     * @throws DailyPlanException If no daily plans exist.
     */
    @Override
    public DailyPlan getDailyPan() throws DailyPlanException {
        DailyPlan[] temp = this.getDailyPlans();
        DailyPlan dailyPlan = null;
        int count = 0;

        if (this.getDailyPlans().length == 0) {
            throw new DailyPlanException("Não existem DailyPlans");
        }

        for (int i = 0; i < this.getDailyPlans().length; i++) {
            if (count == 0) {
                dailyPlan = temp[i];
                count++;
            }
            if (temp[i].getDate().isAfter(dailyPlan.getDate())) {
                dailyPlan = temp[i];
            }
        }

        return dailyPlan;
    }

    /**
     * Adds a daily plan to the fire department.
     *
     * @param dp The daily plan to be added.
     * @return True if the daily plan was added successfully, false otherwise.
     * @throws DailyPlanException If the daily plan is null or already exists.
     */
    @Override
    public boolean addDailyPlan(DailyPlan dp) throws DailyPlanException {
        if (dailyPlans == null || dp.getDate().isBefore(this.getDailyPan().getDate())) {
            throw new DailyPlanException("The daily plan is null.");
        }

        for (DailyPlan existingPlan : dailyPlans) {
            if (existingPlan.equals(dp)) {
                return false; // Plano diário já existe
            }
        }

        DailyPlan[] newDailyPlans = new DailyPlan[dailyPlans.length + 1];
        for(int i = 0; i < dailyPlans.length; i++) {
            newDailyPlans[i] = dailyPlans[i];
        }
        newDailyPlans[dailyPlans.length] = dp;
        dailyPlans = newDailyPlans;

        return true;
    }

    /**
     * Adds a client to the fire department.
     *
     * @param client The client to be added.
     * @return True if the client was added successfully, false otherwise.
     * @throws ClientException If the client is null or already exists.
     */
    @Override
    public boolean addClient(Client client) throws ClientException {

        if (client == null) {
            throw new ClientException("The client is null.");
        }

        for (Client existingClient : clients) {
            if (existingClient.equals(client)) {
                return false;
            }
        }

        Client[] newClients = new Client[clients.length + 1];
        for(int i = 0; i < clients.length; i++) {
            newClients[i] = clients[i];
        }
        newClients[clients.length] = client;
        clients = newClients;

        return true;
    }

    /**
     * Adds a service to the fire department.
     *
     * @param srvc The service to be added.
     * @return True if the service was added successfully, false otherwise.
     * @throws ServiceException If the service is null, the associated client
     * does not exist, or the associated pathology does not exist.
     */
    @Override
    public boolean addService(Service srvc) throws ServiceException {

        if (srvc == null) {
            throw new ServiceException("The service is null.");
        }

        for (Service existingService : services) {
            if (existingService.equals(srvc)) {
                return false;
            }
        }

        boolean clientExists = false;
        for (Client existingClient : clients) {
            if (existingClient.equals(srvc.getClient())) {
                clientExists = true;
                break;
            }
        }
        if (!clientExists) {
            throw new ServiceException("The client associated with the service does not exist.");
        }

        boolean pathologyExists = false;
        for (Pathology servicePathology : srvc.getPathologies()) {
            if (servicePathology != null) {
                pathologyExists = true;
                break;
            }
        }

        if (!pathologyExists) {
            throw new ServiceException("A patologia não existe.");
        }

        Service[] newServices = new Service[services.length + 1];
        for(int i = 0; i < services.length; i++) {
            newServices[i] = services[i];
        }
        newServices[services.length] = srvc;
        services = newServices;

        return true;
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
