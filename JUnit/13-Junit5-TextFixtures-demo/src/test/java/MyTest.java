import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyTest {
	 
    // This method runs once before any test method is executed
    @BeforeAll
    static void setup() {
        System.out.println("Executing global setup (BeforeAll)");
    }

    // This method runs before each test method is executed
    @BeforeEach
    void init() {
        System.out.println("Preparing for the test (BeforeEach)");
    }

    // This is the first test method
    @Test
    void demoTest() {
        System.out.println("Executing Test 1 (demoTest)");
    }

    // This is the second test method
    @Test
    void dummyTest() {
        System.out.println("Executing Test 2 (dummyTest)");
    }

    // This method runs after each test method is executed
    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up after the test (AfterEach)");
    }

    // This method runs once after all test methods are executed
    @AfterAll
    static void destroy() {
        System.out.println("Executing global teardown (AfterAll)");
    }
}
