package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private CarServiceImpl carService = new CarServiceImpl();

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> autos = new ArrayList<>();
        autos.add(new Car("Opel", "Astra", 2008));
        autos.add(new Car("Ford", "Focus", 2010));
        autos.add(new Car("Renault", "Logan", 2011));
        autos.add(new Car("ВАЗ", "2114", 2005));
        autos.add(new Car("BMW", "X5", 2009));
        System.out.println(count);
        if (count == null || count >= autos.size()) {
            model.addAttribute("auto", autos);
        } else {
            model.addAttribute("auto", carService.getCars(autos, count));
        }
        return "cars";
    }
}
