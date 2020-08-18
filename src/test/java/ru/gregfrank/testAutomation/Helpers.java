package ru.gregfrank.testAutomation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

public class Helpers {

    public static void deleteDir(String dir) throws IOException {

        Path path = Paths.get(dir);

        // read java doc, Files.walk need close the resources.
        // try-with-resources to ensure that the stream's open directories are closed
        if (Files.isDirectory(path)) {
            try (Stream<Path> walk = Files.walk(path)) {
                walk
                        .sorted(Comparator.reverseOrder())
                        .forEach(Helpers::deleteDirectory);
            }
        }

    }

    private static void deleteDirectory(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            System.out.printf("Unable to delete this path : %s%n%s", path, e);
        }
    }
}
