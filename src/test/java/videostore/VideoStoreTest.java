package videostore;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Test;

public class VideoStoreTest {
    @Test
    public void approveCustomerStatement() {
        Customer customer = new Customer("Steve");
        customer.statement();
    }
}
