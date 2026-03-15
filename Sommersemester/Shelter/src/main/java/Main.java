void main() {

    Shelter s1 = new Shelter();
    Dog d1 = new Dog("Max", 2);
    Dog d2 = new Dog("Domi", 4);
    Bird b1 = new Bird("Gus", 6, true);
    Bird b2 = new Bird("King", 4, false);


    s1.addAnimal(d1);
    s1.addAnimal(d1);
    s1.addAnimal(d2);
    s1.addAnimal(b1);
    s1.addAnimal(b2);

    IO.println(b1);
    b1.fly();
    d1.eat();
    IO.println(b2.makeSound());
    IO.println(d2.makeSound());

    IO.println(s1);
    IO.println(s1.averageAge());
    IO.println(s1.countDogs());
    IO.println(s1.removeAllAnimalByAge(4));
    IO.println(s1);

    IO.println(s1.removeFirstAnimalName("Gus"));
    IO.println(s1);

    s1.addAnimal(d1);
    s1.addAnimal(d1);
    s1.addAnimal(d2);
    s1.addAnimal(b1);
    s1.addAnimal(b2);
    IO.println("-------------");
    IO.println(s1);
    IO.println("-------------");
    s1.sortAnimals();
    IO.println("-------------");
    s1.sortAnimalsByAge();

}
