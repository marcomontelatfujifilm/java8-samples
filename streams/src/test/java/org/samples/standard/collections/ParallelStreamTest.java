package org.samples.standard.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mmontel
 */
public class ParallelStreamTest {
    private static List<Row> rows;
    
    @BeforeClass
    public static void setUpClass() {
        rows = new ArrayList<>();
        rows.add(new Row("East", "Boy", "Tee", 10, 12.00));
        rows.add(new Row("East", "Boy", "Golf", 15, 20.00));
        rows.add(new Row("East", "Girl", "Tee", 8, 14.00));
        rows.add(new Row("East", "Girl", "Golf", 20, 24.00));
        rows.add(new Row("West", "Boy", "Tee", 5, 12.00));
        rows.add(new Row("West", "Boy", "Golf", 12, 20.00));
        rows.add(new Row("West", "Girl", "Tee", 15, 14.00));
        rows.add(new Row("West", "Girl", "Golf", 10, 24.00));
    }
    
    @Test
    public void testParallel() {
        rows.parallelStream().forEach(new RowConsumer());
    }
    
    public class RowConsumer implements Consumer<Row> {

        @Override
        public void accept(Row t) {
            Thread.currentThread().getName();
            System.out.println("Row: " + t.toString() + " " + Thread.currentThread().getName());
        }
        
    }
}
