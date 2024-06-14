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

import com.estg.core.DurationToOtherDestinations;

/**
 * The DurationToOtherDestinationsImpl class implements the DurationToOtherDestinations interface and represents a duration to another destination.
 * It has two private fields: id and duration, which are initialized through the constructor.
 */
public class DurationToOtherDestinationsImpl implements DurationToOtherDestinations {

    //The unique identifier of the duration to another destination.
    private int id;

    //The duration to another destination in minutes.
    private int duration;

    /**
     * Initializes an instance of the DurationToOtherDestinationsImpl class with the provided parameters.
     * 
     * @param id The unique identifier of the duration to another destination.
     * @param duration The duration to another destination in minutes.
     */
    public DurationToOtherDestinationsImpl(int id, int duration) {
        this.id = id;
        this.duration = duration;
    }

    /**
     * Returns the unique identifier of the duration to another destination.
     * 
     * @return The unique identifier of the duration to another destination.
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Returns the duration to another destination in minutes.
     * 
     * @return The duration to another destination in minutes.
     */
    @Override
    public int getDuration() {
        return this.duration;
    }

}
