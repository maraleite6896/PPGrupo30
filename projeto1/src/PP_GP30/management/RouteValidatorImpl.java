/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP_GP30.management;

import com.estg.core.Service;
import com.estg.dailyManagement.Route;
import com.estg.dailyManagement.RouteValidator;
import com.estg.dailyManagement.Strategy;

/**
 *
 * @author maraleite
 */
public class RouteValidatorImpl implements RouteValidator {

    private boolean validate;

    @Override
    public boolean validate(Route route, Service srvc, Strategy strtg) {
        Service[] s;
        s = route.getServices();

        for (int i = 0; i < route.getServices().length; i++) {
            if (s[i] == srvc) {
                validate = true;
            }
        }

        validate = false;
        return validate;
    }
}
