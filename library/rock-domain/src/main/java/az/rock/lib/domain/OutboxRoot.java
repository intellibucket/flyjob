package az.rock.lib.domain;

import az.rock.lib.event.saga.SagaStatus;
import az.rock.lib.valueObject.OutboxStatus;
import az.rock.lib.valueObject.SagaRoot;
import az.rock.lib.valueObject.Version;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.UUID;

public abstract class OutboxRoot<D>  extends RootID<OutboxID> {

    private SagaID sagaId;

    private Version version;

    private ZonedDateTime createdDate;

    private ZonedDateTime lastModifiedDate;

    private SagaStatus sagaStatus;

    private OutboxStatus outboxStatus;

    private String type;

    private String payload;

    public OutboxRoot(OutboxID value,
                      SagaID sagaId,
                      Version version,
                      ZonedDateTime createdDate,
                      ZonedDateTime lastModifiedDate,
                      SagaStatus sagaStatus,
                      OutboxStatus outboxStatus,
                      String type,
                      String payload) {
        super(value);
        this.sagaId = sagaId;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.sagaStatus = sagaStatus;
        this.outboxStatus = outboxStatus;
        this.type = type;
        this.payload = payload;
    }


    public SagaID getSagaId() {
        return sagaId;
    }

    public Version getVersion() {
        return version;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public ZonedDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public SagaStatus getSagaStatus() {
        return sagaStatus;
    }

    public OutboxStatus getOutboxStatus() {
        return outboxStatus;
    }

    public String getType() {
        return type;
    }

    public String getPayload() {
        return payload;
    }
}
