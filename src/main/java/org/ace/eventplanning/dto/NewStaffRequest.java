package org.ace.eventplanning.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewStaffRequest {
    private long staffID;
    private String staffName;
    private int staffAge;
    private String staffAddress;
    private String staffPhoneNumber;
    private String staffEmail;
    private String staffPassword;

    private long roleID;
}
