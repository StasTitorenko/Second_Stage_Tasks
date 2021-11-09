package framework.models;

import framework.featuredCategories.*;
import java.util.Objects;

public record Calculator(Tabs tab, String numberOfInstances,
                         OperationSystem operationSystem,
                         MachineClass machineClass,
                         MachineSeries machineSeries,
                         MachineType machineType,
                         NumberOfGPU numberOfGPU,
                         GPUType gpuType,
                         NumberOfSSD numberOfSSD,
                         DataCenter dataCenter,
                         CommittedUsage committedUsage) {

    public Tabs getTab() {
        return tab;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public OperationSystem getOperationSystem() {
        return operationSystem;
    }

    public MachineClass getMachineClass() {
        return machineClass;
    }

    public MachineSeries getMachineSeries() {
        return machineSeries;
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public NumberOfGPU getNumberOfGPU() {
        return numberOfGPU;
    }

    public GPUType getGpuType() {
        return gpuType;
    }

    public NumberOfSSD getNumberOfSSD() {
        return numberOfSSD;
    }

    public DataCenter getDataCenter() {
        return dataCenter;
    }

    public CommittedUsage getCommittedUsage() {
        return committedUsage;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "tab=" + tab +
                ", numberOfInstances='" + numberOfInstances + '\'' +
                ", operationSystem=" + operationSystem +
                ", machineClass=" + machineClass +
                ", machineSeries=" + machineSeries +
                ", machineType=" + machineType +
                ", numberOfGPU=" + numberOfGPU +
                ", gpuType=" + gpuType +
                ", numberOfSSD=" + numberOfSSD +
                ", dataCenter=" + dataCenter +
                ", committedUsage=" + committedUsage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return tab == that.tab &&
                numberOfInstances.equals(that.numberOfInstances) &&
                operationSystem == that.operationSystem &&
                machineClass == that.machineClass &&
                machineSeries == that.machineSeries &&
                machineType == that.machineType &&
                numberOfGPU == that.numberOfGPU &&
                gpuType == that.gpuType &&
                numberOfSSD == that.numberOfSSD &&
                dataCenter == that.dataCenter &&
                committedUsage == that.committedUsage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tab, numberOfInstances, operationSystem, machineClass, machineSeries,
                machineType, numberOfGPU, gpuType, numberOfSSD, dataCenter, committedUsage);
    }
}
