import java.io.*;

public class Matrix {

    private int rowNum;
    private int colNum;
    private int[][] values;

    public Matrix(int rowNum, int colNum){
        // constructor chaining
        this(rowNum, colNum, new int[rowNum][colNum]);
    }

    public Matrix(int rowNum, int colNum, int[][] values){
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.values = values;
    }

    public Matrix(String filename){
        try (
                BufferedReader reader = new BufferedReader(new FileReader(filename))
        ){
            while (reader.ready()){
                String initLine = reader.readLine();
                if (initLine != null){
                    String[] initValues = initLine.split(" ");
                    if (initValues.length != 2){
                        throw new InvalidInputFormatException("no init values found");
                    }else{
                        this.rowNum = Integer.parseInt(initValues[0]);
                        this.colNum = Integer.parseInt(initValues[1]);
                    }
                }

                this.values = new int[rowNum][colNum];

                int row = 0;
                String line;
                while((line = reader.readLine()) != null){
                    String[] nums = line.split(" ");
                    for(int col = 0; col < nums.length; col++){
                        values[row][col] = Integer.parseInt(nums[col]);
                    }
                    row++;
                }
            }
        } catch (IOException | InvalidInputFormatException e) {
            e.printStackTrace();
        }
    }



    public void setValues(int[] values){
        int index = 0;
        int row = 0;
        while (index < values.length){
            for (int i = 0; i < colNum; i++){
                this.values[row][i] = values[index];
                index++;
            }
            row++;
        }
    }

    public void setValue(int row, int col, int value){
        this.values[row][col] = value;
    }

    public int getValue(int row, int col){
        return this.values[row][col];
    }

    public int getColNum() {
        return colNum;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int[] getSize(){
        return new int[]{colNum,rowNum};
    }

    public String toString(){
        String result = "";
        for (int[] row : values){
            for (int value : row){
                result += value + " ";
            }
            result += "\n";
        }
        return result;
    }

}
