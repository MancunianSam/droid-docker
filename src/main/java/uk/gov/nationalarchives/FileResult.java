package uk.gov.nationalarchives;

import uk.gov.nationalarchives.droid.core.interfaces.IdentificationMethod;
import uk.gov.nationalarchives.droid.internal.api.ApiResult;

import java.nio.file.Path;

public class FileResult extends ApiResult {
    private final Path fileName;

    public FileResult(ApiResult result, Path fileName) {
        super(result.getExtension(), result.getMethod(), result.getPuid(), result.getName());
        this.fileName = fileName;
    }

    public Path getFileName() {
        return fileName;
    }
}
