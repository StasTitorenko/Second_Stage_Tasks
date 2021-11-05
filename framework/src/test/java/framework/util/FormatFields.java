package framework.util;

public class FormatFields {
    public String refactorTotalCost(String input) {
        return input.substring(0, 16) + "Monthly "+ input.substring(16);
    }

    public String refactorNumberOfInstances(String input) {
        return input + " x";
    }

    public String refactorMachineClass(String input) {
        return "VM class: " + input;
    }

    public String refactorMachineType(String input) {
        return "Instance type: " + input.toLowerCase() + "\nCommitted Use Discount applied";
    }

    public String refactorDataCenter(String input) {
        return "Region: " + input;
    }

    public String refactorCommittedUsage(String input) {
        return "Commitment term: " + input;
    }

    public String refactorOperationSystem(String input) {
        return "Operating System / Software: " + (Character.toUpperCase(input.charAt(0)) + input.substring(1));
    }
}
