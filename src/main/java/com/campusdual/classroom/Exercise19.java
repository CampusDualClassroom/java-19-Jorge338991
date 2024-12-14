package com.campusdual.classroom;

import java.lang.reflect.Array;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    //TODO
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int rowsArrayBi= intArrayTri[0].length;
        int columnsArrayBi= intArrayTri[0][0].length;
        int[][] arrayResultante = new int[rowsArrayBi][columnsArrayBi];

        for (int i = 0; i < intArrayTri.length; i++) {
            for (int j = 0; j < intArrayTri[i].length; j++) {
                for (int k = 0; k < intArrayTri[i][j].length; k++) {
                    arrayResultante[j][k] += intArrayTri[i][j][k];
                }
            }
        }
        return arrayResultante;
    }



    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for (int i = 0; i < intArrayBi.length; i++) {
            for (int j = 0; j < intArrayBi[i].length; j++) {
                if (((intArrayBi.length - 1) == i) && (intArrayBi[i].length - 1 == j)) {
                    //System.out.println("la i+" + i + "la j" + j);
                    sb.append(intArrayBi[i][j]);
                    System.out.println("intArrayBi[" + i + "][" + j + "]=" + intArrayBi[i][j]);
                    break;
                }
                if((intArrayBi[i].length-1) == j){
                    sb.append(intArrayBi[i][j] + "\n");
                } else {
                    sb.append(intArrayBi[i][j] + " ");
                    //System.out.println("intArrayTri[" + i + "][" + j + "][" + k + "]=" + intArrayTri[i][j][k]);
                }
                ////sb.append(intArrayBi[i][j] + " ");
                //System.out.println("intArrayBi[" + i + "][" + j + "]=" + intArrayBi[i][j]);

            }

        }
        return sb.toString();
    }


    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for (int i = 0; i < uniArray.length; i++) {
            if ((uniArray.length - 1) == i) {
                sb.append(uniArray[i]);
                System.out.println("uniArray[" + i + "]=" + uniArray[i]);
                break;
            }
            sb.append(uniArray[i] + " ");
            System.out.println("uniArray[" + i + "]=" + uniArray[i]);
        }
        return sb.toString();
    }


    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int contador = 1;
        int[] arrayUniDimensional = new int[columns];
        for (int i = 0; i < arrayUniDimensional.length; i++) {
            arrayUniDimensional[i] = contador++;
        }
        return arrayUniDimensional;
    }


    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int contador = 1;
        int[][] arrayBiDimensional = new int[rows][columns];
        for (int i = 0; i < arrayBiDimensional.length; i++) {
            for (int j = 0; j < arrayBiDimensional[i].length; j++) {
                arrayBiDimensional[i][j] = contador++;
                //System.out.println(arrayBiDimensional[i][j] + " = "+ contador + " contador");
            }
        }
        return arrayBiDimensional;
    }


    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int contador = 1;
        int[][][] arrayTriDimensional = new int[depth][rows][columns];
        for (int i = 0; i < arrayTriDimensional.length; i++) {
            for (int j = 0; j < arrayTriDimensional[i].length; j++) {
                for (int k = 0; k < arrayTriDimensional[i][j].length; k++) {
                    arrayTriDimensional[i][j][k] = contador++;
                    //System.out.println("arrayTri[" + i + "][" + j + "]" + k + "]=" + arrayTriDimensional[i][j][k]);
                }
            }
        }

        return arrayTriDimensional;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
