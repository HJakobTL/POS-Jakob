import java.util.Comparator;

public abstract class Animal extends Shelter implements Comparable<Animal> {

    private String name;
    private int age;

    public Animal(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Fehler: null");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Fehler: Kleiner 0");
        this.age = age;
    }

    public abstract String makeSound();

    public abstract String animalTyp();

    public void eat() {
        IO.println(this.name + " eats!");
    }

    // TODO
    public int compareTo(Animal animal){
        return 0;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.age + ") is a " + this.animalTyp() + "!";
    }
}
