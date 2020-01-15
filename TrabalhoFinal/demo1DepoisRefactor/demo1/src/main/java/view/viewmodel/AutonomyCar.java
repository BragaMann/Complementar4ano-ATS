package view.viewmodel;
import exceptions.InvalidNewRental;
import model.Car;
import utils.Point;

public class AutonomyCar {
    private final Point point;
    private final int autonomy;
    private final Car.CarType type;

    public AutonomyCar(Point point, int autonomy, String type) throws InvalidNewRental {
        try {
            this.type = Car.CarType.valueOf(type.toLowerCase());
        }
        catch (IllegalArgumentException e){
            throw new InvalidNewRental();
        }
        this.point = point;
        this.autonomy = autonomy;
    }

    public Point getPoint() {
        return point;
    }

    public int getAutonomy() {
        return autonomy;
    }

    public Car.CarType getType() { return type; }
}
