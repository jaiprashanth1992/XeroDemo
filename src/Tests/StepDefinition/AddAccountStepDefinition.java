package Tests.StepDefinition;

import Tests.HelperClass.addAccount;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class AddAccountStepDefinition {
    WebDriver driver;
    addAccount account = new addAccount();

    @Given("^i am a Xero user and i am able to enter my login details$")
    public void i_am_a_Xero_user_and_i_am_able_to_enter_my_login_details() throws Throwable {
        driver = account.loginInApplication();
    }

    @When("^my TwoFA authentication is verified and successful login$")
    public void my_TwoFA_authentication_is_verified_and_successful_login() throws Throwable {
        account.validateAuthentication(this.driver);
    }

    @Then("^i should be able to create a new trial Organisation$")
    public void i_should_be_able_to_create_a_new_trial_Organisation() throws Throwable {
        account.addOrgnisation(this.driver);
    }

    @Then("^i should be able to add my ANZ\\(NZ\\) account in the Xero Orgnaisation$")
    public void i_should_be_able_to_add_my_ANZ_NZ_account_in_the_Xero_Orgnaisation() throws Throwable {
        account.addAcct(this.driver);
    }

    @And("^i am able close the browser$")
    public void i_am_able_close_the_browser() throws Throwable {
        account.logout(this.driver);
    }
}
