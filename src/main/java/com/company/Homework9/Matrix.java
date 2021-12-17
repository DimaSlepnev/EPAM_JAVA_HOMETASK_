package com.company.Homework9;

public class Matrix {
    private int columns;
    private int rows;
    private double [] [] matrix;
    public Matrix (int rows, int columns){
        matrix = new double[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }

    public int getColumns() {
        return columns;
    }
    
    public int getRows() {
        return rows;
    }
    
    public void setByIndex(int rowsIndex, int columnsIndex, double value ){
        try{
            if (rowsIndex < 0 || rowsIndex > matrix.length || columnsIndex < 0 || columnsIndex > matrix[0].length ){
                throw new MatrixException("Wrong information");
            }
            matrix[rowsIndex][columnsIndex] = value;
        }catch(MatrixException e){
            System.out.println(e.getMessage());
        }

    }
    
    public double getByIndex(int rowsIndex, int columnsIndex) throws MatrixException{
        if (rowsIndex < 0 || rowsIndex > matrix.length || columnsIndex < 0 || columnsIndex > matrix[0].length){
            throw new MatrixException("Invalid index was indicated");
        }
        return matrix[rowsIndex][columnsIndex];
    }
    
    @Override
    public String toString(){
        String res = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res += matrix[i][j] + "\t\t";
            }
            res += "\n";
        }
        return res;
    }

    public boolean CheckBySize(Matrix m2){
        if(this.getRows() == m2.getRows() && this.getColumns() == m2.getColumns()){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean CheckForMultiply(Matrix m2){
        if(this.getColumns() == m2.getRows()){
            return true;
        }
        else{
            return false;
        }
    }

    public Matrix addMatrix(Matrix m2) throws MatrixException{
        Matrix resultMat = new Matrix(this.getRows(), m2.getColumns());
        if (!this.CheckBySize(m2)){
            throw new MatrixException("Matrices have different size, u can't add it");
        }
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                resultMat.setByIndex(i,j, this.getByIndex(i,j) + m2.getByIndex(i,j));
            }
        }
        return resultMat;
    }

    public Matrix subMatrix(Matrix m2) throws  MatrixException{
        Matrix resultMat = new Matrix(this.getRows(), m2.getColumns());
        if(!this.CheckBySize(m2)){
            throw new MatrixException("Matrices have different size, u can't subtract it");
        }
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                resultMat.setByIndex(i,j, this.getByIndex(i,j) - m2.getByIndex(i,j));
            }
        }
        return resultMat;
    }

    public Matrix multMatrix(Matrix m2) throws MatrixException{
        Matrix resultMat = new Matrix(m2.getRows(), m2.getColumns());
        if(!this.CheckForMultiply(m2)){
            throw new MatrixException("U can't multiply this matrices");
        }
        for(int i = 0; i < this.matrix.length; i++) {
            for(int j = 0; j < m2.getColumns(); j++) {
                for(int k = 0; k < this.getColumns(); k++) {
                    resultMat.matrix[i][j] += this.matrix[i][k] * m2.matrix[k][j];
                }
            }
        }
        return resultMat;
    }
}
