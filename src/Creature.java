import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Creature implements Serializable {
    private String name;
    private int age;
    private String address;
    private List<Creature> children = new ArrayList<>();
    private boolean isMarried;
    private Creature husband;
    private Creature father;
    private boolean hasFather;
    private Creature mother;
    public Aura aura = Aura.BETA;
    private static int creaturePopulation;
    private boolean isParent;

    public Creature(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public Aura getAura(){
        return this.aura;
    }
    public String getName() {
        return this.name;
    }
    public boolean hasFather(){
        return this.hasFather;
    }
    public void setFather(Creature father){
        this.father = father;
    }
    public void becameParent(){
        this.isParent = true;
    }
    public boolean isParent() {
        return this.isParent;
    }
    public Creature getFather(){
        return this.father;
    }
    public void setMother(Creature mother){
        this.father = mother;
    }
    public int getAge() {
       return this.age;
    }
    public String getAddress() {
        return this.address;
    }
    public boolean isMarried(){
        return this.isMarried;
    }

    public Creature getHusband() {
        return this.husband;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void makeChild(Creature child) throws IllegalAccessException {

        if (!isMarried){
            throw new IllegalAccessException("First marry, then children!");
        } else {
            if (child.getFather() != null && this.isParent()) {
                System.out.println("A new child has born!");
                return;
            }
            children.add(child);
            child.setFather(this);
            this.becameParent();
            this.husband.makeChild(child);
        }
    }

    public void marry(Creature creature) {
        if (this.getHusband() == creature) {
            System.out.println("We have two couples married!");
            return;
        }
        this.isMarried = true;
        this.husband = creature;
        creature.marry(this);
    }

    public String toString() {
        return STR."My name is \{this.getName()} and my address is: \{this.getAddress()}";
    }



}
