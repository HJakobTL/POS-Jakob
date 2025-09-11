
/**
 * Write a description of class Auto here.
 *
 * @author (Jakob Cezawa)
 * @version (11.9.2025)
 */
public class Auto
{
    private String farbe;
    private int baujahr;
    
    private void setFarbe(String Autofarbe){
        this.farbe = Autofarbe;
    }
    private void setBauJahr(int Autobaujahr){
        this.baujahr = Autobaujahr;
    }
    public Auto(String farbe, int baujahr){
        this.setFarbe(farbe);
        this.setBauJahr(baujahr);
    }
    public int alterRechner(int baujahr){
        int aktjahr = 2025;
        int ergebnis = aktjahr - baujahr;
        return ergebnis;
    }
    public void AutoAusgabe(){
        System.out.println("Farbe: " + this.farbe);
        System.out.println("Alter: " + alterRechner(this.baujahr));
    }
}
