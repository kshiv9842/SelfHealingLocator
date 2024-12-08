package org.Shiv.utils;

import static java.text.MessageFormat.format;
import static org.apache.logging.log4j.LogManager.getLogger;

import java.util.ArrayList;

import org.Shiv.enums.Message;
import org.Shiv.exception.FrameworkError;
import org.apache.logging.log4j.Logger;

/**
 * Error handler utility class.
 *
 * @author Rahul Rana
 * @since 24-Jul-2022
 */
public final class ErrorHandler {
    private static final Logger LOGGER = getLogger ();

    /**
     * Handles the exceptions, prints the stack trace and throws wrapped Error.
     *
     * @param message Error message.
     * @param cause Error cause.
     * @param args Error message arguments.
     */
    public static void handleAndThrow (final Message message, final Throwable cause, final Object... args) {
        var throwable = cause;
        final var stack = new ArrayList<> ();
        stack.add (format ("Error occurred: ({0})", throwable.getClass ()
                .getName ()));
        final var stackTrace = "\tat {0}: {1} Line Number: {2}";
        do {
            if (stack.size () > 1) {
                stack.add (format ("Caused by: ({0})", throwable.getClass ()));
            }
            stack.add (format ("Message: {0}", throwable.getMessage ()));
            for (final var trace : cause.getStackTrace ()) {
                stack.add (format (stackTrace, trace.getClassName (), trace.getMethodName (), trace.getLineNumber ()));
            }
            throwable = throwable.getCause ();
        } while (throwable != null);
        stack.forEach (LOGGER::error);
        throw new FrameworkError (format (message.getMessageText (), args), cause);
    }

    /**
     * Null check the subject, throw Framework Error if the subject is `null`
     *
     * @param subject Object subject to check
     * @param throwMessage Message to throw Error with
     * @param args Args for the message
     * @param <T> Type of subject
     *
     * @return Returns subject if not null
     */
    public static <T> T requireNonNull (final T subject, final Message throwMessage, final Object... args) {
        if (subject == null) {
            throwError (throwMessage, args);
        }
        return subject;
    }

    /**
     * Throws framework error with provided message.
     *
     * @param message Error message
     * @param args message args
     */
    public static void throwError (final Message message, final Object... args) {
        throw new FrameworkError (format (message.getMessageText (), args));
    }

    private ErrorHandler () {
        // Utility class.
    }

}

