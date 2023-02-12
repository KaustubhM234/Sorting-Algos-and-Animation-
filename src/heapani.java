import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.util.List;

public class heapani extends JPanel
{
    int BAR_WIDTH = 30;
    static int BAR_HEIGHT_MAX = 300;

    int array[];
    static boolean swap;

    heapani(int array[], boolean swap)
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
            class Heap {
                void maxheap(int array[], int n, int i)
                {
                    int largest = i;
                    int left = 2*i+1;
                    int right = 2*i+2;
                    
                    if (left < n && array[left] > array[largest])  
                        largest = left;    
            
                    if (right < n && array[right] > array[largest])  
                        largest = right; 
            
                    if (largest != i) 
                    {    
                        int temp = array[i];  
                        array[i] = array[largest];  
                        array[largest] = temp;
                        maxheap(array, n, largest);
                    }          
                }  
                
                void sort(int array[], int n)
                {
                    int i;
                    for(i = n / 2 - 1; i >= 0; i--)
                    {
                        maxheap(array, n, i);
                    }
                    
                    for(i=n-1; i>=0; i--)
                    {
                        int temp = array[0];
                        array[0]=array[i];
                        array[i]=temp;
                        maxheap(array, i, 0);
                        if (swap)
                        {
                            publish( Arrays.copyOf(array, array.length) );
                            try { Thread.sleep(800); } 
                            catch (Exception e) {}
                        }
                    }
            
                }
            }
            Heap obj = new Heap();
            obj.sort(array,array.length);

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
        heapani bubbleSort = new heapani(heapani.Input(), true);

        JButton sort = new JButton("SORT");
        sort.addActionListener((e) -> bubbleSort.sort());

        JPanel bottom = new JPanel();
        bottom.add( sort );

        JFrame frame = new JFrame("ani");
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