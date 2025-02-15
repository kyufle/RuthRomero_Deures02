package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercici0201 {

    public static Scanner scanner;
    public static Locale defaultLocale;

    public static void main(String[] args) {
        
        scanner = new Scanner(System.in);
        defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);
        
        int[] arrEnters = generaArrayEnters(10);
        mostraArrayEstadistiques(arrEnters);

        ArrayList<Integer> lstEnters = generaLlistaEnters(10);
        mostraLlistaEstadistiques(lstEnters);

        filtraArrayParaulesAmbA();
        filtraLlistaParaulesAmbA();

        double[] arrDecimals = generaArrayDecimals(15);
        filtraArrayDecimalsSuperiors50(arrDecimals);

        ArrayList<Double> lstDecimals = generaLlistaDecimals(15);
        filtraLlistaDecimalsSuperiors50(lstDecimals);

        HashMap<String, Integer> persones = new HashMap<>();
        persones.put("Anna", 25);
        persones.put("Joan", 30);
        persones.put("Marc", 20);
        mostrarLlistaOrdenadesPerEdat(persones);

        mostrarFrecuenciaParaules();
        invertirMapaClauValor();
        fusionarMapesSumantValors();
        ordenarMapaPerClaus();
        calcularEstadistiquesNotesEstudiants();

        Locale.setDefault(defaultLocale);
        scanner.close();
    }

    /**
     * Genera un array d'enters aleatoris.
     *
     * @param mida la mida de l'array a generar
     * @return un array d'enters amb valors entre 0 i 99
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testGeneraArrayEnters
     */
    public static int[] generaArrayEnters(int mida) {
        int[] rst = new int[mida];
        Random random = new Random();
        for (int i = 0; i<mida;i++){
            int numRandom = random.nextInt(100);
            rst[i] = numRandom;
        }
        return rst;
    }

    /**
     * Calcula i mostra estadístiques d'un array d'enters.
     * 
     * Imprimeix per pantalla l'array, el valor màxim, el mínim i la mitjana.
     * Format d'output:
     * "Array: [valors]"
     * "Màxim: X  Mínim: Y  Mitjana: Z"
     *
     * @param array l'array d'enters sobre el qual calcular les estadístiques
     * @test ./runTest.sh com.exercicis.TestExercici0201#testMostraArrayEstadistiques
     */
    //REVISAR ERROR TEST (pero funciona)
    public static void mostraArrayEstadistiques(int[] array) {
        int sum = 0;
        int numMax = array[0];
        int numMin = array[0];
        List<String> numerosList = new ArrayList<>();
        for (Integer num : array){
            if (num>numMax){
                numMax = num;
            }
            if (num<numMin){
                numMin = num;
            }
            sum += num;
            numerosList.add(num.toString());
        }
        double mitjana = sum / array.length;

        System.out.println("Array: "+"["+String.join(", ", numerosList)+"]");
        System.out.println("Màxim: "+numMax+"  Mínim: "+numMin+"  Mitjana: "+mitjana);
    }

    /**
     * Genera una llista d'enters aleatoris.
     *
     * @param mida la mida de la llista a generar
     * @return una ArrayList d'enters amb valors entre 0 i 99
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testGeneraLlistaEnters
     */
    public static ArrayList<Integer> generaLlistaEnters(int mida) {
        ArrayList<Integer> rst = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i<mida;i++){
            int numSencerRandom = random.nextInt(99);
            rst.add(numSencerRandom);
        }
        return rst;
    }

    /**
     * Calcula i mostra estadístiques d'una llista d'enters.
     * 
     * Imprimeix per pantalla la llista, el valor màxim, el mínim i la mitjana.
     * Format d'output:
     * "Llista: [valors]"
     * "Màxim: X  Mínim: Y  Mitjana: Z"
     * 
     *
     * @param llista la llista d'enters sobre la qual calcular les estadístiques
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testMostraLlistaEstadistiques
     */
    public static void mostraLlistaEstadistiques(ArrayList<Integer> llista) {
        Integer sum = 0;
        for (Integer numsLlista : llista){
            sum += numsLlista;
        }
        double mitjana = sum / llista.size();
        System.out.println("Llista: "+llista);
        System.out.println("Màxim: "+Collections.max(llista)+"  Mínim: "+Collections.min(llista)+"  Mitjana: "+mitjana);


    }

    /**
     * Demana a l'usuari que escrigui 5 paraules separades per ',' o ', ' 
     * i mostra aquelles que comencen amb 'a'.
     * 
     * Guarda la llista en un "String[] paraules"
     * 
     * Es mostra per pantalla:
     * "Escriu 5 paraules separades per ',' o ', ':" per sol·licitar les entrades,
     * i després "Paraules que comencen amb 'a':" seguit de les paraules filtrades.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFiltraArrayParaulesAmbA
     */
    //TODO REVISAR
    public static void filtraArrayParaulesAmbA() {
        System.out.print("Escriu 5 paraules separades per ',' o ', ':");
        String paraula = scanner.nextLine();
        String[] paraules = paraula.split(",\\s*");
        String[] paraulaComencaAmbA = new String[paraules.length];
        int count = 0;
        for (int i= 0; i<paraules.length;i++){
            if (paraules[i].toLowerCase().startsWith("a")){
                paraulaComencaAmbA[count] = paraules[i];
                count++;
            }
        }
        String[] resultatFinal = Arrays.copyOf(paraulaComencaAmbA, count);
        String llistaFinal = String.join(", ",resultatFinal);
        System.out.println("Paraules que comencen amb 'a': "+llistaFinal);

    }
       
    /**
     * Demana a l'usuari que escrigui 5 paraules separades per ',' o ', ' 
     * i mostra aquelles que comencen amb 'a' en una sola línia separades per ", ".
     * 
     * Guarda la llista en un "ArrayList<String> paraules".
     * 
     * Es mostra per pantalla:
     * "Escriu 5 paraules separades per ',' o ', ':" per sol·licitar les entrades,
     * i després "Paraules que comencen amb 'a':" seguit de les paraules filtrades.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFiltraLlistaParaulesAmbA
     */
    //TODO REVISAR
    public static void filtraLlistaParaulesAmbA() {
        ArrayList<String> paraules = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriu 5 paraules separades per ',' o ', ':");
        String paraula = scanner.nextLine();
        String[] llistaParaula = paraula.split(",\\s*");
        for (String paraulaSeparada : llistaParaula){
            if(paraulaSeparada.startsWith("a") || paraulaSeparada.startsWith("A")){
                paraules.add(paraulaSeparada);
            }
        }
        String paraulesAmbComes = String.join(", ",paraules);
        System.out.println("Paraules que comencen amb 'a': "+paraulesAmbComes);
        
       
    }

    /**
     * Genera un array de decimals aleatoris.
     *
     * @param mida la mida de l'array a generar
     * @return un array de decimals amb valors entre 0.0 i 100.0
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testGeneraArrayDecimals
     */
    public static double[] generaArrayDecimals(int mida) {
        double[] rst = new double[mida];
        Random numsRandom = new Random();
        for (int i = 0;i<mida;i++){
            double randomNums = numsRandom.nextDouble()*100.0;
            rst[i] = randomNums;
        }
        return rst;
    }

    /**
     * Genera una llista de decimals aleatoris.
     *
     * @param mida la mida de la llista a generar
     * @return una ArrayList de decimals amb valors entre 0.0 i 100.0
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFiltraArrayDecimalsSuperiors50
     */

    //TODO no funciona
    public static ArrayList<Double> generaLlistaDecimals(int mida) {
        ArrayList<Double> rst = new ArrayList<>();
        Random randomRang = new Random();
        for (int i = 0; i<mida;i++){
            double numsRandom = randomRang.nextDouble() * 100.0;
            rst.add(numsRandom);
        }
        return rst;
    }

    /**
     * Filtra i mostra els decimals superiors a 50 d'un array.
     * 
     * Imprimeix per pantalla l'array original de decimals i, a continuació,
     * la llista dels decimals que són majors que 50.
     * Format d'output:
     * "Array original: [valors]"
     * "Valors majors que 50: [valors filtrats]"
     * 
     *
     * @param decimals l'array de decimals a filtrar
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testGeneraLlistaDecimals
     */
    public static void filtraArrayDecimalsSuperiors50(double[] decimals) {
        List<Double> numsMayorsDeCincuanta = new ArrayList<>();
        List<Double> decimalsOriginal = new ArrayList<>();
        for (int i = 0; i<decimals.length;i++){
            if(decimals[i] > 50.0){
                numsMayorsDeCincuanta.add(decimals[i]);
            }
            decimalsOriginal.add(decimals[i]);
        }
        System.out.println("Array original: ["+String.join(", ",decimalsOriginal.toString())+"]");
        System.out.println("Valors majors que 50: ["+String.join(", ",numsMayorsDeCincuanta.toString())+"]");
    }   

    /**
     * Filtra i mostra els decimals superiors a 50 d'una llista.
     * 
     * Imprimeix per pantalla la llista original de decimals i, a continuació,
     * la llista dels decimals que són majors que 50.
     * Format d'output:
     * "Llista original: [valors]"
     * "Valors majors que 50: [valors filtrats]"
     *
     * @param decimals la llista de decimals a filtrar
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFiltraLlistaDecimalsSuperiors50
     */
    //TODO REVISAR 0 DEL FINAL
    public static void filtraLlistaDecimalsSuperiors50(ArrayList<Double> decimals) {
        List<Double> nombresDecimalsMesGransQueCincuanta = new ArrayList<>();
        for (double num : decimals){
            if (num>50.0){
                nombresDecimalsMesGransQueCincuanta.add(num);
            }
        }
        System.out.println("Llista original: "+decimals);
        System.out.println("Valors majors que 50: ["+String.join(", ",nombresDecimalsMesGransQueCincuanta.toString())+"]");
    }
    
    /**
     * Mostra per pantalla les persones ordenades per edat.
     * 
     * Recorre un HashMap de persones (nom i edat) i imprimeix cada persona en format "Nom (Edat)"
     * ordenat per edat de manera ascendent.
     *
     * @param persones un HashMap on la clau és el nom de la persona i el valor és la seva edat
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testMostrarLlistaOrdenadesPerEdat
     */
    public static void mostrarLlistaOrdenadesPerEdat(HashMap<String, Integer> persones) {

    }

    /**
     * Demana a l'usuari que introdueixi una frase i mostra la freqüència de cada paraula.
     * 
     * L'usuari escriu una frase per la consola i el mètode separa les paraules usant els espais.
     * A continuació, es calcula la freqüència de cada paraula i es mostra per pantalla en format de HashMap.
     * 
     * 
     * Es mostra per pantalla:
     * "Introdueix una frase:" i després "Freqüència de paraules: {paraula=frequencia, ...}".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testMostrarFrecuenciaParaules
     */
    public static void mostrarFrecuenciaParaules() {
        System.out.print("Introdueix una frase:");

    }

    /**
     * Inverteix un HashMap intercanviant claus i valors.
     * 
     * Es crea un HashMap amb elements (A=1, B=2, C=3) i es construeix un nou HashMap on cada valor 
     * es converteix en clau i cada clau es converteix en valor.
     * 
     * 
     * Es mostra per pantalla:
     * "Mapa original: {A=1, B=2, C=3}" i "Mapa invertit: {1=A, 2=B, 3=C}".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testInvertirMapaClauValor
     */
    public static void invertirMapaClauValor() {
        HashMap<String,Integer> mapaOriginal = new HashMap<>();
        mapaOriginal.put("A", 1);
        mapaOriginal.put("B", 2);
        mapaOriginal.put("C", 3);

        HashMap<Integer,String> mapaInvertit = new HashMap<>();
        for (Map.Entry<String, Integer> clauValor : mapaOriginal.entrySet()) {
            mapaInvertit.put(clauValor.getValue(), clauValor.getKey());
        }
        System.out.println("Mapa original: " + mapaOriginal);
        System.out.println("Mapa invertit: " + mapaInvertit);


    }

    /**
     * Fusiona dos HashMap sumant els valors de les claus comuns.
     * 
     * Es defineixen dos mapes:
     * <ul>
     *   <li>Mapa 1: {X=10, Y=20}</li>
     *   <li>Mapa 2: {Y=5, Z=15}</li>
     * </ul>
     * El mètode crea un nou HashMap on, per cada clau existent en ambdós mapes, es suma el valor.
     * 
     * 
     * Es mostra per pantalla:
     * "Mapa fusionat: {X=10, Y=25, Z=15}".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFusionarMapesSumantValors
     */
    public static void fusionarMapesSumantValors() {
        HashMap<String,Integer> mapa1 = new HashMap<>();
        mapa1.put("X",10);
        mapa1.put("Y",20);
        HashMap<String,Integer> mapa2 = new HashMap<>();
        mapa2.put("Y",5);
        mapa2.put("Z",15);

        HashMap<String,Integer> fusionat = new HashMap<>(mapa1);
        for (Map.Entry<String, Integer> e : mapa2.entrySet()) {
            fusionat.put(e.getKey(), fusionat.getOrDefault(e.getKey(), 0) + e.getValue());
        }
        System.out.println("Mapa fusionat: " + fusionat);

    }

    /**
     * Ordena un HashMap per les claus mitjançant un TreeMap i mostra el resultat.
     * 
     * Es crea un HashMap amb elements (Banana=3, Poma=5, Taronja=2) i es transfereix a un TreeMap
     * per obtenir un ordre natural de les claus (alfabètic).
     * 
     * 
     * Es mostra per pantalla:
     * "Mapa ordenat per claus: {Banana=3, Poma=5, Taronja=2}".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testOrdenarMapaPerClaus
     */
    public static void ordenarMapaPerClaus() {
        HashMap<String, Integer> mapa = new HashMap<>();
        mapa.put("Banana", 3);
        mapa.put("Poma", 5);
        mapa.put("Taronja", 2);
        TreeMap<String, Integer> ordenat = new TreeMap<>(mapa);
        System.out.println("Mapa ordenat per claus: " + ordenat);
    }

    /**
     * Calcula i mostra les estadístiques (mitjana, màxim i mínim) de les notes dels estudiants.
     * 
     * Es defineix un HashMap on la clau és el nom de l'estudiant i el valor la seva nota.
     * El mètode calcula la mitjana, la nota màxima i la nota mínima i les mostra per pantalla.
     * 
     * 
     * Es mostra per pantalla:
     * "Mitjana: [valor], Màxim: [valor], Mínim: [valor]".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testCalcularEstadistiquesNotesEstudiants
     */
    public static void calcularEstadistiquesNotesEstudiants() {

    }
}
