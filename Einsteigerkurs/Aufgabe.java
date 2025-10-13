public class Aufgabe
{
    public static void Aufgabe()
    {
        System.out.println("----");
        bothTrue();
        System.out.println("----");
        firstTrue();
        System.out.println("----");
        secondTrue();
        System.out.println("----");
        bothFalse();
        System.out.println("----");
    }
    
    public static void firstTrue(){
        Aufgabe first = new Aufgabe();
        Aufgabe second = first;
        System.out.println(first == second);
        System.out.println(first.equals(second));
    }
    
    public boolean equals(Object other){
        return false;
    }
    
    public static void bothFalse(){
        Aufgabe first = new Aufgabe();
        Aufgabe second = new Aufgabe();
        System.out.println(first == second);
        System.out.println(first.equals(second));
    }
    
    public boolean equalsTrue(Object other){
        return true;
    }
    
    public static void secondTrue(){
        Aufgabe first = new Aufgabe();
        Aufgabe second = new Aufgabe();
        System.out.println(first == second);
        System.out.println(first.equalsTrue(second));
    }
    
    public static void bothTrue(){
        Aufgabe first = new Aufgabe();
        Aufgabe second = first;
        System.out.println(first == second);
        System.out.println(first.equalsTrue(second));
    }
}
