package javaExceptions.mainTask.university;

import javaExceptions.mainTask.exceptions.WrongStudentException;

import java.util.List;

public class Group {
    private String Name;
    private List<Student> studentsList;

    public Group(String groupName, List<Student> studentList) {
        this.Name = groupName;
        this.studentsList = studentList;
        if (studentList.isEmpty()){
            throw new WrongStudentException("Group must have at least 1 student");
        }
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + Name + '\'' +
                ", studentList=" + studentsList +
                '}';
    }
}
