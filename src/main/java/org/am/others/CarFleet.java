package org.am.others;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CarFleet {

    private record Car(int position, int speed) implements Comparable<Car>{
        @Override
        public int compareTo(Car car) {
            // for descending order
            return car.position - position;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new LinkedList<>();
        for(int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }
        Collections.sort(cars); // nlogn

        int nFleets = 1;
        float timeOfCurrentFleet = getTimeToDestination(target, cars.getFirst());
        for (int i = 1; i < cars.size(); i++) { // n
            float time = getTimeToDestination(target, cars.get(i));
            if (time > timeOfCurrentFleet) {
                timeOfCurrentFleet = time;
                nFleets++;
            }
        }
        return nFleets;
    }

    private static float getTimeToDestination(int target, Car car) {
        return (target - car.position) / (float) car.speed;
    }
}
