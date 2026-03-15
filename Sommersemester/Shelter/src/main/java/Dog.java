public class Dog extends Animal{
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String makeSound() {
        return "bark";
    }

    @Override
    public String animalTyp() {
        return "Dog";
    }
}
