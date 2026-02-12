package est.end.Vektoren;

public class MainVektoren {

    static void main() {

        Vektor v1 = new Vektor(3);
        v1.setVektor(0,1);
        v1.setVektor(1,2);
        v1.setVektor(2,3);

        Vektor v2 = new Vektor(3);
        v2.setVektor(0,4);
        v2.setVektor(1,5);
        v2.setVektor(2,6);


        System.out.println(v1.getVektorLen());
        System.out.println(v1.istGleichLang(v2));
        System.out.println(v1.multi(v2));

        Vektor e = v1.add(v2);
        System.out.println(e);

    }
}
