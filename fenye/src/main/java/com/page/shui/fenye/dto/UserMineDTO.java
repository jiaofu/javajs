package com.page.shui.fenye.dto;


import java.util.List;

public class UserMineDTO {


    private UserDTO user;


    private List<CurrentLockDTO> currentLockDTOS;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
    public List<CurrentLockDTO> getCurrentLockDTOS() {
        return currentLockDTOS;
    }

    public void setCurrentLockDTOS(List<CurrentLockDTO> currentLockDTOS) {
        this.currentLockDTOS = currentLockDTOS;
    }

}
