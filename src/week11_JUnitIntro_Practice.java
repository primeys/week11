import org.junit.*;

public class week11_JUnitIntro_Practice {

// JUnit Practice and Dependencies Add Hamcrest and JUnit


    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Executed before class......");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Executed after class......");
    }

    @Before
    public void setUp() {
        System.out.println("Executed before......");
    }

    @After
    public void tearDown() {
        System.out.println("Executed after ......");
    }

    @Test
    public void test1() {
        System.out.println("Executed Test1......");
    }

    @Test
    public void test2() {
        System.out.println("Executed Test2......");
    }

}
