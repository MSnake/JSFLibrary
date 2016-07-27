package web.validators;

import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("web.validators.LoginValidator")
public class LoginValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String str = value.toString().trim().toLowerCase();
        ResourceBundle bundle = ResourceBundle.getBundle("web.nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
            if (str.length() < 5) {
                FacesMessage message = new FacesMessage(bundle.getString("login_length_error"));
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        
            if (str.equals("login") | str.equals("username"))
            {
                FacesMessage message = new FacesMessage(bundle.getString("login_login_error"));
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);  
            }
            char a = str.charAt(0);
            
            if (Character.isDigit(a))
            {
                FacesMessage message = new FacesMessage(bundle.getString("login_dignits_error"));
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);  
            }
        }
    
}
