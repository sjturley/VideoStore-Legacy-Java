package videostore;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VideoStoreTest {
    @Test
    public void approveCustomerStatement() {
        Customer customer = new Customer("Steve") {
            @Override
            protected List<Rental> getRentals() {
                return Arrays.asList(new Rental(new Movie("Star Wars", Movie.REGULAR), 3));
            }
        };
        String statement = customer.statement();

        Approvals.verify(statement);
    }
}
