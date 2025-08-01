package web.service;

import web.model.Car;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class CarService {
    private static final Logger log = LoggerFactory.getLogger(CarService.class);
    private final List<Car> cars;

    public CarService() {
        log.info("Инициализация CarService...");
        cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 2020));
        cars.add(new Car("BMW", "X5", 2019));
        cars.add(new Car("Audi", "A6", 2021));
        cars.add(new Car("Mercedes", "E-Class", 2018));
        cars.add(new Car("Honda", "Accord", 2022));
        log.info("Добавлено {} машин", cars.size());
    }

    public List<Car> getCars(int count) {
        log.debug("Запрос {} машин из {}", count, cars.size());
        return count >= 5 ? new ArrayList<>(cars) : new ArrayList<>(cars.subList(0, count));
    }
}