package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractPasswordQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.entity.user.PasswordEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.PasswordQueryJPARepository;
import az.rock.flyjob.auth.root.user.PasswordRoot;
import az.rock.lib.domain.id.PasswordID;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PasswordQueryRepositoryAdapter implements AbstractPasswordQueryRepositoryAdapter {
    private final AbstractDataAccessMapper<PasswordEntity,PasswordRoot> passwordDataAccessMapper;

    private final PasswordQueryJPARepository passwordQueryJPARepository;

    public PasswordQueryRepositoryAdapter(AbstractDataAccessMapper<PasswordEntity, PasswordRoot> passwordDataAccessMapper,
                                          PasswordQueryJPARepository passwordQueryJPARepository) {
        this.passwordDataAccessMapper = passwordDataAccessMapper;
        this.passwordQueryJPARepository = passwordQueryJPARepository;
    }

    @Override
    public Optional<PasswordRoot> findById(PasswordID rootId) {
        var passwordEntity = this.passwordQueryJPARepository.findByPID(rootId.getAbsoluteID());
        if (passwordEntity.isPresent()){
            return this.passwordDataAccessMapper.toRoot(passwordEntity.get());
        }else return Optional.empty();
    }

    @Override
    public Optional<PasswordRoot> findByPID(UserID parentID) {
        var currentPasswordEntity = this.passwordQueryJPARepository.findByPID(parentID.getAbsoluteID());
        if (currentPasswordEntity.isPresent()) {
            return this.passwordDataAccessMapper.toRoot(currentPasswordEntity.get());
        }else return Optional.empty();
    }
}
