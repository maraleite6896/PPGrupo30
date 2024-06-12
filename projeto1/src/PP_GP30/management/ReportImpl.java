/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP_GP30.management;

import com.estg.core.EmergencyType;
import com.estg.core.Pathology;
import com.estg.core.PathologyType;
import com.estg.dailyManagement.Report;
import java.time.LocalDateTime;

/**
 *
 * @author maraleite
 */
public class ReportImpl implements Report {

    private LocalDateTime date;
    private double totalDuration;
    private int numberOfServices;
    private int numberOfRoutes;
    private int numberOfClients;
    private int numberOfServicesPathology;
    private int numberOfServicesByPathology;

    @Override
    public LocalDateTime getDate() {
        return this.date;
    }

    @Override
    public double getTotalDuration() {
        return this.totalDuration;
    }

    @Override
    public int getNumberOfServices(EmergencyType et) {
        return this.numberOfServices;
    }

    @Override
    public int getNumberOfRoutes() {
        return this.numberOfRoutes;
    }

    @Override
    public int getNumberOfClients() {
        return this.numberOfClients;
    }

    @Override
    public int getNumberOfServicesByPathology(Pathology pthlg) {
        return this.numberOfServicesPathology;
    }

    @Override
    public int getNumberOfServicesByPathology(PathologyType pt) {
        return this.numberOfServicesByPathology;
    }

}
