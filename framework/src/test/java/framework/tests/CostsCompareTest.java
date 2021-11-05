package framework.tests;

import framework.pages.tempMail.EmailPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CostsCompareTest extends AbstractTest {
    private EmailPage emailPage;


    @BeforeClass(alwaysRun = true)
    public void sendEmailWithPricingToRandomEmailAddress() {
        emailPage = calculatorResultsPage.createNewEmailTab()
                .openPage()
                .clickButtonToCopyRandomEmailAddressToClipboard();
        emailPage.switchToResultsPage();
        calculatorResultsPage.clickEmailEstimateButton()
                .insertEmailAddressFromClipboardToInputField()
                .clickEmailSendButton();
        calculatorResultsPage.SwitchToEmailTab();
        emailPage.openMailFromGoogleCalculatorAndScrollToCost();
    }

    @Test(description = "Compare the cost received from the website and from the letter")
    public void compareTotalCost() {
        Assert.assertEquals(costFromGoogleCalculator, emailPage.getTotalCost(), "Cost values are not equal");
    }
}
