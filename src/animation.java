import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.util.List;

public class animation extends JPanel
{
    int BAR_WIDTH = 30;
    static int BAR_HEIGHT_MAX = 300;

    int array[];
    boolean swap;

    animation(int array[], boolean swap)
    {
        this.array = array;
        this.swap = swap;
    }

    void setarray(int[] array)
    {
        this.array = array;
        repaint();
    }

    void sort()
    {
        new SortWorker(array).execute();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for (int i = 0; i < array.length; i++)
        {
            int x = i * BAR_WIDTH;
            int y = getHeight() - array[i];

            g.setColor( Color.BLUE );
            g.fillRect(x, y, BAR_WIDTH, array[i]);

            g.setColor( Color.BLACK );
            g.drawString(" " + array[i], x, y);
        }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(array.length * BAR_WIDTH, BAR_HEIGHT_MAX + 20);
    }

    class SortWorker extends SwingWorker<Void, int[]>
    {
        private int[] array;

        public SortWorker(int[] temparray)
        {
            array = Arrays.copyOf(temparray, temparray.length);
        }

        @Override
        protected Void doInBackground()
        {
            int n = array.length;
            int temp = 0;

            for (int i = 0; i < n; i++)
            {
                for (int j = 1; j < (n - i); j++)
                {
                    if (array[j-1] > array[j])
                    {
                        temp = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = temp;

                        if (swap)
                        {
                            publish( Arrays.copyOf(array, array.length) );
                            try { Thread.sleep(400); } 
                            catch (Exception e) {}
                        }
                    }
                }

            }

            return null;
        }

        @Override
        protected void process(List<int[]> list)
        {
            int[] array = list.get(list.size() - 1);
            setarray( array );
        }

    }

    public static int[]Input()
        {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Enter the size of array :");
            int n = sc.nextInt();
            int[] array = new int[n];
            System.out.println("Enter the elements of array :");
            for(int i = 0; i < array.length; i++)
            {
                array[i] = sc.nextInt();
            }
            return array;
        }

    static void Interface()
    {
        animation bubbleSort = new animation(animation.Input(), true);

        JButton sort = new JButton("SORT");
        sort.addActionListener((e) -> bubbleSort.sort());

        JPanel bottom = new JPanel();
        bottom.add( sort );

        JFrame frame = new JFrame("animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.add(bubbleSort, BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.PAGE_END);
        frame.setVisible( true );
    }

    public static void main(String[] args) throws Exception
    {
        Interface();
    }
}