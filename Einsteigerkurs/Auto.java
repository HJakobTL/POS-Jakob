/**
 * Write a description of class Auto here.
 *
 * @author (Jakob Cezawa)
 * @version (29.09.2025)
 */
public class Auto
{
    // Variable
    private String name;
    private double eigengewicht;
    
    private Person fahrer;
    private Person beifahrer;
    private Person ruckbank;
    
    // Auto Objekte
    public Auto(){
        this.setName("n/A");
        this.setEigengewicht(1300); 
    }
    
    public Auto(String name, double eigengewicht){
        this.setName(name);
        this.setEigengewicht(eigengewicht);
    }
    
    // Die Getter
    private String getName(){
        return name;
    }
    
    private double getEigengewicht(){
        return eigengewicht;
    }
    
    // Die Setter
    private void setName(String name){
        if (name == null){
            throw new IllegalArgumentException("Name darf nicht null sein");
        }
        this.name = name;
    }
    
    private void setEigengewicht(double eigengewicht){
        if (eigengewicht < 600 || eigengewicht > 3000){
            throw new IllegalArgumentException("Eigengewicht nur zwischen 600 und 3000 möglich");
        }
        this.eigengewicht = eigengewicht;
    }
    
    // Einsteige Funktion
    public void einsteigen(Person person){
        if (person == null){
            throw new IllegalArgumentException("Person kann nicht 'null' sein");
        }
        if (this.fahrer == null){
            this.fahrer = person;
            System.out.println(fahrer.getName() + " ist der Fahrer");
        }
        else if (this.beifahrer == null){
            this.beifahrer = person;
            System.out.println(beifahrer.getName() + " ist der Beifahrer");
        }
        else if (this.ruckbank == null){
            this.ruckbank = person;
            System.out.println(ruckbank.getName() + " ist auf der Rückbank");
        }
        else throw new IllegalStateException("Auto ist voll");
    }
    
    // Aussteiger und Aussteige Funktion per Person
    private void aussteigenFahrer(){
        System.out.println(fahrer.getName() + " steigt aus");
        fahrer = null;
    }
    private void aussteigenBeifahrer(){
        System.out.println(beifahrer.getName() + " steigt aus");
        beifahrer = null;
    }
    private void aussteigenRuckbank(){
        System.out.println(ruckbank.getName() + " steigt aus");
        ruckbank = null;
    }
    
    public void aussteigen(Person person){
        if (person == null){
            throw new IllegalArgumentException("Person kann nicht 'null' sein");
        }
        if (this.fahrer == person){
            aussteigenFahrer();
        }
        else if (this.beifahrer == person){
            aussteigenBeifahrer();
        }
        else if (this.ruckbank == person){
            aussteigenRuckbank();
        }
        else throw new IllegalArgumentException("Kein Person im Auto oder Person ist nicht im Auto");
    }
    
    // Austeige Funktion per Name
    public void aussteigen(String name){
        if (name == null){
            throw new IllegalArgumentException("Name darf nicht 'null' sein");
        }
        if (this.fahrer != null && name.equals(fahrer.getName())){
            aussteigenFahrer();
        }
        else if (this.beifahrer != null && name.equals(beifahrer.getName())){
            aussteigenBeifahrer();
        }
        else if (this.ruckbank != null && name.equals(ruckbank.getName())){
            aussteigenRuckbank();
        }
        else throw new IllegalArgumentException("Person mit diesem Namen ist nicht im Auto");
    }
    
    // Gesamt Gewicht des Autos ausrechnen
    private double gesamtGewicht(){
        double gesamtGewicht = getEigengewicht(); 
        if (this.fahrer != null){
            gesamtGewicht += this.fahrer.getKg();
            System.out.println(gesamtGewicht);
        }
        if (this.beifahrer != null){
            gesamtGewicht += this.beifahrer.getKg();
            System.out.println(gesamtGewicht);
        }
        if (this.ruckbank != null){
            gesamtGewicht += this.ruckbank.getKg();
            System.out.println(gesamtGewicht);
        }
        return gesamtGewicht;
    }
    
    
    public String Auto_Aushalten(){
        if (gesamtGewicht() > 3500){
            return "Zu viel Gewicht";
        }
        if (gesamtGewicht() < getEigengewicht()){
            throw new IllegalArgumentException("Weniger als das Eigengewicht nicht möglich");
        }
        if (gesamtGewicht() <= 3500 || gesamtGewicht() >= getEigengewicht()){
            return "Auto hält das Gewicht aus";
        }
        else throw new IllegalArgumentException("Error");
    }
    
    // Print Auto Infos
    public void printAuto(){
        System.out.println("Auto: " + name + ", Eigengewicht: " + eigengewicht);
        System.out.println("--------------------------------------------------------");
        
        System.out.print("Fahrer: ");
        if (this.fahrer == null){
            throw new IllegalArgumentException("Der Fahrer fehlt!");
        }
        else this.fahrer.printPerson();
        System.out.println("---------");
        System.out.println("Beifahrer: ");
        if (this.beifahrer == null){
            System.out.println("Ist nicht anwesend");
        }
        else if (this.beifahrer != null){
            this.beifahrer.printPerson();
        }
        System.out.println("---------");
        System.out.println("Ruckbank: ");
        if (this.ruckbank == null){
            System.out.println("Ist nicht anwesend");
        }
        else if (this.ruckbank != null){
            this.ruckbank.printPerson();
        }
        System.out.println("---------");
        System.out.println("Das Gesamtgewicht: " + gesamtGewicht());
        System.out.println("--------------------------------------------------------");
    }
}
