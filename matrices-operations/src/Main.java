public class Main {

    public static void main(String[] args) throws InvalidMatricesException {
        Matrix m = new Matrix(3,3);
        //m.setValues(new int[]{1, 0, 1, 0, -1, -1, -1, 1, 0});
        m.setValues(new int[]{1, -3, 0,1,2,2,2,1,1});
        System.out.println(m);
        Matrix n = new Matrix(3,4);
        //n.setValues(new int[]{0, 1, -1, 1, -1, 0, -1, 0, 1});
        n.setValues(new int[]{1,-1,2,3,-1,0,3,-1,-3,-2,0,2});
        System.out.println(n);
        //System.out.println(MatrixOperations.addMatrices(m,n));
        System.out.println(MatrixOperations.multiplyMatrices(m,n));
        Matrix test = new Matrix("C:\\Users\\brain\\IdeaProjects\\matrix\\src\\test.txt");
        System.out.println(test);
    }

}
