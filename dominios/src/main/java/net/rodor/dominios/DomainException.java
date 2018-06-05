package net.rodor.dominios;

public class DomainException extends Exception{

	
	private static final long serialVersionUID = -2782703174668106355L;
	
	public static final String NULL_DOMAIN = "El dominio no puede ser nulo o cadena vacia";
	public static final String NULL_SUBDOMAIN = "El subdominio no puede ser nulo o cadena vacia";
	public static final String NULL_CODE = "El codigo no puede ser nulo o cadena vacia";
	public static final String NULL_APP = "La aplicacion no puede ser nulo o cadena vacia";
	
	public DomainException(String message) {
		super(message);
	}

	
}
