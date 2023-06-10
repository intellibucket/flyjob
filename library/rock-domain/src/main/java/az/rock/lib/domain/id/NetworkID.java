package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class NetworkID extends RootID<UUID> implements IdReference<UUID> {
    protected NetworkID(UUID value) {
        super(value);
    }

    public static NetworkID of(UUID value) {
        return new NetworkID(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }
}
