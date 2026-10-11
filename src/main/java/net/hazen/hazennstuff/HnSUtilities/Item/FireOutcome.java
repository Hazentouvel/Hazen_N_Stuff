package net.hazen.hazennstuff.HnSUtilities.Item;

public enum FireOutcome {
    FIRED,
    INVALID_SHOOTER,
    NO_GUN,
    FIRE_DELAY_ACTIVE,
    RELOADING,
    EMPTY_MAGAZINE,
    EVENT_CANCELLED;

    public boolean fired() {
        return this == FIRED;
    }
}