package az.rock.auth.domain.presentation.ports.output.publisher;

import az.rock.flyjob.auth.root.user.ProfilePictureRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.publisher.AbstractMessagePublisher;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@DomainOutputPort
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractProfilePictureMessagePublisher extends AbstractMessagePublisher<AbstractDomainEvent<ProfilePictureRoot>> {
}
