import java.util.ArrayList;
import java.util.Iterator;

public class Shelter {

    private final ArrayList<Animal> animals;
    private final int ERROR_CODE = -99;

    public Shelter(){
        animals = new ArrayList<>();
    }

    public boolean addAnimal(Animal animal) {
        if (animal == null || animals.contains(animal)) return false;
        return animals.add(animal);
    }

    public double averageAge() {
        if (animals.isEmpty()) return 0.0;
        double sum = 0.0;
        for (Animal animal : animals) {
            sum += animal.getAge();
        }
        return sum / animals.size();
    }

    public int countDogs() {
        if (animals.isEmpty()) return ERROR_CODE;
        int count = 0;
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                count++;
            }
        }
        return count;
    }

    public boolean removeFirstAnimalName(String name) {
        if(animals.isEmpty()) return false;
        Iterator<Animal> iterator = animals.iterator();
        Animal animal;
        while (iterator.hasNext()) {
            animal = iterator.next();
            if (animal.getName().equals(name)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    public int removeAllAnimalByAge(int age) {
        if(animals.isEmpty()) return ERROR_CODE;
        int count = 0;
        Iterator<Animal> iterator = animals.iterator();
        Animal animal;
        while (iterator.hasNext()) {
            animal = iterator.next();
            if (animal.getAge() == age) {
                count++;
                iterator.remove();
            }
        }
        return count;
    }

    public void sortAnimals() {
        animals.sort(null);
    }

    // TODO
    public void sortAnimalsByAge() {

    }

    @Override
    public String toString() {
        return "Shelter{" +
                "animals=" + animals + "}";
    }
}
