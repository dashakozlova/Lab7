package com.lab7;
import java.util.ArrayList;
import com.lab7.SubjectEnum;
public class Student implements Comparable<Student> {
    /**
     class fields
     */
        private int id;
        private int nextID;
        private String name;
        private String surname;
        private String group;
        private ArrayList<Subject> subjects = new ArrayList<>();

    /**
     * Default constructor
     */
        public Student() {
        }

    /**
     * Constructor with params
     * @param id student id
     * @param name student name
     * @param surname student surname
     */
        public Student(int id, String name, String surname) {
            this.id=id;
            this.name=name;
            this.surname=surname;
        }

    /**
     * Constructor with params
     * @param id student id
     * @param name student name
     * @param surname student surname
     * @param group student group
     */
    public Student(int id, String name, String surname, String group) {
        this(id, name, surname);
        setGroup(group);
        this.addSubject(new Subject(SubjectEnum.Database.getTitle()));
        this.addSubject(new Subject(SubjectEnum.Linux.getTitle()));
        this.addSubject(new Subject(SubjectEnum.Java.getTitle()));
        this.addSubject(new Subject(SubjectEnum.English.getTitle()));

    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);}

    /**
     *
     * @return student id
     */
        public int getID() {
            return this.id;
        }

    /**
     *
     * @param id set student id
     */
        public void setID(int id)  {
                this.id = id;
        }

    /**
     *
     * @return student next id
     */
        public int getNextID() {
            return this.nextID;
        }

    /**
     *
     * @param nextID set stuent nextId
     */
        public void setNextID(int nextID) {

                this.nextID = nextID;
        }

    /**
     *
     * @return student name
     */
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

    /**
     *
     * @return student surname
     */
        public String getSurname() {
            return this.surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

    /**
     *
     * @return student group
     */
        public String getGroup() {
            return this.group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public Subject getSubject(int index) {
                return this.subjects.get(index);
        }

        public void setSubject(int index, Subject subject) {
                this.subjects.set(index, subject);
        }

        public ArrayList<Subject> getSubjects() {
            return this.subjects;
        }

    /**
     *
     * @return string with information about student
     */
        @Override
        public String toString() {
            StringBuilder string = new StringBuilder();
            string.append("ID: " + getID() +
                    "\tName: " + getName() +
                    "\tSurname: " + getSurname() +
                    "\tGroup: " + getGroup());
            string.append("\nSubjects:\n");
            for(Subject subject : subjects) {
                string.append(subject.getSubjName() + "-------- " + subject.getMark() +
                        "--------" + subject.getPassedString() + "\n");
            }
            string.append("Stipend: " + (isPStipend()? "big" : "normal\n"));
            string.append("_________________________________________________________________\n");

            return string.toString();
        }

        @Override
        public int compareTo(Student student) {
            if (this.getAverageMark() == student.getAverageMark()) {
                return 0;
            } else if (this.getAverageMark() == student.getAverageMark()) {
                return -1;
            } else {
                return 1;
            }
        }

    /**
     *
     * @return avarage mark student
     */
        public float getAverageMark() {
            float sum = 0;
            for (Subject subject : getSubjects()) {
                sum += subject.getMark();
            }
            return sum / subjects.size();
        }

    /**
     *
     * @retur will the student receive a scholarship
     */
        public boolean isPStipend() {
            return getAverageMark() == 5.0;
        }

        public class Subject {

        /**
         * Contains name of the subject.
         */
        private String subjName;

        /**
         * Contains mark.
         */
        private Float mark;

        /**
         * Contains boolean value passed.
         */
        private Boolean passed;

        /**
         * Creates usable object.
         */
        public Subject() {
        }

        /**
         * Creates object with custom name.
         *
         * @param subjName
         */
        public Subject(String subjName) {
            setSubjName(subjName);
            mark = getRandomValue(0, 5);
            passed = (mark >= 2);
        }

        /**
         * Getter for subjName.
         *
         * @return subjName value.
         */
        public String getSubjName() {
            return subjName;
        }

        /**
         * Setter for subjName.
         *
         * @param subjName new subjectName.
         */
        public void setSubjName(String subjName) {
            this.subjName = subjName;
        }

        /**
         * Getter for mark.
         *
         * @return mark.
         */
        public float getMark() {
            return mark;
        }

        /**
         * Getter for passed value.
         *
         * @return passed.
         */
        public boolean getPassed() {
            return passed;
        }

        public String getPassedString() {
            return (getPassed() ? "Passed" : "Not passed");
        }

        /**
         * Method for getting random value between two arguments.
         *
         * @param min minimum value.
         * @param max maximum value.
         * @return random value.
         */
        public float getRandomValue(int min, int max) {
            return (float) Math.random() * (max - min) + min;
        }
    }
}
