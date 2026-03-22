import java.util.Random;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //testBinarySearch();
        //testSelectionSort();
        //testMergeSort();
        //testCountingSort();
        //testKadane();
        //testKMP();
        //testEuclid();
        //testMatrix();
        testDFS();
    }

    public static void testBinarySearch() {

        int[] warmupArray = createSortedArray(10000);
        for (int j = 0; j < 10000; j++) {
            BinarySearch.search(warmupArray, -1);
        }

        int[] sizes = {10000, 20000, 40000, 80000, 100000};
        System.out.println("БІНАРНИЙ ПОШУК");
        System.out.println("Розмір N, Кращий час (нс), Середній час (нс), Гірший час (нс)");
        int repeats = 10000;

        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];
            int[] array = createSortedArray(size);

            int targetBest = array[size / 2];
            long startBest = System.nanoTime();
            for (int k = 0; k < repeats; k++) {
                BinarySearch.search(array, targetBest);
            }
            long timeBest = (System.nanoTime() - startBest) / repeats;

            int targetAverage = array[size / 4];
            long startAverage = System.nanoTime();
            for (int k = 0; k < repeats; k++) {
                BinarySearch.search(array, targetAverage);
            }
            long timeAverage = (System.nanoTime() - startAverage) / repeats;

            int targetWorst = -1;
            long startWorst = System.nanoTime();
            for (int k = 0; k < repeats; k++) {
                BinarySearch.search(array, targetWorst);
            }
            long timeWorst = (System.nanoTime() - startWorst) / repeats;

            System.out.println(size + ", " + timeBest + ", " + timeAverage + ", " + timeWorst);
        }
    }

    public static void testSelectionSort() {
        int[] sizes = {10000, 20000, 40000, 80000, 100000};
        System.out.println("СОРТУВАННЯ ВИБОРОМ");
        System.out.println("Розмір N, Кращий час (нс), Середній час(нс), Гірший час(нс)");

        for (int size : sizes) {
            int[] arrBest = createSortedArray(size);
            long startBest = System.nanoTime();
            SelectionSort.sort(arrBest);
            long timeBest = System.nanoTime() - startBest;

            int[] arrAverage = createRandomArray(size);
            long startAverage = System.nanoTime();
            SelectionSort.sort(arrAverage);
            long timeAverage = System.nanoTime() - startAverage;

            int[] arrWorst = createReversedArray(size);
            long startWorst = System.nanoTime();
            SelectionSort.sort(arrWorst);
            long timeWorst = System.nanoTime() - startWorst;

            System.out.println(size + ", " + timeBest + ", " + timeAverage + ", " + timeWorst);
        }
    }
    public static void testMergeSort() {
        int[] sizes = {10000, 20000, 40000, 80000, 100000};
        System.out.println("СОРТУВАННЯ ЗЛИТТЯМ");
        System.out.println("Розмір N, Кращий час (нс), Середній час(нс), Гірший час(нс)");

        for (int size : sizes) {
            int[] arrBest = createSortedArray(size);
            long startBest = System.nanoTime();
            MergeSort.sort(arrBest);
            long timeBest = System.nanoTime() - startBest;

            int[] arrAverage = createRandomArray(size);
            long startAverage = System.nanoTime();
            MergeSort.sort(arrAverage);
            long timeAverage = System.nanoTime() - startAverage;

            int[] arrWorst = createReversedArray(size);
            long startWorst = System.nanoTime();
            MergeSort.sort(arrWorst);
            long timeWorst = System.nanoTime() - startWorst;

            System.out.println(size + ", " + timeBest + ", " + timeAverage + ", " + timeWorst);
        }
    }
    public static void testCountingSort() {
        int[] sizes = {10000, 20000, 40000, 80000, 100000};
        System.out.println("СОРТУВАННЯ ПІДРАХУНКОМ");
        System.out.println("Розмір N, Кращий час (нс), Середній час(нс), Гірший час(нс)");

        for (int size : sizes) {
            int[] arrBest = createSortedArray(size);
            long startBest = System.nanoTime();
            CountingSort.sort(arrBest);
            long timeBest = System.nanoTime() - startBest;

            int[] arrAverage = createRandomArray(size);
            long startAverage = System.nanoTime();
            CountingSort.sort(arrAverage);
            long timeAverage = System.nanoTime() - startAverage;

            int[] arrWorst = createReversedArray(size);
            long startWorst = System.nanoTime();
            CountingSort.sort(arrWorst);
            long timeWorst = System.nanoTime() - startWorst;

            System.out.println(size + ", " + timeBest + ", " + timeAverage + ", " + timeWorst);
        }
    }
    public static void testKadane() {
        int[] sizes = {10000, 20000, 40000, 80000, 100000};
        System.out.println("АЛГОРИТМ КАДАНЕ");
        System.out.println("Розмір N, Кращий час (нс), Середній час (нс), Гірший час (нс)");

        for (int size : sizes) {

            int[] arrBest = createSortedArray(size);
            long startBest = System.nanoTime();
            Kadane.findMax(arrBest);
            long timeBest = System.nanoTime() - startBest;


            int[] arrAverage = createRandomArray(size);
            long startAverage = System.nanoTime();
            Kadane.findMax(arrAverage);
            long timeAverage = System.nanoTime() - startAverage;


            int[] arrWorst = createReversedArray(size);
            long startWorst = System.nanoTime();
            Kadane.findMax(arrWorst);
            long timeWorst = System.nanoTime() - startWorst;

            System.out.println(size + ", " + timeBest + ", " + timeAverage + ", " + timeWorst);
        }
    }

    public static void testKMP() {
        int[] sizes = {10000, 20000, 40000, 80000, 100000};
        System.out.println(" АЛГОРИТМ KMP ");
        System.out.println("Розмір N, Кращий час (нс), Середній час (нс), Гірший час (нс)");
        int repeats = 1000;

        for (int size : sizes) {

            String textBest = "B" + createString(size - 1, 'A');
            String patternBest = "B";

            long startBest = System.nanoTime();
            for(int k = 0; k < repeats; k++) KMP.search(textBest, patternBest);
            long timeBest = (System.nanoTime() - startBest) / repeats;

            String textAverage = createRandomString(size);
            String patternAverage = "XYZ123";

            long startAverage = System.nanoTime();
            for(int k = 0; k < repeats; k++) KMP.search(textAverage, patternAverage);
            long timeAverage = (System.nanoTime() - startAverage) / repeats;

            String textWorst = createString(size, 'A');
            String patternWorst = createString(size / 10, 'A') + "B";

            long startWorst = System.nanoTime();
            for(int k = 0; k < repeats; k++) KMP.search(textWorst, patternWorst);
            long timeWorst = (System.nanoTime() - startWorst) / repeats;

            System.out.println(size + ", " + timeBest + ", " + timeAverage + ", " + timeWorst);
        }
    }

    public static void testEuclid(){
        System.out.println("АЛГОРИТМ ЕВКЛІДА");
        System.out.println("Число A, Число B, НСД, Час (нс)");
        int [][] testPairs = {
                {4181, 2584},
                {10946, 6765},
                {1836311903, 1134903170}
        };
        for (int [] pair : testPairs) {
            int a = pair[0];
            int b = pair[1];
            long start = System.nanoTime();
            int result = Euclid.findGCD(a, b);
            long time = System.nanoTime() - start;

            System.out.println(a + ", " + b + ", " + result + ", " + time);
        }
    }
    public static void testMatrix() {
        int[] sizes = {16, 32, 64, 128, 256};
        System.out.println("КЛАСИЧНЕ МНОЖЕННЯ МАТРИЦЬ");
        System.out.println("Розмір N, Час виконання (нс)");

        for (int size : sizes) {

            int[][] matrixA = createRandomMatrix(size);
            int[][] matrixB = createRandomMatrix(size);

            long start = System.nanoTime();
            Matrix.multiply(matrixA, matrixB);
            long time = System.nanoTime() - start;

            System.out.println(size + ","  + time);
        }
    }
    public static void testDFS() {
        int[] sizes = {10000, 20000, 40000, 80000, 100000};
        System.out.println("ОБХІД В ГЛИБИНУ (DFS)");
        System.out.println("Кількість вершин N, Час виконання (нс)");

        for (int size : sizes) {

            ArrayList<Integer>[] graph = createGraph(size);

            long start = System.nanoTime();
            GraphDFS.runDFS(graph, 0);
            long time = System.nanoTime() - start;

            System.out.println(size + ", " + time);
        }
    }

    public static ArrayList<Integer>[] createGraph(int numVertices) {
        ArrayList<Integer>[] graph = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < numVertices; i++) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            if (leftChild < numVertices) {
                graph[i].add(leftChild);
                graph[leftChild].add(i);
            }
            if (rightChild < numVertices) {
                graph[i].add(rightChild);
                graph[rightChild].add(i);
            }
        }
        return graph;
    }

    public static int[][] createRandomMatrix(int size) {
        int[][] matrix = new int[size][size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }


    public static String createString(int size, char c) {
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) sb.append(c);
        return sb.toString();
    }

    public static String createRandomString(int size) {
        StringBuilder sb = new StringBuilder(size);
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            sb.append((char)('A' + rand.nextInt(26)));
        }
        return sb.toString();
    }
    public static int[] createSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i * 2;
        }
        return array;
    }

    public static int[] createRandomArray(int size) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size * 2);
        }
        return array;
    }

    public static int[] createReversedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (size - i) * 2;
        }
        return array;
    }
}

