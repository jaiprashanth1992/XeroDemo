package Tests.StepDefinition;

import Tests.addAccount;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class AddAccountStepDefinition {
    WebDriver driver;
    addAccount account = new addAccount();

    @Given("^User Login in System$")
    public void user_Login_in_System() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       driver= account.loginInApplication();
    }

    @When("^Perform Authentication Operation$")
    public void perform_Authentication_Operation() throws Throwable {
        account.validateAuthentication(this.driver);
        
    }

    @When("^Create new Organisation$")
    public void create_new_Organisation() throws Throwable {

        account.addOrgnisation(this.driver);
    }

    @Then("^Add Account in orgnaisation$")
    public void add_Account_in_orgnaisation() throws Throwable {

        account.addAccount(this.driver);
    }

    @Then("^Close the browser$")
    public void close_the_browser() throws Throwable {

        account.logout(this.driver);
    }


}
