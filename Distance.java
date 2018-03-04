public class Distance {
    /* Napisz klase ktora trzyma informacje o wartosci odleglosci i
    o rodzaju miary METRY KILOMETRY CENTYMETRY w klasie ma byc metoda ktora
    porownuje dwa miary medota toString ktora ladnie wypsuize miare np. 10 km i
    metoda ktora przyjmuje typ miary i zmieni typ miary obiektu na inny
    */

    enum DistanceUnitType {
        CENTIMETERS(0.01),
        METERS(1),
        KILOMETERS(1000);

        private double value;

        DistanceUnitType(double value) {
            this.value = value;
        }

        public double get() {
            return value;
        }
    }

    private double value;
    private DistanceUnitType unitType;

    Distance(double distance, DistanceUnitType unitType) {
        this.value = distance;
        this.unitType = unitType;
    }

    public void changeUnitType(DistanceUnitType unitType) {
        this.value = getDistanceValueInUnit(this, unitType);
        this.unitType = unitType;
    }

    private double getDistanceValueInUnit(Distance distance, DistanceUnitType unitType) {
        return distance.value * distance.unitType.get() / unitType.get();
    }

    public boolean equals(Distance distance) {
        return this.value == getDistanceValueInUnit(distance, this.unitType);
    }

    @Override
    public String toString() {
        return value + " " + unitType;
    }
}
