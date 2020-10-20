package ru.dvtagin.gb.Exceptional;

import java.util.Arrays;

public class Exceptions {
   private static final String CORRECT_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
   private static final String NO_ROW_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1";
   private static final String NO_COL_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1";
   private static final String HAS_CHAR_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 A";

   private static final int MATRIX_ROWS = 4;
   private static final int MATRIX_COLS = 4;


   private static String [] [] stringToMatrix (String value) {

       String[] rows = value.split("\n");
       if (rows.length != MATRIX_ROWS)
           throw new RuntimeException("Incorrect ROW count " + rows.length + ":\n" + value);

       String [] [] result = new String[MATRIX_ROWS][];
       for (int i = 0; i < result.length; i++){
           result [i] = rows [i].split(" ");
           if (result[i].length != MATRIX_COLS)
               throw new RuntimeException("Incorrect COLUMNS count " + result[i].length + ":\n" + value);
       }
       return result;
   }

   private static int calcMatrix (String[][] matrix) {
       int result = 0;
       for (int i = 0; i < matrix.length; i++) {
           for (int j = 0; j < matrix[i].length; j++) {
               result += Integer.parseInt(matrix [i][j]);
           }
       }
       return result / 2;
   }

    public static void main(String[] args) {
        try {
            final String [] [] matrix = stringToMatrix(CORRECT_STRING);
      //      final String [] [] matrix = stringToMatrix(NO_ROW_STRING);
      //      final String [] [] matrix = stringToMatrix(NO_COL_STRING);
      //      final String [] [] matrix = stringToMatrix(HAS_CHAR_STRING);
            System.out.println(Arrays.deepToString(matrix));
            System.out.println("Half sum = " + calcMatrix (matrix));

        } catch (NumberFormatException e) {
            System.out.println("A NumberFormatException is thrown: " + e.getMessage());
        } catch (RuntimeException e) {
      //      throw new RuntimeException(e);
            System.out.println("A RunTimeException is thrown: " + e.getMessage());
        }
    }
}
