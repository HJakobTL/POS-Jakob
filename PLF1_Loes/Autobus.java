class Autobus {

    private Person[] sitze;

    public Autobus(int sitze) {
        this.sitze = new Person[sitze];
    }

    // Anforderungen an die Methode:

    // 1) Exception werfen wenn
    // 1a) person is null
    // 2a) person ist bereits im Bus (caller über logikfehler informieren)

    // 2) die Person auf den ersten freien Sitz setzten und "true" zurückgeben
    // 3) wenn kein Platz mehr frei ist, nix machen und "false" zurückgeben
    public boolean einsteigen(Person person) {
        if (person == null){
            throw new IllegalArgumentException("Person ist null");
        }
        if(istDrin(person)){
            throw new IllegalArgumentException("Person schon im Bus");
        }
        for (int i = 0; i < sitze.length; i++){
            if (sitze[i] == null){
                sitze[i] = person;
                return true;
            }
        }
        return false;
    }

    // gibt zurück, ob die Person im Bus ist ( true / false )
    // throws on NULL
    public boolean istDrin(Person person) {
        // for(int i = 0; i < sitze.length; i++){
            // if (sitze[i] == person){
                // return true;
            // }
        // }
        for(Person p: sitze){
            if (p == person){
                return true;
            }
        }
        return false;
    }
    
    public boolean istVoll(){
        return !istDrin(null);
    }
    
    public boolean hatPlatz(){
        return istDrin(null);
    }
}
