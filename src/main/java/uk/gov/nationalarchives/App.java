package uk.gov.nationalarchives;

import com.fasterxml.jackson.databind.ObjectMapper;
import uk.gov.nationalarchives.droid.internal.api.ApiResult;
import uk.gov.nationalarchives.droid.internal.api.DroidAPI;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.walk;


public class App {

    private static List<FileResult> submit(DroidAPI api, Path path) {
        try {
            return api.submit(path).stream()
                    .map(apiResult -> new FileResult(apiResult, path.getFileName()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public static void main( String[] args ) {
        try {
            Path droidFile = Paths.get("/tmp/DROID_SignatureFile_V107.xml");
            Path containerFile = Paths.get("/tmp/container-signature-20220704.xml");
            DroidAPI api = DroidAPI.getInstance(droidFile, containerFile);
            List<ApiResult> results = walk(Paths.get("/tmp/files"))
                    .filter(Files::isRegularFile)
                    .flatMap(file -> submit(api, file).stream())
                    .collect(Collectors.toList());

            System.out.println(new ObjectMapper().writeValueAsString(results));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
