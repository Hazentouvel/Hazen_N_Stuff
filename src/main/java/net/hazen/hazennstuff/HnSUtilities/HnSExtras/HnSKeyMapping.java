package net.hazen.hazennstuff.HnSUtilities.HnSExtras;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.settings.IKeyConflictContext;

public class HnSKeyMapping extends KeyMapping {
    private boolean canBeConsumed;
    private boolean wasDown;

    public HnSKeyMapping(String description, IKeyConflictContext keyConflictContext, InputConstants.Type inputType, int keyCode, String category) {
        super(description, keyConflictContext, inputType.getOrCreate(keyCode), category);
    }

    public void setDown(boolean value) {
        super.setDown(value);
        if (value && !this.wasDown) {
            this.canBeConsumed = true;
        }

        this.wasDown = value;
    }

    public boolean consume() {
        while(this.consumeClick()) {
        }

        if (this.canBeConsumed) {
            this.canBeConsumed = false;
            return true;
        } else {
            return false;
        }
    }
}
