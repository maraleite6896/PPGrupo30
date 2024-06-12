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
public class AmbulanceImpl implements Ambulance {

    private String plate;
    private int maxPassengers;
    private int maxUrgents;
    private EmergencyType ambulanceType;

    public AmbulanceImpl(String plate, EmergencyType ambulanceType, int maxPassengers, int maxUrgents) {
        this.plate = plate;
        this.ambulanceType = ambulanceType;
        this.maxPassengers = maxPassengers;
        this.maxUrgents = maxUrgents;
    }

    @Override
    public String getPlate() {
        return this.plate;
    }

    @Override
    public int getMaxPassengers() {
        return this.maxPassengers;
    }

    @Override
    public int getMaxUrgents() {
        return this.maxUrgents;
    }

    @Override
    public EmergencyType getAmbulanceType() {
        return this.ambulanceType;
    }

    @Override
    public String toString() {
        return "AmbulanceClass{" + "plate=" + plate + ", maxPassengers=" + maxPassengers + ", maxUrgents=" + maxUrgents + ", ambulanceType=" + ambulanceType + '}';
    }
}
