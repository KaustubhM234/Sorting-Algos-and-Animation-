import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.util.List;

public class Bucketani extends JPanel
{
    int BAR_WIDTH = 30;
    static int BAR_HEIGHT_MAX = 300;

    int array[];
    static boolean swap;

    Bucketani(int array[], boolean swap)
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
        int k;
        int b[][]= new int[5][20];

        int c[] = new int[20];
        c[0]=0;c[1]=0;c[2]=0;c[3]=0;c[4]=0;
        for(int i=0;i<array.length;i++)
        { 
            if(array[i]/20==0)
            {
                b[0][c[0]]=array[i];   
                c[0]++;
            }
            else if(array[i]/20==1)
            {
                b[1][c[1]]=array[i];
                c[1]++;
            }
            else if(array[i]/20==2)
            {
                b[2][c[2]]=array[i];
                c[2]++;
            }
            else if(array[i]/20==3)
            {
                b[3][c[3]]=array[i];
                c[3]++;
            }
            else if(array[i]/20==4)
            {
                b[4][c[4]]=array[i];
                c[4]++;
            }
            else
            {
                System.out.println("Entered data exceeds limit(1<=arr[i]<=100)");
            }
            if (swap)
                        {
                            publish( Arrays.copyOf(array, array.length) );
                            try { Thread.sleep(800); } 
                            catch (Exception e) {}
                        }
        }

        for(k=0;k<=4;k++)
        {
            if(c[k]>0)
            {
                for(int i=0;i<c[k];i++)
                {
                    int min=i;
                    for(int j=i+1;j<c[k];j++)
                    {
                        if(b[k][min]>b[k][j])
                        {
                            min = j;
                        }
                    }
                    int temp = b[k][i];
                    b[k][i]  = b[k][min];
                    b[k][min] = temp;
                    if (swap)
                        {
                            publish( Arrays.copyOf(array, array.length) );
                            try { Thread.sleep(800); } 
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
        Bucketani bubbleSort = new Bucketani(Bucketani.Input(), true);

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