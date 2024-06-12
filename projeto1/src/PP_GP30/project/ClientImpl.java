/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP_GP30.project;

import com.estg.core.Client;
import com.estg.core.Gender;
import com.estg.core.Pathology;
import java.time.LocalDate;

/**
 *
 * @author maraleite
 */
public class ClientImpl implements Client {

    private String name;
    private Gender gender;
    private int niss;
    private LocalDate birthDate;

    public ClientImpl(String name, Gender gender, int niss, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.niss = niss;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Gender getGender() {
        return this.gender;
    }

    @Override
    public int getNISS() {
        return this.niss;
    }

    @Override
    public LocalDate getBirthDate() {
        return this.birthDate;

    }

}
