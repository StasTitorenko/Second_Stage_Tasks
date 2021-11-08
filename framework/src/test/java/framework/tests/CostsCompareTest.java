package framework.tests;

import framework.pages.tempMail.EmailPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CostsCompareTest extends CommonConditions {
    private EmailPage emailPage;
    private String costFromGoogleCalculator;

    @BeforeMethod(alwaysRun = true)
    public void getTotalCostFromGoogleCalculator() {
        costFromGoogleCalculator = formatFields.formatTotalCost(calculatorResultsPage.getTotalCost());
    }

    @BeforeMethod(alwaysRun = true, dependsOnMethods = "getTotalCostFromGoogleCalculator")
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
        Assert.assertEquals(costFromGoogleCalculator,
                emailPage.getTotalCost(),
                "Cost values are not equal");
    }
}
