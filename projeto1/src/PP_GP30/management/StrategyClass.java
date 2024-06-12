/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP_GP30.management;


import com.estg.core.FireDepartment;
import com.estg.core.Service;
import com.estg.dailyManagement.DailyPlan;
import com.estg.dailyManagement.Route;
import com.estg.dailyManagement.RouteValidator;
import com.estg.dailyManagement.Strategy;

/**
 *
 * @author maraleite
 */
public class StrategyClass implements Strategy{
    
    @Override
    //Terminar este método
    public Route[] generate(FireDepartment fd, RouteValidator rv) {
        DailyPlan[] daily = fd.getDailyPlans();
        Route[] routes = new Route[0];
        int i, j, k, count = 0;
        for(i = 0; i < fd.getDailyPlans().length; i++){
            Route[] temp = daily[i].getRoutes();
            for(j = 0; j < daily[i].getRoutes().length; j++){  
                Service[] service = fd.getServices();
                for(k = 0; k < fd.getServices().length; k++){
                    if(rv.validate(temp[j], service[k], this)){
                        if(routes.length == count){
                            routes = (Route[]) increaseArraySizeByFive(routes);
                            count++;
                        }
                        
                    }
                }
            }
        }
        return routes;
    }

    public static Object[] increaseArraySizeByFive(Object[] originalArray) {
        int newSize = originalArray.length + 5;
        Object[] newArray = new Object[newSize];
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);

        return newArray;
    }    
}
