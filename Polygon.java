/**
 * Polygon class implements a simple 2d polygon
 * 
 */


public class Polygon implements Comparable <Polygon>
{
    private int [][] vertices;


    /**
     * 
     * @param vertices : The 2d array of 2d coordinates of the given polygon
     */
    Polygon(int [][] vertices)
    {
        this.vertices = vertices;
    }

    /**
     * The calculate area method uses the class property 'Vertices' to calculate the area of the polygon,
     * using the shoelace algorithm
     * 
     * @return : Area of this Polygon
     */
    public double calculateArea ()
    {
        int sumRight = 0;
        int sumLeft = 0;

        for (int i = 0; i < vertices.length - 1; i ++)
        {
                sumRight += this.vertices[i][0] * this.vertices[i+1][1];
                sumLeft += this.vertices[i][1] * this.vertices[i+1][0];
        }

        sumRight += this.vertices[this.vertices.length-1][0] * this.vertices[0][1];
        sumLeft += this.vertices[this.vertices.length-1][1] * this.vertices[0][0];

        return 0.5 * Math.abs(sumRight - sumLeft);

    }

    /**
     * The compareTo method will compare two Polygons
     * @return  : 1 if this polygon is larger, 0 if equal size and -1 if this polygon is smaller
     */

    @Override
    public int compareTo(Polygon p) 
    {
        if (p.calculateArea() < this.calculateArea())
        {
            return 1;
        }
        else if (p.calculateArea() == this.calculateArea())
        {
            return 0;
        }
        else
        {
            return -1;
        }
        
    }

    public static void main(String [] args)
    {
        //Coordinates implemented as 2d int array, must be on the form of: {{x1,y1},{x2,y2},{x3,y3}.....}
        int [][] coordinates = {{2,7},{10,1},{8,6},{11,7},{7,10}};
        int [][] coordinates2 = {{3,4},{5,11},{12,8},{9,5},{5,6}};
        int [][] coordinates3 = {{1,7}, {3,5}, {2,3}};

        //Creates the 3 new polygons, each with different coordinates
        Polygon p1 = new Polygon(coordinates);
        Polygon p2 = new Polygon(coordinates2);
        Polygon p3 = new Polygon(coordinates3);

        //Prints each area 
        System.out.println(p1.calculateArea());
        System.out.println(p2.calculateArea());
        System.out.println(p3.calculateArea());
        
        //Shows compare to is working
        System.out.println(p2.compareTo(p1));
        System.out.println(p2.compareTo(p2));
        System.out.println(p2.compareTo(p3)); 


    }
    
}