package com.ggardet.hibernatesearch;

import com.ggardet.hibernatesearch.resource.bicycle.model.Bicycle;
import com.ggardet.hibernatesearch.resource.bicycle.repository.BicycleRepository;
import com.ggardet.hibernatesearch.resource.car.model.Car;
import com.ggardet.hibernatesearch.resource.car.repository.CarRepository;
import com.ggardet.hibernatesearch.resource.plant.model.Plant;
import com.ggardet.hibernatesearch.resource.plant.repository.PlantRepository;
import com.ggardet.hibernatesearch.search.index.Indexer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner initializeData(PlantRepository plantRepository, CarRepository carRepository, BicycleRepository bicycleRepository) {
        return (ApplicationArguments args) -> {
            List<Plant> plants = Arrays.asList(
                    new Plant("subalpine fir", "abies lasiocarpa", "pinaceae"),
                    new Plant("sour cherry", "prunus cerasus", "rosaceae"),
                    new Plant("asian pear", "pyrus pyrifolia", "rosaceae"),
                    new Plant("chinese witch hazel", "hamamelis mollis", "hamamelidaceae"),
                    new Plant("silver maple", "acer saccharinum", "sapindaceae"),
                    new Plant("cucumber tree", "magnolia acuminata", "magnoliaceae"),
                    new Plant("korean rhododendron", "rhododendron mucronulatum", "ericaceae"),
                    new Plant("water lettuce", "pistia", "araceae"),
                    new Plant("sessile oak", "quercus petraea", "fagaceae"),
                    new Plant("megane", "ficus carica", "moraceae")
            );
            plantRepository.saveAll(plants);
            List<Car> cars = Arrays.asList(
                    new Car("clio", "renault"),
                    new Car("megane", "renault"));
            carRepository.saveAll(cars);
            List<Bicycle> bicycles = Arrays.asList(
                    new Bicycle("clio", "model"),
                    new Bicycle("megane", "model"));
            bicycleRepository.saveAll(bicycles);
        };
    }

    @Bean
    public ApplicationRunner buildIndex(Indexer indexer) {
        return (ApplicationArguments args) -> {
            List<Class<?>> entities = List.of(Car.class, Plant.class, Bicycle.class);
            indexer.indexPersistedData(entities);
        };
    }
}
