package in.hp.java.boot.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveData() {
        return new int[]{1, 2, 3};
    }
}

public class SomeBusinessStubImplTest {

    private SomeBusinessImpl someBusiness;

    @Before
    public void initialize() {
        this.someBusiness = new SomeBusinessImpl();

        // common way of stubbing
        this.someBusiness.setSomeDataService(new SomeDataServiceStub());

        /**
         * Stubbing the interface using anonymous inner class
         */
        /*this.someBusiness.setSomeDataService(new SomeDataService() {
            @Override
            public int[] retrieveData() {
                return new int[]{1, 2, 3};
            }
        });*/

    }

    @Test
    public void calculateSumUsingDataService() {
        int actualResult = someBusiness.calculateSumUsingDataService();
        int expectedResult = 6;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_withOneValue() {
        int actualResult = someBusiness.calculateSumUsingDataService();
        int expectedResult = 1;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_withNoValue() {
        int actualResult = someBusiness.calculateSumUsingDataService();
        int expectedResult = 0;
        Assert.assertEquals(expectedResult, actualResult);
    }

}