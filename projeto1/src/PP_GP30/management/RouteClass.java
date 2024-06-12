/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP_GP30.management;

import com.estg.core.Ambulance;
import com.estg.core.Pathology;
import com.estg.core.Service;
import com.estg.dailyManagement.Route;
import com.estg.dailyManagement.exceptions.RouteException;
import java.time.LocalDateTime;



/**
 *
 * @author maraleite
 */
public class RouteClass implements Route{
    
    private String code;
    private Ambulance ambulance;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Service services[];
    private boolean containsService;
    private double totalDuration;
    

   public RouteClass(String code, Ambulance ambulance, LocalDateTime startDate) {
        this.code = code;
        this.ambulance = ambulance;
        this.startDate = startDate;
        this.services = new Service[0];
        this.containsService = false;
        this.totalDuration = 0;
    }


  

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public Ambulance getAmbulance() {
        return ambulance;
    }

    @Override
    public LocalDateTime getStartDate() {
       return startDate;
    }

    @Override
    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public Service[] getServices() {
        return services;
    }

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

        // Adicionar o serviço à coleção de serviços
        Service[] newServices = new Service[services.length + 1];
        System.arraycopy(services, 0, newServices, 0, services.length);
        newServices[services.length] = srvc;
        services = newServices;

        containsService = true;
    }

    private boolean isServiceCompatible(Service service) {
        // Verifica se o tipo de emergência da ambulância é compatível com a patologia do serviço
        Pathology[] patology = service.getPathologies();
        for(int i = 0; i < service.getPathologies().length; i++){
            if(this.getAmbulance().getAmbulanceType() != patology[i].getEmergenceType()){
                return false;
            }
        }
        return true;    
    }

    @Override
    public boolean containsService(Service srvc) {
        
       for (Service existingService : services) {
            if (existingService.equals(srvc)) {
                return true; // O serviço está na rota
            }
        }
        return false; // o serviço nao esta na rota
    }

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
        Service[] newServices = new Service[services.length - 1];
         
        if (index < services.length - 1) {
            System.arraycopy(services, index + 1, newServices, index, services.length - index - 1);
        }
        services = newServices;

        return removedService;
    }

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

        // Substituir o serviço antigo pelo novo na lista de serviços da rota
        services[index] = newService;
    }

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

        // Inserir o novo serviço após o serviço antigo na lista de serviços da rota
        Service[] newServices = new Service[services.length + 1];
        System.arraycopy(services, 0, newServices, 0, index + 1);
        newServices[index + 1] = newService;
        System.arraycopy(services, index + 1, newServices, index + 2, services.length - (index + 1));
        services = newServices;
    }

    @Override
    public double getTotalDuration() {
       return totalDuration;
    }    
}
