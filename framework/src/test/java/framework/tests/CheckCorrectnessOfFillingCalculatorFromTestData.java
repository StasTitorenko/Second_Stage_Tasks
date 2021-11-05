package framework.tests;

import framework.util.FormatFields;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckCorrectnessOfFillingCalculatorFromTestData extends AbstractTest {
    private FormatFields formatFields = new FormatFields();

    @Test(description = "Check correctness of filling Tab")
    public void checkTabFilling() {
        Assert.assertEquals(calculatorResultsPage.getTab(),
                calculator.getTab().toString(),
                "Tabs are not equal");
    }

    @Test(description = "Check correctness of filling Number of Instances")
    public void checkNumberOfInstancesFilling() {
        Assert.assertEquals(calculatorResultsPage.getNumberOfInstances(),
                formatFields.refactorNumberOfInstances(calculator.getNumberOfInstances()),
                "Number of instances are not equal");
    }

    @Test(description = "Check correctness of filling Operation System")
    public void checkOperationSystemFilling() {
        Assert.assertEquals(calculatorResultsPage.getOperationSystem(),
                formatFields.refactorOperationSystem(calculator.getOperationSystem().toString()),
                "Operation systems are not equal");
    }

    @Test(description = "Check correctness of filling Machine Class")
    public void checkMachineClassFilling() {
        Assert.assertEquals(calculatorResultsPage.getMachineClass(),
                formatFields.refactorMachineClass(calculator.getMachineClass().toString()),
                "Operation systems are not equal");
    }

    @Test(description = "Check correctness of filling Machine Type")
    public void checkMachineTypeFilling() {
        Assert.assertEquals(calculatorResultsPage.getMachineType(),
                formatFields.refactorMachineType(calculator.getMachineType().toString()),
                "Machine types are not equal");
    }

    @Test(description = "Check correctness of filling GPU Type")
    public void checkGPUTypeFilling() {
        Assert.assertEquals(calculatorResultsPage.getGPU(), calculator.getGpuType(), "GPU are not equal");
    }

    @Test(description = "Check correctness of filling SSD number")
    public void checkSSDNumberFilling() {
        Assert.assertEquals(calculatorResultsPage.getSSD(), calculator.getNumberOfSSD(), "SSD are not equal");
    }

    @Test(description = "Check correctness of filling Data center")
    public void checkDataCenterFilling() {
        Assert.assertEquals(calculatorResultsPage.getDataCenter(),
                formatFields.refactorDataCenter(calculator.getDataCenter().toString()),
                "Data center's are not equal");
    }

    @Test(description = "Check correctness of filling Committed usage")
    public void checkCommittedUsageFilling() {
        Assert.assertEquals(calculatorResultsPage.getCommitmentUsage(),
                formatFields.refactorCommittedUsage(calculator.getCommittedUsage().toString()),
                "Committed usages are not equal");
    }

}
