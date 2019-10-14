package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ResetPWDForm
{
    @NotBlank
    @Size(min=2, max = 60)
    private String username;

    public String getNewPWD() {
        return newPWD;
    }

    public String getUsername() {
        return username;
    }

    public void setNewPWD(String newPWD) {
        this.newPWD = newPWD;
    }

    @NotBlank
    @Size(min = 2, max = 40)
    private String newPWD;
}
