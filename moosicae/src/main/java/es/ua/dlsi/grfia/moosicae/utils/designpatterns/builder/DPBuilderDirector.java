package es.ua.dlsi.grfia.moosicae.utils.designpatterns.builder;

public class DPBuilderDirector {
    private final IDPBuilder builder;

    public DPBuilderDirector(IDPBuilder builder) {
        this.builder = builder;
    }

    public IDPBuilder getBuilder() {
        return builder;
    }
}
