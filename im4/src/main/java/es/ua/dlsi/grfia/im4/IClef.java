package es.ua.dlsi.grfia.im4;

public interface IClef extends IStaffComponent, INonDurational {
    int getLine();

    ClefSigns getSign();
}
