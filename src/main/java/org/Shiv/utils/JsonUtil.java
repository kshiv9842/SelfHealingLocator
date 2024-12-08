package org.Shiv.utils;

import static com.google.common.reflect.TypeToken.of;
import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
import static org.Shiv.utils.ErrorHandler.handleAndThrow;
import static org.apache.logging.log4j.LogManager.getLogger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import org.Shiv.enums.Message;
import org.apache.logging.log4j.Logger;

public class JsonUtil {
    private static final Gson   GSON;
    private static final Logger LOGGER = getLogger ();

    static {
        GSON = new GsonBuilder ().setFieldNamingPolicy (LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting ()
                .create ();
    }

    /**
     * Reads the JSON file.
     *
     * @param filePath the file path to be read
     * @param objectClass the class of the object where data will be saved
     * @param <T> the type of the object
     *
     * @return the object instance
     */
    public static <T> T fromFile (final String filePath, final Class<T> objectClass) {
        LOGGER.traceEntry ("filePath: {}, objectClass: {}", filePath, objectClass);
        LOGGER.info ("");
        T result = null;
        try (final var reader = new FileReader (filePath)) {
            result = GSON.fromJson (reader, of (objectClass).getType ());
        } catch (final FileNotFoundException e) {
            handleAndThrow (Message.NO_JSON_FILE_FOUND, e, filePath);
        } catch (final JsonSyntaxException e) {
            handleAndThrow (Message.JSON_SYNTAX_ERROR, e);
        } catch (final IOException e) {
            handleAndThrow (Message.ERROR_READING_FILE, e, filePath);
        }
        return LOGGER.traceExit (result);
    }
}
