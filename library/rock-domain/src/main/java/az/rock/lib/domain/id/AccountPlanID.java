package az.rock.lib.domain.id;

import az.rock.lib.domain.RootID;

import java.util.UUID;

public class AccountPlanID extends RootID<UUID> implements IdReference<UUID> {
    public static final AccountPlanID NULL = new AccountPlanID(null);
    protected AccountPlanID(UUID value) {
        super(value);
    }

    @Override
    public UUID getAbsoluteID() {
        return super.getRootID();
    }

    public static AccountPlanID of(UUID value) {
        return new AccountPlanID(value);
    }
}
