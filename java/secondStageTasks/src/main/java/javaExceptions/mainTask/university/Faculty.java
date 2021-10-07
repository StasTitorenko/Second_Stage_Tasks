package javaExceptions.mainTask.university;

import javaExceptions.mainTask.exceptions.WrongGroupException;
import javaExceptions.mainTask.featuredCategories.Faculties;

import java.util.List;

public class Faculty {
    private Faculties name;
    private List<Group> groupsList;

    public Faculty(Faculties facultyName, List<Group> groupList) {
        this.name = facultyName;
        this.groupsList = groupList;
        try {
            if (groupList.isEmpty()) {
                throw new WrongGroupException("Faculty must have at least 1 group");
            }
        } catch (Exception e) {
            throw new WrongGroupException("Faculty must have at least 1 group");
        }
    }

    public Faculties getName() {
        return name;
    }

    public List<Group> getGroupsList() {
        return groupsList;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyName=" + name +
                ", groupList=" + groupsList +
                '}';
    }
}
