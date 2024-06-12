/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP_GP30.project;

import com.estg.core.DurationToOtherDestinations;

/**
 *
 * @author maraleite
 */
public class DurationToOtherDestinationsImpl implements DurationToOtherDestinations {

    private int id;
    private int duration;

    public DurationToOtherDestinationsImpl(int id, int duration) {
        this.id = id;
        this.duration = duration;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }

}
