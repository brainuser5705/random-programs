import java.util.Arrays;

public class MatrixOperations {

    public static Matrix addMatrices (Matrix a, Matrix b) throws InvalidMatricesException {
        if (!Arrays.equals(a.getSize(), b.getSize())){
            throw new InvalidMatricesException("Not the same size: cannot add");
        }

        // a and b matrices will have the same number of rows and cols, and so will the result matrix
        Matrix resultMatrix = new Matrix(a.getRowNum(), a.getColNum());
        for (int r = 0; r < resultMatrix.getRowNum(); r++){
            for (int c = 0; c < resultMatrix.getColNum(); c++ ){
                int sum = a.getValue(r,c) + b.getValue(r,c);
                resultMatrix.setValue(r,c, sum);
            }
        }

        return resultMatrix;
    }

    public static Matrix multiplyMatrices(Matrix a, Matrix b) throws InvalidMatricesException {
        if (a.getColNum() != b.getRowNum()){
            throw new InvalidMatricesException("Invalid row and column pair");
        }

        Matrix resultMatrix = new Matrix(a.getRowNum(), b.getColNum());

        // r is row index
        for (int r = 0; r < a.getRowNum(); r++){
            // c is column index
            for (int c = 0; c < b.getColNum(); c++){
                int sum = 0;
                // k is the index tracker
                //get a row num or b col num
                for (int k = 0; k < a.getRowNum(); k++){
                    sum += a.getValue(r,k) * b.getValue(k,c);
                    // strange but k and c are flipped because of how matrix multiplication works
                }
                //r c th position of the resultMatrix - notice it is in the for loop for column
                // for each row, for each col calculate sum and add to matrix
                resultMatrix.setValue(r, c, sum);
            }
        }

        return resultMatrix;
    }
}
