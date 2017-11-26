package com.github.rodolfoba.api.backend;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "hello")
@JsonSerialize(include = Inclusion.NON_EMPTY)
public class HelloEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "greeting_message", value = "Greeting Message")
	@JsonProperty("greeting_message")
	public String greetingMessage = "Olá";
	
	@ApiModelProperty(name = "greeting_language", value = "Greeting Language")
	@JsonProperty("greeting_language")
	public String greetingLanguage = "pt-BR";
	
	@ApiModelProperty(name = "null_field", value = "Null Field")
	@JsonProperty("null_field")
	public String nullField = null;
	
	@JsonIgnore
	public transient String ignoredField = "IGNORED";
	
}
