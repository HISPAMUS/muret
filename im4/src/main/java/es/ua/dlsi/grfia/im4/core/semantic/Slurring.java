package es.ua.dlsi.grfia.im4.core.semantic;

public class Slurring {
    private final boolean slurStart;
    private final boolean slurEnd;

    public Slurring(boolean slurStart, boolean slurEnd) {
        this.slurStart = slurStart;
        this.slurEnd = slurEnd;
    }

    public boolean isSlurStart() {
        return slurStart;
    }

    public boolean isSlurEnd() {
        return slurEnd;
    }
}
