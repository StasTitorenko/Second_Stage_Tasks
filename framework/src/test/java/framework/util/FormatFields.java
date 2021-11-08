package framework.util;

import framework.featuredCategories.*;

public class FormatFields {

    public String formatTotalCost(String totalCost) {
        return totalCost.substring(0, 16) + "Monthly " + totalCost.substring(16);
    }

    public String formatNumberOfInstances(String numberOfInstances) {
        return numberOfInstances + " x";
    }

    public String formatMachineClass(MachineClass machineClass) {
        return "VM class: " + machineClass;
    }

    public String formatMachineType(MachineType machineType) {
        return "Instance type: " + machineType.toString().toLowerCase() + "\nCommitted Use Discount applied";
    }

    public String formatDataCenter(DataCenter dataCenter) {
        return "Region: " + dataCenter;
    }

    public String formatCommittedUsage(CommittedUsage committedUsage) {
        return "Commitment term: " + committedUsage;
    }

    public String formatOperationSystem(OperationSystem operationSystem) {
        String result;
        if (operationSystem.toString().contains("free")) {
            result = "Free";
        } else {
            result = "Paid";
        }
        return "Operating System / Software: " + result;
    }

    public String formatGPU(NumberOfGPU numberOfGPU, GPUType gpuType) {
        return "GPU dies: " + numberOfGPU + " " + gpuType.toString().substring(0, 8)
                + gpuType.toString().substring(8, 13).toUpperCase() + gpuType.toString().substring(13)
                + "\nCommitted Use Discount applied";
    }

    public String formatSSD(NumberOfSSD numberOfSSD) {
        return "Local SSD: " + numberOfSSD + "x375 GiB\nCommitted Use Discount applied";
    }
}
