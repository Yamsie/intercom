package formulae;

import geometry.Coordinate;

public class GreatCircleDistance implements I_Formula {

    private double result;

    public GreatCircleDistance(Coordinate coordinate1, Coordinate coordinate2) {
        double x1 = Math.toRadians(coordinate1.getLatitude());
        double y1 = Math.toRadians(coordinate1.getLongitude());
        double x2 = Math.toRadians(coordinate2.getLatitude());
        double y2 = Math.toRadians(coordinate2.getLongitude());

        result = Math.toDegrees(Math.acos((Math.sin(x1) * Math.sin(x2)) + (Math.cos(x1) * Math.cos(x2) * Math.cos(Math.abs(y1 - y2))))) * 60 * 1.852;
    }

    public double getResult() {
        return result;
    }

}
