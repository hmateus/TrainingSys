package br.com.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class FacesUtil {

	private FacesUtil() {
	}
	
	public ExternalContext getContextoExterno(){
		return FacesContext.getCurrentInstance().getExternalContext();
	}
	
	
}
