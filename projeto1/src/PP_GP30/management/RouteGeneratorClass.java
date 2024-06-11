/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP_GP30.management;

import com.estg.core.FireDepartment;
import com.estg.dailyManagement.Report;
import com.estg.dailyManagement.Route;
import com.estg.dailyManagement.RouteGenerator;
import com.estg.dailyManagement.RouteValidator;
import com.estg.dailyManagement.Strategy;

/**
 *
 * @author maraleite
 */
public class RouteGeneratorClass implements RouteGenerator{
    
private Route generateRoute[];
    
    @Override
    public Route[] generateRoute(FireDepartment fd, Strategy strtg, RouteValidator rv, Report report) {
        return generateRoute;
    }
    
}
