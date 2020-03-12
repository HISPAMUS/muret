package es.ua.dlsi.grfia.moosicae.core;

/**
 * It knows how to create all main objects in the core package
 */
public interface ICoreAbstractFactory {
    IClef createClef(int line, ClefSignTypes clefSign);
    IPart createPart(IScore score, String name);
    IPart createPart(IScore score);
    IVoice createVoice(IPart part);
    IScore createScore();
}
