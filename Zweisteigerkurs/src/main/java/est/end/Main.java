package est.end;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    void main() throws InterruptedException {
            Bar bar = new Bar(1000,'|');
        for (int i = 1; i < bar.getMenge()+1; i++) {
            bar.printBar(i,bar.getMenge());
            Thread.sleep(15);
        }
    }
}
