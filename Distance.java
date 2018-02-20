import java.util.Objects;

public class Distance {

            /* Napisz klase ktora trzyma informacje o wartosci odleglosci i
            o rodzaju miary METRY KILOMETRY CENTYMETRY w klasie ma byc metoda ktora
             porownuje dwa miary medota toString ktora ladnie wypsuize miare np. 10 km i
             metoda ktora przyjmuje typ miary i zmieni typ miary obiektu na inny
             *///wtf



            enum DistanceUnitType
            {
                CENTIMETERS,
                METERS,
                KILOMETERS
            }

            private double distance;
            private DistanceUnitType measure;
            private double cmMeasure;

            Distance(double distance, DistanceUnitType measure)
            {
                this.distance = distance;
                this.measure = measure;

                if(Objects.equals(measure, DistanceUnitType.KILOMETERS))
                {
                   cmMeasure = this.distance *100000;
                }
                else if(Objects.equals(measure, DistanceUnitType.CENTIMETERS))
                {
                    cmMeasure = this.distance;
                }
                else if(Objects.equals(measure, DistanceUnitType.METERS))
                {
                    cmMeasure = this.distance * 100;
                }
            }

            public void changerMesure(DistanceUnitType convert) {
                if (convert.equals(this.measure)) {
                    System.out.println("ten sam wymiar glupku");
                } else if (convert.equals(DistanceUnitType.KILOMETERS)) {
                    if (this.measure.equals(DistanceUnitType.CENTIMETERS)) {
                        this.distance = this.distance / 100000;
                        this.measure = convert;
                    } else if (this.measure.equals(DistanceUnitType.METERS)) {
                        this.distance /= 1000;
                        this.measure = convert;
                    }
                } else if (Objects.equals(convert, DistanceUnitType.METERS)) {
                    if (Objects.equals(this.measure, DistanceUnitType.KILOMETERS)) {
                        this.distance *= 1000;
                        this.measure = convert;
                    } else if (Objects.equals(this.measure, DistanceUnitType.CENTIMETERS)) {
                        this.distance /= 100;
                        this.measure = convert;
                    }
                } else if (Objects.equals(convert, DistanceUnitType.CENTIMETERS)) {
                    if (Objects.equals(this.measure, DistanceUnitType.METERS)) {
                        this.distance *= 100;
                        this.measure = convert;
                    } else if (Objects.equals(this.measure, DistanceUnitType.KILOMETERS)) {
                        this.distance *= 100000;
                        this.measure = convert;
                    }
                }
            }


    public boolean equals(Distance obj) {
        return this.cmMeasure== obj.cmMeasure;
    }

    @Override
        public String toString()
        {
            return distance + " " + measure;
        }
}
