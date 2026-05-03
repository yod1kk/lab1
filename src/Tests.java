import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Tests {

    @Rule
    public TestRule benchmarkRun = new BenchmarkRule();

    private int[] randomArray;
    private int[] sortedArray;
    private String text;
    private String pattern;
    private int[][] matrixA;
    private int[][] matrixB;
    private ArrayList<Integer>[] graph;

    @Before
    public void setup() {
        int size = 100000; // Розмір масиву (100 тисяч для краш-тесту)
        randomArray = new Random().ints(size, 0, 5000).toArray();
        sortedArray = randomArray.clone();
        Arrays.sort(sortedArray);

        text = "a".repeat(10000) + "b";
        pattern = "aaab";

        int matrixSize = 200;
        matrixA = new int[matrixSize][matrixSize];
        matrixB = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            Arrays.fill(matrixA[i], 2);
            Arrays.fill(matrixB[i], 3);
        }

        int numNodes = 2000;
        graph = new ArrayList[numNodes];
        for (int i = 0; i < numNodes; i++) {
            graph[i] = new ArrayList<>();
            if (i < numNodes - 1) {
                graph[i].add(i + 1);
            }
        }
    }

    @BenchmarkOptions(benchmarkRounds = 10, warmupRounds = 5)
    @Test
    public void testBinarySearch() {
        BinarySearch.search(sortedArray, -1);
    }

    @BenchmarkOptions(benchmarkRounds = 10, warmupRounds = 5)
    @Test
    public void testKadane() {
        Kadane.findMax(randomArray);
    }

    @BenchmarkOptions(benchmarkRounds = 10, warmupRounds = 5)
    @Test
    public void testMergeSort() {
        int[] copy = randomArray.clone();
        MergeSort.sort(copy);
    }

    @BenchmarkOptions(benchmarkRounds = 10, warmupRounds = 5)
    @Test
    public void testCountingSort() {
        int[] copy = randomArray.clone();
        CountingSort.sort(copy);
    }

    @BenchmarkOptions(benchmarkRounds = 5, warmupRounds = 2)
    @Test
    public void testSelectionSort() {
        int[] copy = randomArray.clone();
        SelectionSort.sort(copy);
    }

    @BenchmarkOptions(benchmarkRounds = 10, warmupRounds = 5)
    @Test
    public void testKMP() {
        KMP.search(text, pattern);
    }

    @BenchmarkOptions(benchmarkRounds = 5, warmupRounds = 2)
    @Test
    public void testMatrixMultiply() {
        Matrix.multiply(matrixA, matrixB);
    }

    @BenchmarkOptions(benchmarkRounds = 10, warmupRounds = 5)
    @Test
    public void testGraphDFS() {
        GraphDFS.runDFS(graph, 0);
    }

    @BenchmarkOptions(benchmarkRounds = 10, warmupRounds = 5)
    @Test
    public void testEuclid() {
        for (int i = 0; i < 1000; i++) {
            Euclid.findGCD(123456789, 987654321);
        }
    }
}