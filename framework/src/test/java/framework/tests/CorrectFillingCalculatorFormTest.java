package framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CorrectFillingCalculatorFormTest extends CommonConditions {

    @Test(description = "Checking correctness of filling Tab")
    public void checkTabFilling() {
        Assert.assertEquals(calculatorResultsPage.getTab(),
                calculator.getTab().toString(),
                "Tabs are not equal");
    }

    @Test(description = "Checking correctness of filling Number of Instances")
    public void checkNumberOfInstancesFilling() {
        Assert.assertEquals(calculatorResultsPage.getNumberOfInstances(),
                formatFields.formatNumberOfInstances(calculator.getNumberOfInstances()),
                "Number of instances are not equal");
    }

    @Test(description = "Checking correctness of filling Operation System")
    public void checkOperationSystemFilling() {
        Assert.assertEquals(calculatorResultsPage.getOperationSystem(),
                formatFields.formatOperationSystem(calculator.getOperationSystem()),
                "Operation systems are not equal");
    }

    @Test(description = "Checking correctness of filling Machine Class")
    public void checkMachineClassFilling() {
        Assert.assertEquals(calculatorResultsPage.getMachineClass(),
                formatFields.formatMachineClass(calculator.getMachineClass()),
                "Operation systems are not equal");
    }

    @Test(description = "Checking correctness of fillingMachine Type")
    public void checkMachineTypeFilling() {
        Assert.assertEquals(calculatorResultsPage.getMachineType(),
                formatFields.formatMachineType(calculator.getMachineType()),
                "Machine types are not equal");
    }

    @Test(description = "Checking correctness of filling GPU Number and Type")
    public void checkGPUTypeFilling() {
        Assert.assertEquals(calculatorResultsPage.getGPU(),
                formatFields.formatGPU(calculator.getNumberOfGPU(), calculator.getGpuType()),
                "GPU are not equal");
    }

    @Test(description = "Checking correctness of filling SSD number")
    public void checkSSDNumberFilling() {
        Assert.assertEquals(calculatorResultsPage.getSSD(),
                formatFields.formatSSD(calculator.getNumberOfSSD()),
                "SSD are not equal");
    }

    @Test(description = "Checking correctness of filling Data center")
    public void checkDataCenterFilling() {
        Assert.assertEquals(calculatorResultsPage.getDataCenter(),
                formatFields.formatDataCenter(calculator.getDataCenter()),
                "Data center's are not equal");
    }

    @Test(description = "Checking correctness of filling Committed usage")
    public void checkCommittedUsageFilling() {
        Assert.assertEquals(calculatorResultsPage.getCommitmentUsage(),
                formatFields.formatCommittedUsage(calculator.getCommittedUsage()),
                "Committed usages are not equal");
    }
}
