package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class EmailID  extends RootID<UUID> implements IdReference<UUID> {
    protected EmailID(UUID value) {
        super(value);
    }

    @Override
    public UUID getId() {
        return super.getUUID();
    }

    public static EmailID of(UUID value) {
        return new EmailID(value);
    }
}