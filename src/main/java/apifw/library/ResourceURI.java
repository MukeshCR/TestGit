package apifw.library;

public enum ResourceURI {
	
	GET_ACCESS_TOKEN("GetToken"),
	GET_USER_AUTHENTICATION("MagicJson"),
	GET_PATIENT_LIST("patients"),
	POST_NEW_PATIENT("patients");
	

	String uri;

	ResourceURI(String uri) {
		this.uri = uri;
	}

	public String getUri() {
		return this.uri;
	}

}
