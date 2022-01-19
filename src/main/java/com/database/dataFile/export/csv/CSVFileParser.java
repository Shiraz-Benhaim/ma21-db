package com.database.dataFile.export.csv;

import com.database.dataFile.export.DataFileParser;
import com.database.exceptions.FailedToParseDataFileException;
import com.database.fileHandler.ReadFileContent;
import com.database.utils.StringSplitter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class CSVFileParser extends DataFileParser {
    public CSVFileParser(String srcFile) {
        super(srcFile);
    }

    @Override
    public List<String[]> parseDataFileToLists() throws FileNotFoundException, FailedToParseDataFileException{
        List<String[]> data = null;

        StringSplitter stringSplitter = new StringSplitter();

        try {
            ReadFileContent readFileContent = new ReadFileContent(super.srcFile);
            data = stringSplitter.splitStringInCsvFormat(readFileContent.readContent());
        } catch (IOException e) {
            throw new FileNotFoundException("CSV file not found");
        } catch (Exception e) {
            throw new FailedToParseDataFileException("Bad syntax of csv file");
        }

        return data;
    }
}
