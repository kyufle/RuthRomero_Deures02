package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Exercici0200 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(addImaginaries("1+2i", "4+5i"));

        drawPascal(5);

        ArrayList<Double> list = new ArrayList<>(Arrays.asList(1.5, 2.3, 3.7));
        System.out.println(addList(list));

        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        printMatrix(matrixA);

        int[][] matrixB = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrixC = {
            {1,  2,  3,  4,  5}, 
            {6,  7,  8,  9, 10}, 
            {11, 12, 13, 14, 15}, 
            {16, 17, 18, 19, 20}
        };

        printMatrix(transpose(matrixB));
        printMatrix(transpose(matrixC));

        System.out.println(firstNonRepeated("swiss"));     // w
        System.out.println(firstNonRepeated("redivider")); // v
        System.out.println(firstNonRepeated("aabbcc"));    // _

        System.out.println(inverInt(3645)); 

        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(3, 6, 1, 5, 0));
        System.out.println(minMaxAdd(nums));

        System.out.println(sumaSenseSumar(5, 6) + ":" + sumaSenseSumar(-3, 3) + ":" + sumaSenseSumar(10, -4));

        System.out.println(minDistances("algoritmo", 'o'));
        System.out.println(minDistances("abcdefga", 'a'));

        System.out.println(findUniqueNumber(new ArrayList<>(Arrays.asList(2.0, 2.0, 1.0))));
        System.out.println(findUniqueNumber(new ArrayList<>(Arrays.asList(4.0, 1.0, 2.0, 1.0, 2.0))));

        scanner.close();
    }

    /**
     * Fes una funció que sumi números inmaginaris 
     * definits per una cadena de text
     * 
     *  "1+2i" + "4+5i" = "5+7i"
     * 
     * @param String el primer número imaginari
     * @param String el segon número imaginari
     * @return String el resultat de la suma
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddImaginariesSimple
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddImaginariesNegative
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddImaginariesZero
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddImaginariesWithZeroRealPart
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddImaginariesWithZeroImaginaryPart
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddImaginariesLargeNumbers
     */
     public static String addImaginaries(String num0, String num1) {
        Integer num01;
        Integer num02;
        Integer num11;
        Integer num12;


        if(!num0.contains("+")) {
            num01 = Integer.parseInt(num0.substring(0,num0.indexOf("-",1)));
            num02 = Integer.parseInt(num0.substring(num0.indexOf("-",1)+1,num0.indexOf("i")));
        } else {
            num01 = Integer.parseInt(num0.substring(0,num0.indexOf("+")));
            num02 = Integer.parseInt(num0.substring(num0.indexOf("+")+1,num0.indexOf("i")));
        }

        if(!num1.contains("+")) {
            num11 = Integer.parseInt(num1.substring(0,num1.indexOf("-",1)));
            num12 = Integer.parseInt(num1.substring(num1.indexOf("-",1),num1.indexOf("i")));
        } else {
            num11 = Integer.parseInt(num1.substring(0,num1.indexOf("+")));
            num12 = Integer.parseInt(num1.substring(num1.indexOf("+")+1,num1.indexOf("i")));
        }

        if ((num02+num12)>=0){
            return (num01+num11)+"+"+(num02+num12)+"i";
        }

        return ""+(num01+num11)+(num02+num12)+"i";
        
    }

    /**
     * Fes un programa que dibuixi el triangle de pascal
     * 
     * @param int nivells del triangle (0 fins a n)
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testDrawPascalZero
     * @test ./runTest.sh com.exercicis.TestExercici0200#testDrawPascalOne
     * @test ./runTest.sh com.exercicis.TestExercici0200#testDrawPascalTwo
     * @test ./runTest.sh com.exercicis.TestExercici0200#testDrawPascalThree
     * @test ./runTest.sh com.exercicis.TestExercici0200#testDrawPascalFive
     */
    public static void drawPascal(int n) {
        for (int i = 0; i < n; i++) {
            int num = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num = num * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    /**
     * Fes una funció que sumi els valors d'un ArrayList<double>
     * 
     * @param llista de valors
     * @return resultat de la suma
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddListEmpty
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddListSingleElement
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddListMultipleElements
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddListNegativeNumbers
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddListMixedNumbers
     * @test ./runTest.sh com.exercicis.TestExercici0200#testAddListDecimals
     */
    public static double addList(ArrayList<Double> list) {
        double sum = 0;
        for (double numDouble : list){
            sum += numDouble;
        }
        return sum;
    }

    /** 
     * Fes una funció que dibuixi els valors d'una matriu
     * int[][] entrada = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
     * 
     * @param int[][] matriu a dibuixar
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testPrintMatrixSingleElement
     * @test ./runTest.sh com.exercicis.TestExercici0200#testPrintMatrixRow
     * @test ./runTest.sh com.exercicis.TestExercici0200#testPrintMatrixColumn
     * @test ./runTest.sh com.exercicis.TestExercici0200#testPrintMatrixSquare
     * @test ./runTest.sh com.exercicis.TestExercici0200#testPrintMatrixRectangular
     * @test ./runTest.sh com.exercicis.TestExercici0200#testPrintMatrixEmpty
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i < row.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Fes una funció que retorni la trasposada d'una matriu
     * 
     * int[][] entrada = { {1, 2, 3}, {4, 5, 6} };
     * int[][] sortida = { {1, 4}, {2, 5}, {3, 6} };
     * 
     * int[][] entrada = { 
     *      {1,  2,  3,  4,  5}, 
     *      {6,  7,  8,  9, 10}, 
     *      {11, 12, 13, 14, 15}, 
     *      {16, 17, 18, 19, 20} };
     * 
     * int[][] sortida = { 
     *     {1, 6, 11, 16},
     *     {2, 7, 12, 17},
     *     {3, 8, 13, 18},
     *     {4, 9, 14, 19},
     *     {5, 10, 15, 20}
     * };
     * 
     * @param int[][] matriu a transposar
     * @return int[][] matriu transposada
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testTransposeSquareMatrix
     * @test ./runTest.sh com.exercicis.TestExercici0200#testTransposeRectangularMatrix
     * @test ./runTest.sh com.exercicis.TestExercici0200#testTransposeColumnMatrix
     * @test ./runTest.sh com.exercicis.TestExercici0200#testTransposeSingleElement
     */
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int transposedRows = cols;
        int transposedCols = rows;
        int[][] transposed = new int[transposedRows][transposedCols];

        for (int cntRow = 0; cntRow < rows; cntRow = cntRow + 1) {
            for (int cntCol = 0; cntCol < cols; cntCol = cntCol + 1) {
                transposed[cntCol][cntRow] = matrix[cntRow][cntCol];
            }
        }
        return transposed;
    }

    /**
     * Fes una funció que troba el primer caràcter que
     * no es repeteix dins d'una cadena de text
     * si totes les lletres es repeteixen torna '_'
     * 
     * Exemple: dead
     * 
     * Entrada: "swiss"
     * Sortida: 'w'
     * 
     * Entrada: "redivider"
     * Sortida: 'v'
     * 
     * @param String cadena de text
     * @return char primer caràcter que no es repeteix
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testFirstNonRepeatedBasic
     * @test ./runTest.sh com.exercicis.TestExercici0200#testFirstNonRepeatedAllRepeated
     * @test ./runTest.sh com.exercicis.TestExercici0200#testFirstNonRepeatedLongString
     */
    public static char firstNonRepeated(String str) {
        for (int i = 0; i < str.length(); i++) {
            
            String stringPartUn = str.substring(0, i);
            String stringPartDos = str.substring(i+1, str.length());
            String juntarDuesParts = stringPartUn+stringPartDos;

            if (!(juntarDuesParts.contains(String.valueOf(str.charAt(i))))){
                return str.charAt(i);
            };
            
        }
        return '_';
    }
            
            
                /**
     * Fes una funció que inverteixi els caràcters
     * d'un número enter: 3645 > 5463
     * 
     * @param int número a invertir
     * @return int número resultant
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testInverIntPositive
     * @test ./runTest.sh com.exercicis.TestExercici0200#testInverIntWithZeros
     * @test ./runTest.sh com.exercicis.TestExercici0200#testInverIntSingleDigit
     */
    public static int inverInt(int num) {
        String numString = String.valueOf(num);
        String numInv = "";
        for (int i = numString.length()-1; i>=0;i--){
            numInv += numString.charAt(i);
        }
        Integer numFinal = Integer.parseInt(numInv);
        return numFinal;
    }

    /**
     * Fes una funció que rebi una llista (`ArrayList`) amb 5 números
     * i calculi el número més petit i el número més gran
     * que es poden calcular sumant 4 dels 5 números rebuts.
     * 
     * Exemple:
     * 
     * Entrada: [3, 6, 1, 5, 0]
     * Sortida: [9, 15]
     * 
     * Explicació:
     *  9  = 0 + 1 + 3 + 5 (sumant els quatre números més petits)
     *  15 = 1 + 3 + 5 + 6 (sumant els quatre números més grans)
     * 
     * @param ArrayList<Integer> nums Llista de números d'entrada (exactament 5 números)
     * @return ArrayList<Integer> Llista amb els dos números de sortida [mínim, màxim]
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testMinMaxAddBasic
     * @test ./runTest.sh com.exercicis.TestExercici0200#testMinMaxAddWithNegatives
     * @test ./runTest.sh com.exercicis.TestExercici0200#testMinMaxAddWithDuplicates
     */
    public static ArrayList<Integer> minMaxAdd(ArrayList<Integer> nums) {
        ArrayList<Integer> rst = new ArrayList<>();
        int primerNumero = 0;
        int segonNumero = 0;
        Collections.sort(nums);
        for (int cnt = 0; cnt<nums.size()-1;cnt++){
            primerNumero += nums.get(cnt);
        }
        rst.add(primerNumero);
        Collections.reverse(nums);
        for (int cnt = 0; cnt<nums.size()-1;cnt++){
            segonNumero += nums.get(cnt);
        }
        rst.add(segonNumero);
        return rst;
    }

    /**
     * Fes una funció que sumi dos números sense fer servir 
     * la operació de suma.
     * 
     * Exemple:
     * 
     * Entrada: 5, 7
     * Sortida: 12
     * 
     * Entrada: -3, 3
     * Sortida: 0
     * 
     * @param int a Primer número a sumar
     * @param int b Segon número a sumar
     * @return int Resultat de la suma de a i b sense utilitzar l'operació de suma
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testSumaSenseSumarPositiveNumbers
     * @test ./runTest.sh com.exercicis.TestExercici0200#testSumaSenseSumarNegativeNumbers
     * @test ./runTest.sh com.exercicis.TestExercici0200#testSumaSenseSumarPositiveAndNegative
     * @test ./runTest.sh com.exercicis.TestExercici0200#testSumaSenseSumarZero
     * @test ./runTest.sh com.exercicis.TestExercici0200#testSumaSenseSumarLargeNumbers
     */
    public static int sumaSenseSumar(int a, int b) {
        int resultado = Math.addExact(a, b);
        return resultado;
    }

    /**
     * Fes una funció que retorni les distàncies mínimes
     * de cada lletra fins a un caràcter d'una cadena de text.
     * 
     * Exemple:
     * 
     * Entrada: "algoritmo", 'o'
     * Sortida: [3, 2, 1, 0, 1, 2, 2, 1, 0]
     * 
     * Entrada: "abcdefga", 'a'
     * Sortida: [0, 1, 2, 3, 3, 2, 1, 0]
     * 
     * @param String text Cadena de text d'entrada
     * @param char target Caràcter objectiu
     * @return ArrayList<Integer> Llista de distàncies mínimes de cada lletra fins al caràcter objectiu
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testMinDistancesBasic
     * @test ./runTest.sh com.exercicis.TestExercici0200#testMinDistancesMultipleTargets
     * @test ./runTest.sh com.exercicis.TestExercici0200#testMinDistancesNoTargetFound
     */
    public static ArrayList<Integer> minDistances(String text, char target) {
        ArrayList<Integer> dreta = new ArrayList<>();
        ArrayList<Integer> esquerra = new ArrayList<>();
        ArrayList<Integer> junts = new ArrayList<>();
        Integer cnt = 9000;
        for (int i = 0; i<text.length();i++){
            if (text.charAt(i) == target){
                cnt = 0;
            }
            else {
                cnt += 1;
            }
            dreta.add(cnt);
        }

        Integer cnt2 = 9000;
        for (int i = text.length()-1; i>=0;i--){
            if (text.charAt(i) == target){
                cnt2 = 0;
            }
            else {
                cnt2 += 1;
            }
            esquerra.add(cnt2);
        }
        Collections.reverse(esquerra);
        for (int i = 0; i<text.length();i++){
            if(esquerra.get(i)>=9000 && dreta.get(i)>=9000){
                junts.add(text.length());
            }

            else if(esquerra.get(i)>dreta.get(i)){
                junts.add(dreta.get(i));
            }
            else {
                junts.add(esquerra.get(i));
            }

        }
        return junts;
    }

    /**
     * A partir d'una llista de números on cada 
     * número es repeteix dos cops excepte un, troba
     * el número que no es repeteix.
     * 
     * Exemple:
     * 
     * Entrada: [2.0, 2.0, 1.0]
     * Sortida: 1.0
     * 
     * Entrada: [4.0, 1.0, 2.0, 1.0, 2.0]
     * Sortida: 4.0
     * 
     * @param ArrayList<Double> nums Llista de números d'entrada
     * @return Double Número que no es repeteix
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0200#testFindUniqueNumberBasic
     * @test ./runTest.sh com.exercicis.TestExercici0200#testFindUniqueNumberMultiplePairs
     * @test ./runTest.sh com.exercicis.TestExercici0200#testFindUniqueNumberNoUnique
     */
    public static Double findUniqueNumber(ArrayList<Double> nums) {
        for (Double num : nums){
            if (!(Collections.frequency(nums, num) == 2)){
                return num;
            }
        }
        return null;
    }
}
