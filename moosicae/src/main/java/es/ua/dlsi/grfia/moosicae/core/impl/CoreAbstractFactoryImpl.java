package es.ua.dlsi.grfia.moosicae.core.impl;

import es.ua.dlsi.grfia.moosicae.core.*;

public class CoreAbstractFactoryImpl implements ICoreAbstractFactory {
    @Override
    public IClef createClef(int line, ClefSignTypes clefSign) {
        return new Clef(line, clefSign);
    }

    @Override
    public IPart createPart(IScore score, String name) {
        IPart part = new Part(name);
        score.addPart(part);
        return part;
    }

    @Override
    public IPart createPart(IScore score) {
        IPart part = new Part();
        score.addPart(part);
        return part;
    }

    @Override
    public IVoice createVoice(IPart part) {
        Voice voice = new Voice();
        part.addVoice(voice);
        return voice;
    }

    @Override
    public IScore createScore() {
        return new Score();
    }
}
