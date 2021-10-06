package javaExceptions.mainTask.university;

import javaExceptions.mainTask.exceptions.LackOfGroupException;
import javaExceptions.mainTask.exceptions.LackOfStudentException;

import java.util.List;

public class Group {
    private String groupName;
    private List<Student> studentList;

    public Group(String groupName, List<Student> studentList) {
        this.groupName = groupName;
        this.studentList = studentList;
        if (studentList.isEmpty()){
            throw new LackOfStudentException("Group must have at least 1 student");
        }
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
