
/**
 * Write a description of class Auto here.
 *
 * @author (Jakob Cezawa)
 * @version (11.9.2025)
 */
public class Auto
{
    private String name;
    private int eigengewicht;
    
    private Student fahrer;
    private Student beifahrer;
    private Student ruckbank;
    
    public Auto(){
        setName("n/A");
        setEigengewicht(1300); 
    }
    
    public Auto(String name, int eigengewicht){
        this.setName(name);
        this.setEigengewicht(eigengewicht);
    }
    
    public String getName(){
        return name;
    }
    
    public int getEigengewicht(){
        return eigengewicht;
    }
    
    public void setName(String name){
        if (name == null){
            throw new IllegalArgumentException("Name darf nicht null sein");
        }
        this.name = name;
    }
    
    public void setEigengewicht(int eigengewicht){
        if (eigengewicht < 600 || eigengewicht > 3000){
            throw new IllegalArgumentException("Eigengewicht nur zwischen 600 und 3000 möglich");
        }
        this.eigengewicht = eigengewicht;
    }
    
    public void einsteigen(Student person){
        if (this.fahrer == null){
            this.fahrer = person;
        }
    }
    
    public void aussteigenFahrer(){
        fahrer = null;
    }
    public void aussteigenBeifahrer(){
        beifahrer = null;
    }
    public void aussteigenRuckbank(){
        ruckbank = null;
    }
    
    public void aussteigen(Student person){
        if (person == null){
            throw new IllegalArgumentException("Person kann nicht 'null' sein");
        }
        if (this.fahrer == person){
            aussteigenFahrer();
        }
        if (this.beifahrer == person){
            aussteigenBeifahrer();
        }
        if (this.ruckbank == person){
            aussteigenRuckbank();
        }
        if (this.fahrer != person && this.beifahrer != person && this.ruckbank != person){
            throw new IllegalArgumentException("Kein Person im Auto");
        }
    }
    
    public void aussteigen(String name){
        if (name == null){
            throw new IllegalArgumentException("Name darf nicht 'null' sein");
        }
        if (name.equals(fahrer.getName())){
            aussteigenFahrer();
        }
        if (name.equals(beifahrer.getName())){
            aussteigenBeifahrer();
        }
        if (name.equals(ruckbank.getName())){
            aussteigenRuckbank();
        }
    }
    
    public int gesamtGewicht(){
        int gesamtGewicht = getEigengewicht(); 
        if (this.fahrer != null){
            gesamtGewicht += this.fahrer.getKg();
        }
        if (this.beifahrer != null){
            gesamtGewicht += this.fahrer.getKg();
        }
        if (this.ruckbank != null){
            gesamtGewicht += this.fahrer.getKg();
        }
        return gesamtGewicht;
    }
    
    public void printAuto(){
        System.out.println("Auto: " + name + ", Eigengewicht: " + eigengewicht);
        System.out.println("--------------------------------------------------------");
        
        System.out.print("Fahrer: ");
        if (this.fahrer == null){
            throw new IllegalArgumentException();
        }
        else this.fahrer.printStudent();
        if (this.fahrer == null){
            throw new IllegalArgumentException();
        }
        else this.beifahrer.printStudent();
        if (this.fahrer == null){
            throw new IllegalArgumentException();
        }
        else this.ruckbank.printStudent();
        System.out.println("--------------------------------------------------------");
    }
}
