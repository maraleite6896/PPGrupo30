/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 *
 * @author maraleite
 */
public class FireDepartmentImpl implements FireDepartment {

    private String name;
    private Client clients[];
    private Service services[];
    private Ambulance ambulances[];
    private boolean ambulance;
    private DailyPlan dailyPlans[];
    private DailyPlan dailyPan;
    private boolean addDailyPlan;
    private boolean addClient;
    private boolean addService;

    public FireDepartmentImpl(String name, Client[] clients, Service[] services, Ambulance[] ambulances) {
        this.name = name;
        this.clients = clients;
        this.services = services;
        this.ambulances = ambulances;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Client[] getClients() {
        return clients;
    }

    @Override
    public Service[] getServices() {
        return services;
    }

    @Override
    public Ambulance[] getAmbulances() {
        return ambulances;
    }

    @Override
    public boolean addAmbulance(Ambulance amblnc) throws AmbulanceException {

        if (ambulances == null) {
            throw new AmbulanceException("The ambulance is null.");
        }

        for (Ambulance existingAmbulance : ambulances) {
            if (existingAmbulance.equals(amblnc)) {
                return false; // Ambulance already exists
            }
        }

        // Add the ambulance to the collection of ambulances
        Ambulance[] newAmbulances = new Ambulance[ambulances.length + 1];
        System.arraycopy(ambulances, 0, newAmbulances, 0, ambulances.length);
        newAmbulances[ambulances.length] = amblnc;
        ambulances = newAmbulances;

        return true; // Ambulance was inserted successfully

    }

    @Override
    public DailyPlan[] getDailyPlans() {
        return dailyPlans;
    }

    /**
     *
     * @param ldt data de inicio
     * @param ldt1 data do fim
     * @return em caso de sucesso retorna a lista de daily plans que existem
     * entre as duas datas, caso as datas não consistem num intervalo de tempo
     * válido retona null
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
            //a data tem de estar dentro estas duas datas
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
     *
     * @return o Daily Plan mais recente
     * @throws DailyPlanException e lançada esta exceção caso não existem Daily
     * plans
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

    @Override
    public boolean addDailyPlan(DailyPlan dp) throws DailyPlanException {
        if (dailyPlans == null || dp.getDate().isBefore(this.getDailyPan().getDate())) {
            throw new DailyPlanException("The daily plan is null.");
        }

        // Verifica se o plano diário já existe na coleção de planos diários
        for (DailyPlan existingPlan : dailyPlans) {
            if (existingPlan.equals(dp)) {
                return false; // Plano diário já existe
            }
        }

        // Adiciona o plano diário à coleção de planos diários
        DailyPlan[] newDailyPlans = new DailyPlan[dailyPlans.length + 1];
        System.arraycopy(dailyPlans, 0, newDailyPlans, 0, dailyPlans.length);
        newDailyPlans[dailyPlans.length] = dp;
        dailyPlans = newDailyPlans;

        return true; // Plano diário introduzido  
    }

    @Override
    public boolean addClient(Client client) throws ClientException {

        if (client == null) {
            throw new ClientException("The client is null.");
        }

        // Verifica se o cliente já existe na coleção de clientes
        for (Client existingClient : clients) {
            if (existingClient.equals(client)) {
                return false; // Cliente já existe
            }
        }

        // Adiciona o cliente à coleção de clientes
        Client[] newClients = new Client[clients.length + 1];
        System.arraycopy(clients, 0, newClients, 0, clients.length);
        newClients[clients.length] = client;
        clients = newClients;

        return true; // Cliente foi inserido com sucesso
    }

    @Override
    public boolean addService(Service srvc) throws ServiceException {

        if (srvc == null) {
            throw new ServiceException("The service is null.");
        }

        // Verifica se o serviço já existe na coleção de serviços
        for (Service existingService : services) {
            if (existingService.equals(srvc)) {
                return false; // Serviço já existe
            }
        }

        // Verifica se o cliente associado ao serviço existe
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

        // Verifica se as patologias associadas ao serviço existem
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

        // Adiciona o serviço à coleção de serviços
        Service[] newServices = new Service[services.length + 1];
        System.arraycopy(services, 0, newServices, 0, services.length);
        newServices[services.length] = srvc;
        services = newServices;

        return true; // Serviço foi inserido com sucesso
    }

    public static Object[] increaseArraySizeByFive(Object[] originalArray) {
        int newSize = originalArray.length + 5;
        Object[] newArray = new Object[newSize];
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);

        return newArray;
    }
}
