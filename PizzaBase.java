package com.gowthamrajk.pizzastore;

public class PizzaBase {
	
	private String baseName;
	private String baseType;
	private String description;
	
	public PizzaBase(String baseName, String baseType, String description) {
		this.baseName = baseName;
		this.baseType = baseType;
		this.description = description;
	}

	public String getBaseName() {
		return baseName;
	}

	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		
		return "\nPizza Base Details => BaseName : " + baseName + ", Type : " + baseType + ", Description : " 
		       + description;
	}
}
