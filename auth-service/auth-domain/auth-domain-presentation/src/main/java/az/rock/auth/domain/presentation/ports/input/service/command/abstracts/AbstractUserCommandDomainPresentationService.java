package az.rock.auth.domain.presentation.ports.input.service.command.abstracts;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.lib.annotation.InputPort;

@InputPort
public interface AbstractUserCommandDomainPresentationService {
    CreateUserResponse createUser(CreateUserCommand createUserCommand);

    CreateUserResponse createCompany(CreateUserCommand createUserCommand);
}