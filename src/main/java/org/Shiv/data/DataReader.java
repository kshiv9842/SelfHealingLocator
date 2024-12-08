package org.Shiv.data;

import static java.lang.System.getProperty;
import static java.lang.System.getenv;
import static java.util.Optional.ofNullable;

import java.nio.file.Path;

import lombok.Getter;
import org.Shiv.utils.JsonUtil;

@Getter
public class DataReader {

    public static LoginProps readLoginProps () {
        LoginProps loginProps = null;
        if (loginProps == null) {
            final var defaultPath = Path.of (getProperty ("user.dir"), "src/main/resources/")
                    .toString ();
            final var configDirectory = ofNullable (getenv ("LOGIN_PROPS_PATH")).orElse (
                    ofNullable (getProperty ("login.props.path")).orElse (defaultPath));
            final var configPath = Path.of (configDirectory, "login_props.json")
                    .toString ();
            loginProps = JsonUtil.fromFile (configPath, LoginProps.class);
        }
        return loginProps;
    }
}