public class DistanceTest {
    public static void main(String[] args) {

        Distance distanceOne = new Distance(300, Distance.DistanceUnitType.CENTIMETERS);
        System.out.println(distanceOne.toString());

        distanceOne.changerMesure(Distance.DistanceUnitType.KILOMETERS);
        System.out.println(distanceOne.toString());

        distanceOne.changerMesure(Distance.DistanceUnitType.METERS);
        System.out.println(distanceOne.toString());

        Distance distanceTwo = new Distance(0.003, Distance.DistanceUnitType.KILOMETERS);
        System.out.println(distanceTwo.equals(distanceOne));

    }
}
