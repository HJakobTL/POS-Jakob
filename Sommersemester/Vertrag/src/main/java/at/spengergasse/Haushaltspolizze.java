package at.spengergasse;

public class Haushaltspolizze extends Vertrag{

    private double quadratmeter;

    public Haushaltspolizze(double summe, double quadratmeter) throws VersicherungException {
        super(summe);
        setQuadratmeter(quadratmeter);
    }

    private void setQuadratmeter(double quadratmeter) throws VersicherungException {
        if(quadratmeter <= 0.0) {
            throw new VersicherungException("Fehler: quadratmeter müssen größer als 0.0 sein");
        }
    }

    public double getQuadratmeter() {
        return quadratmeter;
    }

    @Override
    public double berechnePreis() {
        return (quadratmeter/100) * (getSumme()/1000);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Haushaltspolizze that = (Haushaltspolizze) o;
        return Double.compare(quadratmeter, that.quadratmeter) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Double.hashCode(quadratmeter);
        return result;
    }

    @Override
    public String toString() {
        return  super.toString() + ", Haushaltspolizze für " +
                quadratmeter + " m2";
    }
}
