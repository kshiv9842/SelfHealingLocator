package org.Shiv.data;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginProps {
    private String pageHeading;
    private String titleOfLandingPage;
    private String emptyMobileFieldErrorMessage;
    private String invalidMobilenoFormatErrorMessage;
    private String invalid_password_error_message;
    private String invalid_mobileno_format_alert_message;
}
