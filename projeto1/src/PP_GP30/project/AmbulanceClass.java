/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP_GP30.project;

import com.estg.core.Ambulance;
import com.estg.core.EmergencyType;

/**
 *
 * @author maraleite
 */
public class AmbulanceClass implements Ambulance {

    private String plate;
    private int maxPassengers;
    private int maxUrgents;
    private EmergencyType ambulanceType;
    
    public AmbulanceClass(String plate, EmergencyType ambulanceType, int maxPassengers, int maxUrgents) {
    this.plate = plate;
    this.ambulanceType = ambulanceType;
    this.maxPassengers = maxPassengers;
    this.maxUrgents = maxUrgents;
}

    @Override
    public String getPlate() {
        return plate;
    }

    @Override
    public int getMaxPassengers() {
        return maxPassengers;
    }

    @Override
    public int getMaxUrgents() {
        return maxUrgents;
    }

    @Override
    public EmergencyType getAmbulanceType() {
       return ambulanceType;
    }

    @Override
    public String toString() {
        return "AmbulanceClass{" + "plate=" + plate + ", maxPassengers=" + maxPassengers + ", maxUrgents=" + maxUrgents + ", ambulanceType=" + ambulanceType + '}';
    }

}
