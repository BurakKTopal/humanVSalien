import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Alien extends Creature {
    private int ufoNumber;
    private boolean hasMeetHuman = false;
    private boolean hasHumanKilled = false;

    public Alien(String name, int age, String address) {
        super(name, age, address);
    }

    // Creating inner class for the alient boss
    public static class BossAlien extends Alien{
        private int numberOfServants = 0;
        private static final long serialVersionUID = 1L;

        public BossAlien(String name, int age, String address) {
            super(name, age, address);
            this.aura = Aura.ALPHA; // Bosses are always alpha, obviously.
        }
        public void saveAlienBoss() throws IOException {
            FileOutputStream fileOutputStream = new FileOutputStream("AlienBoss.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println(STR."Boss saved with name: \{this.getName()}");
        }
        public static BossAlien readBossAlien() throws IOException, ClassNotFoundException {
            FileInputStream fileInputStream = new FileInputStream("AlienBoss.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            BossAlien savedBoss = (BossAlien)objectInputStream.readObject();
            System.out.println(STR."Boss read with name: \{savedBoss.getName()}");
            return savedBoss;
        }

        @Override
        public String toString() {
            return "This is the boss, he has: " + numberOfServants + " servants!";
        }
    }
    public int getUfoNumber(){
        return this.ufoNumber;
    }
    public boolean hasMeetHuman() {
        return this.hasMeetHuman;
    }
    public boolean hasHumanKilled(){
        return this.hasHumanKilled;
    }

}
