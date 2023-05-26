package az.rock.flyjob.auth.dataAccess.entity.user;

import az.rock.flyjob.auth.dataAccess.entity.detail.DetailEntity;
import az.rock.flyjob.auth.dataAccess.entity.user.device.DeviceEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.DataStatus;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.ProcessStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "auth", indexes = {
        @Index(name = "idx_userentity_username", columnList = "username")
})
@Entity(name = "UserEntity")
public class UserEntity extends BaseEntity {

    @Column(name = "key", nullable = false, unique = true)
    private UUID key;

    @Column(name = "first_name", nullable = false)
    @Min(value = 3, message = "First name must be at least 3 characters long")
    @Max(value = 30, message = "First name must be at most 20 characters long")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Min(value = 3, message = "Last name must be at least 3 characters long")
    @Max(value = 40, message = "Last name must be at most 20 characters long")
    private String lastName;

    @Column(name = "username", nullable = false, unique = true)
    @Min(value = 2, message = "Username must be at least 3 characters long")
    @Max(value = 30, message = "Username must be at most 20 characters long")
    private String username;

    @Column(name = "timezone", nullable = false)
    @Min(value = 1, message = "Timezone must be at least 3 characters long")
    private String timezone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PasswordEntity> passwords;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<EmailEntity> emails;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PhoneNumberEntity> phoneNumbers;

    @OneToOne(cascade = CascadeType.ALL)
    private DetailEntity detail;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AccountPlanEntity> accountPlans;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DeviceEntity> devices;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserSettingsEntity settings;

    private UserEntity(Builder builder) {
        setKey(builder.key);
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setUsername(builder.username);
        setTimezone(builder.timezone);
        setDetail(builder.account);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private UUID key;
        private @Min(value = 3, message = "First name must be at least 3 characters long") @Max(value = 30, message = "First name must be at most 20 characters long") String firstName;
        private @Min(value = 3, message = "Last name must be at least 3 characters long") @Max(value = 40, message = "Last name must be at most 20 characters long") String lastName;
        private @Min(value = 2, message = "Username must be at least 3 characters long") @Max(value = 30, message = "Username must be at most 20 characters long") String username;
        private Set<PasswordEntity> passwordEntity;
        private @Min(value = 1, message = "Timezone must be at least 3 characters long") String timezone;
        private DetailEntity account;
        private UUID uuid;
        private Long version;

        private ProcessStatus processStatus;

        private DataStatus dataStatus;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder key(UUID val) {
            key = val;
            return this;
        }

        public Builder firstName(@Min(value = 3, message = "First name must be at least 3 characters long") @Max(value = 30, message = "First name must be at most 20 characters long") String val) {
            firstName = val;
            return this;
        }

        public Builder lastName(@Min(value = 3, message = "Last name must be at least 3 characters long") @Max(value = 40, message = "Last name must be at most 20 characters long") String val) {
            lastName = val;
            return this;
        }

        public Builder username(@Min(value = 2, message = "Username must be at least 3 characters long") @Max(value = 30, message = "Username must be at most 20 characters long") String val) {
            username = val;
            return this;
        }

        public Builder passwordEntity(Set<PasswordEntity> val) {
            passwordEntity = val;
            return this;
        }

        public Builder timezone(@Min(value = 1, message = "Timezone must be at least 3 characters long") String val) {
            timezone = val;
            return this;
        }


        public Builder account(DetailEntity val) {
            account = val;
            return this;
        }

        public Builder uuid(UUID val) {
            uuid = val;
            return this;
        }

        public Builder version(Long val) {
            version = val;
            return this;
        }

        public Builder createdDate(Timestamp val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(Timestamp val) {
            lastModifiedDate = val;
            return this;
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder dataStatus(DataStatus val) {
            dataStatus = val;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this);
        }
    }
}