package az.rock.flyjob.auth.api.rest.privates.query;

import az.rock.auth.domain.presentation.dto.response.DetailPrivateModelResponse;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractDetailQueryDomainPresentationService;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.spec.auth.privates.query.DetailQueryPrivateSpec;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth/1.0/private/query/detail",produces = MediaType.APPLICATION_JSON_VALUE)
public class DetailQueryPrivateController implements DetailQueryPrivateSpec {
    private final AbstractDetailQueryDomainPresentationService detailDomainPresentationService;

    public DetailQueryPrivateController(AbstractDetailQueryDomainPresentationService detailDomainPresentationService) {
        this.detailDomainPresentationService = detailDomainPresentationService;
    }

    @Override
    @GetMapping(value = "/query-detail")
    public ResponseEntity<JSuccessDataResponse<DetailPrivateModelResponse>> queryDetail() {
        var response = this.detailDomainPresentationService.queryDetail();
        return ResponseEntity.ok(new JSuccessDataResponse<>(response));
    }
}
