package videostore;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class VideoStoreTest {
    @Test
    public void approveCustomerStatement() {
        Integer[] priceCodeChoices = {Movie.REGULAR, Movie.NEW_RELEASE, Movie.CHILDRENS, 3};
        Integer[] daysRentedChoices = {1, 2, 3, 5};

        CombinationApprovals.verifyAllCombinations(this::createStatement, priceCodeChoices, daysRentedChoices);
    }

    private String createStatement(int priceCode, int daysRented) {
        Customer customer = new Customer("Steve") {
            @Override
            protected List<Rental> getRentals() {
                Rental starWars = new Rental(new Movie("Star Wars", priceCode), daysRented);
                Rental raidersOfTheLostArk = new Rental(new Movie("Raiders of the Lost Ark", Movie.REGULAR), 1);
                return Arrays.asList(starWars, raidersOfTheLostArk);
            }
        };
        return customer.statement();
    }
}
