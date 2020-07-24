package videostore;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class VideoStoreTest {
    @Test
    public void approveCustomerStatement() {
        Integer[] priceCodeChoices = {Movie.REGULAR};
        Integer[] daysRentedChoices = {3};

        CombinationApprovals.verifyAllCombinations(this::createStatement, priceCodeChoices, daysRentedChoices);
    }

    private String createStatement(int priceCode, int daysRented) {
        Customer customer = new Customer("Steve") {
            @Override
            protected List<Rental> getRentals() {
                return Arrays.asList(new Rental(new Movie("Star Wars", priceCode), daysRented));
            }
        };
        return customer.statement();
    }
}
