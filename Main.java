import javax.swing.JFrame;

class Main {
  public static void main(String[] args) {
    JFrame window = new JFrame();
    window.add(new Drawing());
    window.setSize(785,435);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}