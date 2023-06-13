package az.rock.auth.domain.presentation.ports.input.service.command.abstracts;

import az.rock.lib.annotation.InputPort;
import az.rock.lib.valueObject.MultipartFileWrapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@InputPort
@Transactional
public interface AbstractProfilePictureCommandDomainPresentation {
    UUID uploadProfilePicture(MultipartFileWrapper file);
}
