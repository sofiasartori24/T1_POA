public class Main {
    static public void main(String[] args) {
        Problema1 p1 = new Problema1();
        String[] S = {"buy Amazon", "buy Google", "buy Apple", "buy Google", "buy Google", "buy NVIDIA"};
        String[] S_line = {"buy Google", "buy Apple", "buy Google", "buy NVIDIA"};
        System.out.println(p1.hasTrend(S, S_line));
    }

}
