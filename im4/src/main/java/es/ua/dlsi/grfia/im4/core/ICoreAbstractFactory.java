package es.ua.dlsi.grfia.im4.core;

public interface ICoreAbstractFactory {
    IClef createClef(int line, ClefSignTypes clefSign);
    IPart createPart(IScore score, String name);
    IPart createPart(IScore score);
    IVoice createVoice(IPart part);
    IScore createScore();
}
