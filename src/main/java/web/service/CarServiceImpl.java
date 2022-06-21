package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final List<Car> autos = new ArrayList<>();
    {
        autos.add(new Car("Opel", "Astra", 2008));
        autos.add(new Car("Ford", "Focus", 2010));
        autos.add(new Car("Renault", "Logan", 2011));
        autos.add(new Car("ВАЗ", "2114", 2005));
        autos.add(new Car("BMW", "X5", 2009));
    }

    @Override
    public List<Car> getCars(Integer count) {
        List<Car> cars = new ArrayList<>();
        if (count == null || count >= 5) {
            return autos;
        } else {
            for (int i = 0; i < count; i++) {
                cars.add(autos.get(i));
            }
        }
        return cars;
    }
}