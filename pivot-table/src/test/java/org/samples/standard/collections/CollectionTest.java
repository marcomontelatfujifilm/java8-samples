package org.samples.standard.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mmontel
 */
public class CollectionTest {
    
    private static List<Row> rows;
    
    public CollectionTest() {
    }
    
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
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test() {
        
        //Whant to collect Rows where price > 14
        Stream<Row> filterByPrice = rows.stream().filter(new Predicate<Row>() {
            @Override
            public boolean test(Row t) {
                return t.getPrice() > 14;
            }
        });

        //Because Predicare is a Functional interface we can use lambda
        filterByPrice = rows.stream().filter((Row t) -> t.getPrice() > 14);        
        
        //In order to process the stream I define a Consumer
        filterByPrice.forEach(new Consumer<Row>() {
            @Override
            public void accept(Row t) {
                System.out.println(t);
            }
        });

        //And because Consumer is a Functional Interface we can use lambda
        filterByPrice.forEach((Row t) -> {
            System.out.println(t);
        });

        //One liner
        rows.stream().filter((Row t) -> t.getPrice() > 14).forEach((Row t) -> { System.out.print(t); });


    }
    
    @Test
    public void testParallelProcessing() {
        
    }
    
    @Test
    public void testCollectors() {

        rows.stream().map(new Function<Row, String>() {
            @Override
            public String apply(Row t) {
                return t.getProduct();
            }
        });
        
        //Or using lambda
        rows.stream().map((Row t) -> t.getProduct());
        
        
    }
}
