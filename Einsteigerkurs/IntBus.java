public class IntBus
{
    private int laenge;
    private int[] Bus;

    public IntBus(int laenge){
        this.setBusLaenge(laenge);
    }

    public IntBus(){
        this.setBusLaenge(5);
    }

    public void setBusLaenge(int laenge){
        if(laenge < 1 || laenge > 5){
            throw new IllegalArgumentException("a darf nur zwischen 1 und 5 sein");
        }
        this.laenge = laenge;
        int[] Busl = new int[laenge];
        this.Bus = Busl;
    }

    public int testImBus(int a){
        for (int i = 0; i < Bus.length; i++){
            if ( a == Bus[i]){
                return i;
            }
        }
        return -1;
    }

    public int einsteigenInt(int a){
        if (a <= 0 || a > 100){
            throw new IllegalArgumentException("Zahl darf nur zwischen 1 und 100 sein");
        }
        if (testImBus(a) >= 0){
            throw new IllegalArgumentException( a + " schon im Bus");
        }
        for (int i = 0; i < Bus.length; i++){
            if(Bus[i] == 0){
                Bus[i] = a;
                return a;
            }
        }
        throw new IllegalArgumentException("Bus ist voll");
    }

    public int aussteigenInt(int a){
        if (a <= 0 || a > 100){
            throw new IllegalArgumentException("Zahl darf nur zwischen 1 und 100 sein");
        }
        if (testImBus(a) < 0){
            throw new IllegalArgumentException( a + " nicht im Bus");
        }
        if (Bus[testImBus(a)] == a){
            Bus[testImBus(a)] = 0;
            return 0;
        }
        throw new IllegalArgumentException("Bus ist leer");
    }
}