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

import com.estg.core.Client;
import com.estg.core.Gender;
import com.estg.core.Pathology;
import java.time.LocalDate;

/*
 * The ClientImpl class implements the Client interface and represents a client.
 * It has four private fields: name, gender, niss, and birthDate, which are initialized through the constructor.
 */
public class ClientImpl implements Client {
    /**
     * The name of the client.
     */
    private String name;
    /**
     * The gender of the client.
     */
    private Gender gender;
    /**
     * The NISS of the client.
     */
    private int niss;
    /**
     * The birth date of the client.
     */
    private LocalDate birthDate;

    /**
     * Initializes an instance of the ClientImpl class with the provided parameters.
     * 
     * @param name The name of the client.
     * @param gender The gender of the client.
     * @param niss The National Insurance Number (NISS) of the client.
     * @param birthDate The birth date of the client.
     */
    public ClientImpl(String name, Gender gender, int niss, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.niss = niss;
        this.birthDate = birthDate;
    }

    /**
     * Returns the name of the client.
     * 
     * @return The name of the client.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns the gender of the client.
     * 
     * @return The gender of the client.
     */
    @Override
    public Gender getGender() {
        return this.gender;
    }

    /**
     * Returns the NISS of the client.
     * 
     * @return The NISS of the client.
     */
    @Override
    public int getNISS() {
        return this.niss;
    }

    /**
     * Returns the birth date of the client.
     * 
     * @return The birth date of the client.
     */
    @Override
    public LocalDate getBirthDate() {
        return this.birthDate;

    }

}
