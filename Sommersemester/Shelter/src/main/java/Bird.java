public class Bird extends Animal {

    private boolean ableFlying;

    public Bird(String name, int age, boolean ableFlying) {
        super(name, age);
        setAbleFlying(ableFlying);
    }

    public boolean isAbleFlying() {
        return ableFlying;
    }

    public void setAbleFlying(boolean ableFlying) {
        this.ableFlying = ableFlying;
    }

    public void fly() {
        if (!this.ableFlying) IO.println(this.getName() + " can't fly");
        IO.println(this.getName() + " can fly");
    }

    @Override
    public String makeSound() {
        return "chirp";
    }

    @Override
    public String animalTyp() {
        return "Bird";
    }
}
