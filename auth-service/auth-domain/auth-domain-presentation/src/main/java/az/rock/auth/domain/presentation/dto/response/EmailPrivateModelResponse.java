package az.rock.auth.domain.presentation.dto.response;

import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.lib.valueObject.EmailType;

import java.util.UUID;

public record EmailPrivateModelResponse(UUID uuid,
                                        UUID userID,
                                        EmailType type,
                                        String email,
                                        Boolean isEnableNotification,
                                        Boolean isPrimary,
                                        Boolean isVerified,
                                        Boolean isSubscribedPromotions) {
    private EmailPrivateModelResponse(EmailRoot root) {
        this(root.getUUID().getId(), root.getUserId().getId(), root.getType(), root.getEmail(), root.isEnableNotification(),
                root.isPrimary(), root.isVerified(), root.isSubscribedPromotions());
    }

    public static EmailPrivateModelResponse of(EmailRoot root) {
        return new EmailPrivateModelResponse(root);
    }
}
