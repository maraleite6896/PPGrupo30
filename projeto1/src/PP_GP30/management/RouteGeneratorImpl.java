/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP_GP30.management;

import com.estg.core.Ambulance;
import com.estg.core.EmergencyType;
import com.estg.core.FireDepartment;
import com.estg.core.Pathology;
import com.estg.core.Service;
import com.estg.dailyManagement.Report;
import com.estg.dailyManagement.Route;
import com.estg.dailyManagement.RouteGenerator;
import com.estg.dailyManagement.RouteValidator;
import com.estg.dailyManagement.Strategy;

/**
 *
 * @author maraleite
 */
public class RouteGeneratorImpl implements RouteGenerator {

    private Route generateRoute[];

    /**
     *
     * @param fd firedepartment a ser analisado
     * @param strtg estratégia a ser seguida
     * @param rv validação das rotas tendo em conta as restições
     * @param report
     * @return a lista de rotas
     */
    @Override
    public Route[] generateRoute(FireDepartment fd, Strategy strtg, RouteValidator rv, Report report) {
        int count = 0;
        if (fd.getAmbulances() == null || fd.getAmbulances().length == 0) {
            return null;
        }

        if (fd.getClients() == null || fd.getClients().length == 0) {
            return null;
        }

        if (generateRoute.length == count) {
            generateRoute = (Route[]) increaseArraySizeByFive(generateRoute);
        }
        //ter atenção ao tipo de patologia(urgente ou não urgente)
        Ambulance[] ambulance = fd.getAmbulances();
        Service[] services = fd.getServices();
        //perceber se todos os serviços do quartel ou só alguns
        for (int i = 0; i < fd.getServices().length; i++) {
            Pathology[] pathology = services[i].getPathologies();
            EmergencyType[] emergencyType = new EmergencyType[0];
            EmergencyType[] nonEmergencyType = new EmergencyType[0];
            int countEmergency = 0, countNonEmergency = 0;
            for (int j = 0; j < services[i].getPathologies().length; j++) {
                if (pathology[j].getEmergenceType() == EmergencyType.EMERGENCY) {
                    if (emergencyType.length == countEmergency) {
                        emergencyType = (EmergencyType[]) increaseArraySizeByFive(emergencyType);
                    }

                    emergencyType[countEmergency] = pathology[j].getEmergenceType();
                    countEmergency++;
                } else if (pathology[j].getEmergenceType() == EmergencyType.NON_EMERGENCY) {
                    if (nonEmergencyType.length == countNonEmergency) {
                        nonEmergencyType = (EmergencyType[]) increaseArraySizeByFive(nonEmergencyType);
                    }

                    nonEmergencyType[countNonEmergency] = pathology[j].getEmergenceType();
                    countNonEmergency++;
                }
            }
            for (int k = 0; k < fd.getAmbulances().length; k++) {
                if (emergencyType.length > 0) {
                    if (ambulance[k].getAmbulanceType() == EmergencyType.EMERGENCY && ambulance[k].getMaxUrgents() >= countNonEmergency) {

                    }
                }
            }
        }
        return generateRoute;
    }

    /**
     *
     * @param originalArray array a ser aumentado
     * @return retorna o novo array com mais 5 espaços livres
     */
    public static Object[] increaseArraySizeByFive(Object[] originalArray) {
        int newSize = originalArray.length + 5;
        Object[] newArray = new Object[newSize];
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);

        return newArray;
    }
}
