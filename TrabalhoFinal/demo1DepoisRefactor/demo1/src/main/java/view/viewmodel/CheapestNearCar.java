package view.viewmodel;

import exceptions.InvalidNewRental;
import model.Car;
import utils.Point;

public class CheapestNearCar {
        private final Point point;
        private final int walkDistance;
        private final Car.CarType type;

        public CheapestNearCar(Point point, int walkDistance, String type) throws InvalidNewRental {
            try {
                this.type = Car.CarType.valueOf(type.toLowerCase());
            }
            catch (IllegalArgumentException e){
                throw new InvalidNewRental();
            }
            this.point = point;
            this.walkDistance = walkDistance;
        }

        public Point getPoint() {
            return point;
        }

        public int getWalkDistance() {
            return walkDistance;
        }

        public Car.CarType getType() { return type; }
    }
