public class Arrays
{
    private int[] array;
    private int[] newArray2;
    private Person[] persons;
    private Person anna;
    public Arrays()
    {
        // Test 1 Arrays
        array = new int[] {1,2,3,4};
        newArray2 = new int[10];
        persons = new Person[10];
    }
    public void printIntArrays()
    {
        System.out.println(array[2]);
        System.out.println(newArray2[3]);
    }
    public void tmpGleichAnnaTest()
    {
        Person anna = new Person("Anna",false, 165, 68);
        this.anna = anna;
        persons[0] = anna;
        Person tmp;
        tmp = persons[0];
        persons[1] = tmp;
        System.out.println(persons[0]);// Printed nur den Ort wo Anna gespeichert ist
        System.out.print("Anna und tmp sind: ");
        System.out.println(anna == tmp);
        System.out.println(tmp);
    }
}
