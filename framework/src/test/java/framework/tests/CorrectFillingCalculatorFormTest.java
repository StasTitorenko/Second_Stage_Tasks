package framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CorrectFillingCalculatorFormTest extends CommonConditions {

    @Test(description = "Checking correctness of filling Tab")
    public void checkTabFilling() {
        Assert.assertEquals(calculatorResultsPage.getTab(),
                calculator.getTab().toString(),
                "Actual tab is not equal to Expected ");
    }

    @Test(description = "Checking correctness of filling Number of Instances")
    public void checkNumberOfInstancesFilling() {
        Assert.assertEquals(calculatorResultsPage.getNumberOfInstances(),
                formatFields.formatNumberOfInstances(calculator.getNumberOfInstances()),
                "Actual Number is not equal to Expected");
    }

    @Test(description = "Checking correctness of filling Operation System")
    public void checkOperationSystemFilling() {
        Assert.assertEquals(calculatorResultsPage.getOperationSystem(),
                formatFields.formatOperationSystem(calculator.getOperationSystem()),
                "Actual Operation System is not equal to Expected");
    }

    @Test(description = "Checking correctness of filling Machine Class")
    public void checkMachineClassFilling() {
        Assert.assertEquals(calculatorResultsPage.getMachineClass(),
                formatFields.formatMachineClass(calculator.getMachineClass()),
                "Actual Machine Class is not equal to Expected");
    }

    @Test(description = "Checking correctness of fillingMachine Type")
    public void checkMachineTypeFilling() {
        Assert.assertEquals(calculatorResultsPage.getMachineType(),
                formatFields.formatMachineType(calculator.getMachineType()),
                "Actual Machine Type is not equal to Expected");
    }

    @Test(description = "Checking correctness of filling GPU Number and Type")
    public void checkGPUTypeFilling() {
        Assert.assertEquals(calculatorResultsPage.getGPU(),
                formatFields.formatGPU(calculator.getNumberOfGPU(), calculator.getGpuType()),
                "Actual GPU is not equal to Expected");
    }

    @Test(description = "Checking correctness of filling SSD number")
    public void checkSSDNumberFilling() {
        Assert.assertEquals(calculatorResultsPage.getSSD(),
                formatFields.formatSSD(calculator.getNumberOfSSD()),
                "Actual SSD is not equal to Expected");
    }

    @Test(description = "Checking correctness of filling Data center")
    public void checkDataCenterFilling() {
        Assert.assertEquals(calculatorResultsPage.getDataCenter(),
                formatFields.formatDataCenter(calculator.getDataCenter()),
                "Actual Data Center is not equal to Expected");
    }

    @Test(description = "Checking correctness of filling Committed usage")
    public void checkCommittedUsageFilling() {
        Assert.assertEquals(calculatorResultsPage.getCommitmentUsage(),
                formatFields.formatCommittedUsage(calculator.getCommittedUsage()),
                "Actual Committed Usage is not equal to Expected");
    }
}
