package az.rock.auth.domain.presentation.ports.input.outbox.abstracts;

import az.rock.lib.annotation.InputPort;
import az.rock.lib.domain.SagaID;
import az.rock.lib.valueObject.SagaRoot;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@InputPort
public interface AbstractOutboxInputPort<E,D> {
    SagaRoot<E> save(E event);
    void success(SagaID sagaId);
    void fail(SagaID sagaId);

    void processing(SagaID sagaId);

    void compensating(SagaID sagaId);

    void compensated(SagaID sagaId);
}
