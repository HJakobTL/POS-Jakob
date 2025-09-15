/**
 * Write a description of class Student here.
 *
 * @author (Jakob Cezawa)
 * @version (8.9.2025)
 */
public class Student
{
    // Meine Variablen
    private String name;
    private float kg;
    private float cm;
    private int gebjahr;
    private char gender;
    //Die Setter
    private void setName(String name){
        this.name = name;
    }
    private void setGebjahr(int gebjahr){
        this.gebjahr = gebjahr;
    }
    private void setKg(float kilogramm){
        this.kg = kilogramm;
    }
    private void setCm(float centimeter){
        this.cm = centimeter;
    }
    private void setGender(char gender){
        this.gender = gender;
    }
    //Student Objekt
    public Student(String name, int gebjahr,float kg, float cm, char gender){
        this.setName(name);
        this.setGebjahr(gebjahr);
        this.setKg(kg);
        this.setCm(cm);
        this.setGender(gender);
    }
    //Print Student Info
    public void printStudent(){
        System.out.println("Name: " + this.name + " (Geb. " + this.gebjahr + ")");
        System.out.println("Gewicht: " + this.kg);
        System.out.println("Größe: " + this.cm);
        System.out.println("BMI: " + this.bmi_rechner());
        System.out.println("Dein Geschlecht: " + this.mannOderFrau());
        System.out.println("Du bist: " + this.bmi_werter());
    }
    //BMI Rechner
    private float bmi_rechner(){
        float cmInMetern = this.cm / 100.0f;
        float ergebnis = (this.kg / (cmInMetern*cmInMetern));
        return ergebnis;
    }
    //Test ob Mann oder Frau
    private String mannOderFrau(){
        if (this.gender == 'm'){
            return "Männlich";  
        }
        else if (this.gender == 'f'){
            return "Weiblich";
        }
        else return "Geben Sie 'm' oder 'f'";
    }
    //BMI Schauen ob unter/über/normalgewicht
    private String bmi_werter(){
        int normal_max_m = 25;
        int normal_min_m = 20;
        int normal_max_f = 24;
        int normal_min_f = 19;
        float bmi = this.bmi_rechner();
        if (gender == 'm'){
            if (bmi < normal_min_m){
                return "Untergewicht";
            }
            else if (bmi > normal_max_m){
                return "Übergewicht";
            }
            else return "Normal";
        }
        else if (gender == 'f'){
            if (bmi < normal_min_f){
                return "Untergewicht";
            }
            else if (bmi > normal_max_f){
                return "Übergewicht";
            }
            else return "Normal";
        }
        else return "Error";
    }
}
