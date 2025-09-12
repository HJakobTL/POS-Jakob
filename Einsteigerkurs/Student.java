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
    public void setName(String name){
        this.name = name;
    }
    public void setGebjahr(int gebjahr){
        this.gebjahr = gebjahr;
    }
    public void setKg(float kilogramm){
        this.kg = kilogramm;
    }
    public void setCm(float centimeter){
        this.cm = centimeter;
    }
    public void setGender(char gender){
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
        System.out.println("BMI: " + bmi_rechner(this.kg, this.cm));
        System.out.println("Dein Geschlecht: " + MannOderFrau(this.gender));
        System.out.println("Du bist: " + bmi_werter(this.gender));
    }
    //BMI Rechner
    public float bmi_rechner(float kg,float cm){
        cm /= 100;
        float ergebnis = (kg / (cm*cm));
        return ergebnis;
    }
    //Test ob Mann oder Frau
    public String MannOderFrau(char gender){
        if (gender == 'm'){
            return "Männlich";  
        }
        else if (gender == 'f'){
            return "Weiblich";
        }
        else return "Geben Sie 'm' oder 'f'";
    }
    //BMI Schauen ob unter/über/normalgewicht
    public String bmi_werter(char gender){
        int normal_max_m = 25;
        int normal_min_m = 20;
        int normal_max_f = 24;
        int normal_min_f = 19;
        if (gender == 'm'){
            if (bmi_rechner(this.kg, this.cm) < normal_min_m){
                return "Untergewicht";
            }
            else if (bmi_rechner(this.kg, this.cm) > normal_max_m){
                return "Übergewicht";
            }
            else return "Normal";
        }
        else if (gender == 'f'){
            if (bmi_rechner(this.kg, this.cm) < normal_min_f){
                return "Untergewicht";
            }
            else if (bmi_rechner(this.kg, this.cm) > normal_max_f){
                return "Übergewicht";
            }
            else return "Normal";
        }
        else return "Error";
    }
}
