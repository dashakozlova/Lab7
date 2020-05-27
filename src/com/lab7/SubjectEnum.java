package com.lab7;

public enum SubjectEnum {
    Database("Database "),
    Linux("Linux "),
    Java("Java "),
    Security("Security "),
    English("English ");
    /**
     * Title of the some element.
     */
    private final String title;

    /**
     * Constructor for the element.
     * @param title title of element.
     */
    SubjectEnum(String title) {
        this.title = title;
    }

    /**
     * Title getter.
     * @return title value.
     */
    public String getTitle() {
        return title;
    }
}