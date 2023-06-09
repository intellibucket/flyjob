package az.rock.flyjob.auth.dfs.service.concretes;

import az.rock.auth.domain.presentation.ports.output.dfs.AbstractFileStorageAdapter;
import az.rock.flyjob.auth.dfs.mapper.FileMetaDataMapper;
import az.rock.flyjob.auth.dfs.service.abstracts.AbstractMinioService;
import az.rock.lib.valueObject.FileMetaData;
import az.rock.lib.valueObject.MultipartFileWrapper;
import io.minio.errors.MinioException;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class MinioFileStorageService implements AbstractFileStorageAdapter {
    private final AbstractMinioService minioService;

    private final FileMetaDataMapper fileMetaDataMapper;

    public MinioFileStorageService(AbstractMinioService minioService,
                                   FileMetaDataMapper fileMetaDataMapper) {
        this.minioService = minioService;
        this.fileMetaDataMapper = fileMetaDataMapper;
    }

    @Override
    public FileMetaData uploadFile(MultipartFileWrapper multipartFileWrapper) {
        try {
            var response = this.minioService.upload(multipartFileWrapper);
            return this.fileMetaDataMapper.map(response);
        } catch (MinioException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] get(String path) {
        return this.minioService.get(path);
    }

}
