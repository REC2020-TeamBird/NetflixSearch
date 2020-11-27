package com.teambird.netflixsearch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReader {

    private final String fileName;
    private final File file;

    public FileReader(String fileName) {
        this.fileName = fileName;

        file = new File(fileName);

        if (!file.exists()) {
            System.out.printf("Unable to find file %s in path %s!", fileName, file.getAbsolutePath());
            System.exit(0);
        }
    }

    public List<String> getData() {
        List<String> data = null;

        try {
            data = Files.readAllLines(this.file.toPath());

            // Removes the first row containing the CSV headers.
            data.remove(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
