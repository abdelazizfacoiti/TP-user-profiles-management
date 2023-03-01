package com.facoiti.transperfectchallange.enums;
public enum Education {
    MASTERS_DEGREE_IN_COMPUTER_SCIENCE("Masters Degree in Computer Science"),
    BACHELORS_DEGREE_IN_COMPUTER_SCIENCE("Bachelors Degree in Computer Science"),
    ASSOCIATES_DEGREE_IN_COMPUTER_SCIENCE("Associates Degree in Computer Science")
    ;
    private String education;
    Education(String education) {
        this.education = education;
    }
    public String getEducation() {
        return education;
    }
}
