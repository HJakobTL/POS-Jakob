package est.end;

import java.util.Comparator;

public class LaengeCompertator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()) return 1;
        if (o1.length() < o2.length()) return  -1;
        // return 0; hier könnte ein 2 Kriteritum stehen zB alphabetisch
        return o1.compareTo(o2); // 2. Kreiteritum alphabetisch
    }
}
