package az.rock.auth.domain.presentation.ports.input.service.query.abstracts;

import az.rock.flyjob.auth.root.RoleRoot;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.domain.id.RoleID;
import org.springframework.transaction.annotation.Transactional;

@InputPort
@Transactional(readOnly = true)
public interface AbstractQueryRoleDomainPresentationService {
    RoleRoot findIdByName(String name);
}
