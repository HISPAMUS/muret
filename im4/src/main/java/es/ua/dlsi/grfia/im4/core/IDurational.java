package es.ua.dlsi.grfia.im4.core;

import es.ua.dlsi.grfia.im4.utils.Time;

public interface IDurational extends ILayerComponent, IVoiceComponent {
    Time getDuration();
}
