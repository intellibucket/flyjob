package az.rock.flyjob.auth.api.rest.privates.command;

import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.spec.auth.privates.command.NetworkCommandPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/command/network",produces = MediaType.APPLICATION_JSON_VALUE)
public class NetworkCommandPrivateController implements NetworkCommandPrivateSpec {
    @Override
    public ResponseEntity<JSuccessResponse> sendRequest(UUID userID) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> acceptRequest(UUID networkID) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> rejectRequest(UUID networkID) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> cancelRequest(UUID networkID) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessResponse> deleteNetwork(UUID networkID) {
        return null;
    }
}
