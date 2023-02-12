import java.awt.*;
public class GUI{
    public static void main(String[] args) 
    {
        Frame f = new Frame("GUI");
        
        animation obj1 = new animation(null, false);
        Selectionani obj2 = new Selectionani(null, false);
        heapani obj3 = new heapani(null, false);
        insetionani obj4 = new insetionani(null, false);
        
        Button b1 = new Button("Bubble Sort");
        b1.setBounds(40,100,100,30);
        b1.addActionListener(e-> obj1.Interface());
        Button b2 = new Button("Selection Sort");
        b2.setBounds(40,140,100,30);
        b2.addActionListener(e-> obj2.Interface());
        Button b3 = new Button("Heap Sort");
        b3.setBounds(40,180,100,30);
        b3.addActionListener(e-> obj3.Interface());
        Button b4 = new Button("Insertion");
        b4.setBounds(40,230,100,30);
        b4.addActionListener(e-> obj4.Interface());
        Button b5 = new Button("");
        
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.setSize(800,800);
        f.setVisible(true);
    }
}