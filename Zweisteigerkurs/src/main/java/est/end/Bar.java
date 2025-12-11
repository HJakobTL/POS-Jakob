package est.end;

public class Bar {

    private int menge;
    private char zeichen;

    public Bar(int menge, char zeichen) {
        this.menge = menge;
        this.zeichen = zeichen;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public void setZeichen(char zeichen) {
        this.zeichen = zeichen;
    }

    public int getMenge() {
        return menge;
    }

    public char getZeichen() {
        return zeichen;
    }

    public void printBar(int cur, int len){
        int perc = ((cur * 100 / len));
        int num_bars = ((perc * len / 100));
        int lenght = 50;
        String s = "[";
        for (int i = 0; i < perc; i++) {
            s+=zeichen;
        }
        for (int i = perc; i < 100; i++) {
            s+=" ";
        }
        s+="]";
        System.out.print(s);
        System.out.print(" "+cur+"/"+len+"("+perc+"%)\r");
    }

}
