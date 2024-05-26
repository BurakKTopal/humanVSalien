import java.util.ArrayList;
import java.util.List;

public class Human extends Creature{
    private int carModelNumber;
    private boolean hasMeetAlien;
    private int aliensKilled;
    private List<Alien> aliensPictured = new ArrayList<>();

    public Human(String name, int age, String address) {
        super(name, age, address);
    }

    public void pictureAlien(Alien alien){
        aliensPictured.add(alien);
        System.out.println("New alien is pictured: " + alien);
    }

}
