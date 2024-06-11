/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PP_GP30.management;


import com.estg.core.FireDepartment;
import com.estg.dailyManagement.Route;
import com.estg.dailyManagement.RouteValidator;
import com.estg.dailyManagement.Strategy;

/**
 *
 * @author maraleite
 */
public class StrategyClass implements Strategy{
    
@Override
//Tens que gerar um array de rotas possiveis consuante o departamento dado e um validador de rotas
public Route[] generate(FireDepartment fd, RouteValidator rv) {
    // Suponha que temos uma lista de todas as rotas possíveis
    Route[] allRoutes;
    fd.getServices()

    Route[] validRoutes = new Route[allRoutes.length];
    int validRoutesCount = 0;
    for (Route route : allRoutes) {
        if (rv.validate(route)) {
            validRoutes[validRoutesCount++] = route;
        }
    }

    // Redimensiona o array de rotas válidas para o tamanho correto
    Route[] result = new Route[validRoutesCount];
    System.arraycopy(validRoutes, 0, result, 0, validRoutesCount);
    return result;
}




    
}
