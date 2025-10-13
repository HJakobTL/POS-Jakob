public class SameEqual
{
    public static void SameEqual()
    {
        String a = "hallo";
        String b = "hallo";
        boolean same = a == b;
        System.out.println("Same? " + same);
        boolean equal = a.equals(b);
        System.out.println("Equal? " + equal);
    }

    public boolean equals(Object other){
        return false;
    }

    public static void demoEq(){
        SameEqual first = new SameEqual();
        SameEqual second = first;
        System.out.println(first == second);
        System.out.println(first.equals(second));
    }

    public static void Eqdemo(){
        SameEqual first = new SameEqual();
        SameEqual second = new SameEqual();
        System.out.println(first == second);
        System.out.println(first.equals(second));
    }
}

