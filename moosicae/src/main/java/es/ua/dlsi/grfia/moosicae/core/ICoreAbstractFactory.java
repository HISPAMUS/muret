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

    /**
     * For nested staff
     * @param staffGroup
     * @return
     */
    IStaff createStaff(IStaffGroup staffGroup);

    /**
     * For ungrouped staves
     * @param score
     * @return
     */
    IStaff createStaff(IScore score);
    IStaffGroup createStaffGroup(IScore score);

    /**
     * For nested groups
     * @param staffGroup
     * @return
     */
    IStaffGroup createStaffGroup(IStaffGroup staffGroup);
}
