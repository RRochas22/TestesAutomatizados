package steps;

import io.cucumber.java.Before;
import services.TestContext;

public class Hooks {

    @Before
    public void resetContexto() {
        TestContext.reset();
    }
}
