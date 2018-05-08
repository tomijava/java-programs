package calculator.interfaces;
public enum Zone {
    PARIS("Europe/Paris", 1), 
    ATHENS("Europe/Athens", 2), 
    MOSCOW("Europe/Moscow", 3),
    SYDNEY("Australia/Sydney", 4),
    TOKYO("Asia/Tokyo", 5),
    KATHMANDU("Asia/Kathmandu", 6),
    LOSANGELES("America/Los_Angeles", 7),
    CHICAGO("America/Chicago" , 8);

    public String idZone;
    public int number;

    private Zone (String id, int number) {
        this.idZone = id;
        this.number = number;
    }
}
