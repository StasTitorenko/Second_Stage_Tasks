package framework.service;

import framework.featuredCategories.*;
import framework.models.Calculator;

public class CalculatorCreator {
    public static final String TAB = "testData.tab";
    public static final String NUMBER_OF_INSTANCES = "testData.numberOfInstances";
    public static final String OPERATION_SYSTEM = "testData.operationSystem";
    public static final String MACHINE_CLASS = "testData.machineClass";
    public static final String MACHINE_SERIES = "testData.machineSeries";
    public static final String MACHINE_TYPE = "testData.machineType";
    public static final String NUMBER_OF_GPU = "testData.numberOfGPU";
    public static final String GPU_TYPE = "testData.gpuType";
    public static final String NUMBER_OF_SSD = "testData.numberOfSSD";
    public static final String DATA_CENTER = "testData.dataCenter";
    public static final String COMMITTED_USAGE = "testData.committedUsage";

    public static Calculator withCredentialsFromProperty() {
        TestDataReader.setEnvironment();
        return new Calculator(
                Tabs.valueOf(TestDataReader.getTestData(TAB)),
                TestDataReader.getTestData(NUMBER_OF_INSTANCES),
                OperationSystem.valueOf(TestDataReader.getTestData(OPERATION_SYSTEM)),
                MachineClass.valueOf(TestDataReader.getTestData(MACHINE_CLASS)),
                MachineSeries.valueOf(TestDataReader.getTestData(MACHINE_SERIES)),
                MachineType.valueOf(TestDataReader.getTestData(MACHINE_TYPE)),
                NumberOfGPU.valueOf(TestDataReader.getTestData(NUMBER_OF_GPU)),
                GPUType.valueOf(TestDataReader.getTestData(GPU_TYPE)),
                NumberOfSSD.valueOf(TestDataReader.getTestData(NUMBER_OF_SSD)),
                DataCenter.valueOf(TestDataReader.getTestData(DATA_CENTER)),
                CommittedUsage.valueOf(TestDataReader.getTestData(COMMITTED_USAGE)));

    }
}
